package com.boulderdash.principal;

import com.boulderdash.audio.Audio;
import com.boulderdash.entradasalida.BDLevelReader;
import com.boulderdash.interfaz.Gui;
import com.boulderdash.personajes.Ameba;
import com.boulderdash.personajes.Diamante;
import com.boulderdash.personajes.Luciernaga;
import com.boulderdash.personajes.Mariposa;
import com.boulderdash.personajes.MuroMagico;
import com.boulderdash.personajes.MuroTitanio;
import com.boulderdash.personajes.Personaje;
import com.boulderdash.personajes.PuertaDeSalida;
import com.boulderdash.personajes.Roca;
import com.boulderdash.personajes.Rockford;
import com.boulderdash.personajes.Suciedad;
import com.boulderdash.personajes.Vacio;

public class Mapa {
	
	private static int nivelActual = 1;
	private static int puntuacionAcumulada = 0;
	private int puntuacionNivel = 0; //Se reinicia cada vez que muero
	private static int vidas = 4;
	private int tiempoRestante;
	private Personaje[][] mapa; 
	private static int diamantesRestantes;
	private static Mapa instancia = null; 
	
	private static int[] valorDiamante = {0,10,20,15,5,30,50,40,10,10,10};//Guarda el valor del diamante base por nivel
	private static int[] valorDiamanteBonus = {0,15,50,0,20,0,90,60,20,20,0};//Guarda el valor del diamante bonus por nivel
	private static int[] tiempo = {0,110,110,100,100,100,120,110,110,130,150};//Guarda el valor del timer por nivel
	
	public static Mapa getInstancia(){
		if(instancia == null){
			instancia = new Mapa();
		}
		return instancia;
	}

	
	/**
	 * Esencia del juego. Crea el nivel solicitado.
	 * @throws Exception .
	 */
	private Mapa ()
	{
		BDLevelReader lectorNiveles = new BDLevelReader();
		try {
			lectorNiveles.readLevels("levels.xml");
			lectorNiveles.setCurrentLevel(nivelActual);
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		mapa = new Personaje[lectorNiveles.getWIDTH()][lectorNiveles.getHEIGHT()];
		setDiamantesRestantes(lectorNiveles.getDiamondsNeeded());
		tiempoRestante = tiempo[this.getNivelActual()];
		Diamante.setValorDiamante(valorDiamante[this.getNivelActual()]);
		for(int x=0;x<lectorNiveles.getWIDTH();x++){
			for(int y=0;y<lectorNiveles.getHEIGHT();y++){
				switch(lectorNiveles.getTile(x,y)){
					case EMPTY:{
						mapa[x][y]=new Vacio(x,y);
						break;
					}
					case DIRT:{
						mapa[x][y]=new Suciedad(x,y);
						break;
					}
					case TITANIUM:{
						mapa[x][y]=new MuroTitanio(x,y);
						break;
					}
					case WALL:{
						mapa[x][y]=new MuroMagico(x,y);
						break;
					}
					case ROCK:{
						mapa[x][y]=new Roca(false,x,y);
						break;
					}
					case FALLINGROCK:{
						mapa[x][y]=new Roca(true,x,y);
						break;
					}
					case DIAMOND:{
						mapa[x][y]=new Diamante(false,x,y);
						break;
					}
					case FALLINGDIAMOND:{
						mapa[x][y]=new Diamante(true,x,y);
						break;
					}
					case AMOEBA:{
						mapa[x][y]=new Ameba(x,y);
						break;
					}
					case FIREFLY:{
						mapa[x][y]=new Luciernaga(x,y);
						break;
					}
					case BUTTERFLY:{
						mapa[x][y]=new Mariposa(x,y);
						break;
					}
					case EXIT:{
						mapa[x][y]=new PuertaDeSalida(x,y);
						break;
					}
					case PLAYER:{
						mapa[x][y]=Rockford.getInstancia().setPosicion(x,y);
						break;
					}
				}
			}
		}
	}
	
	public void avanzarDeNivel()
	{
		setPuntuacionAcumulada(getInstancia().getPuntuacionNivel() + getPuntuacionAcumulada() + tiempoRestante);
		Audio.pararMusica();
		setNivelActual(this.getNivelActual() + 1);
		Audio.musica();
		this.setVidas(4);
		reconstruirMapa();
	}
	
	public Personaje getPersonaje(Posicion pos){
		return this.mapa[pos.getX()][pos.getY()];
	}

	public void setPersonaje(Personaje pers, Posicion pos){
		mapa[pos.getX()][pos.getY()] = pers;
	}
	
	public void reconstruirMapa (){
		
		instancia = new Mapa();
		System.out.println("El mapa se acaba de reconstruir");
		Gui.getInstancia().getMatriz().reconstruir();
	}
	
	
	public void construirMapa (){
		
		instancia = new Mapa();
		vidas = 4; //Se restauran las vidas
		System.out.println("El mapa se acaba de construir");
	}
	
	public void setNivelActual(int nivel){
		Mapa.nivelActual = nivel;
	}
	
	public int getNivelActual(){
		return Mapa.nivelActual;
	}
	
	public void setVidas(int vidas){
		Mapa.vidas = vidas;
		
	}
	
	public int getVidas(){
		return Mapa.vidas;
		
	}
	
	
	public Personaje[][] getMapa(){
		return this.mapa;
	}


	public static int getDiamantesRestantes() {
		return diamantesRestantes;
	}


	public static void setDiamantesRestantes(int diamantesRestantes) {
		Mapa.diamantesRestantes = diamantesRestantes;
	}


	public static int getPuntuacionAcumulada() {
		return puntuacionAcumulada;
	}


	public static void setPuntuacionAcumulada(int puntuacionAcumulada) {
		Mapa.puntuacionAcumulada = puntuacionAcumulada;
	}


	public int getPuntuacionNivel() {
		return puntuacionNivel;
	}


	public void setPuntuacionNivel(int puntuacionNivel) {
		this.puntuacionNivel = puntuacionNivel;
	}


	public static int[] getValorDiamanteBonus() {
		return valorDiamanteBonus;
	}


	public static void setValorDiamanteBonus(int[] valorDiamanteBonus) {
		Mapa.valorDiamanteBonus = valorDiamanteBonus;
	}
	
	public int getTiempoRestante() {
		return tiempoRestante;
	}


	public void decrementarTiempoRestante() {
		this.tiempoRestante--;
	}


	
}

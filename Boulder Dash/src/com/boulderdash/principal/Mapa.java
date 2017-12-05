package com.boulderdash.principal;

import com.boulderdash.entradasalida.BDLevelReader;
import com.boulderdash.entradasalida.OpcionesES;
import com.boulderdash.personajes.Ameba;
import com.boulderdash.personajes.Diamante;
import com.boulderdash.personajes.Luciernaga;
import com.boulderdash.personajes.Mariposa;
import com.boulderdash.personajes.MuroComun;
import com.boulderdash.personajes.MuroMagico;
import com.boulderdash.personajes.MuroTitanio;
import com.boulderdash.personajes.Personaje;
import com.boulderdash.personajes.PuertaDeSalida;
import com.boulderdash.personajes.Roca;
import com.boulderdash.personajes.Rockford;
import com.boulderdash.personajes.Suciedad;
import com.boulderdash.personajes.Vacio;
import java.util.Random;

/**
 * Clase utilizada para modelizar el mapa, es un singleton ya que habra una sola instancia del mismo
 */
public class Mapa {
	
	private static int nivelActual = OpcionesES.getNivel();
	private static int puntuacionAcumulada = 0;
	private static int tiempoAcumulado = 0;
	private int puntuacionNivel = 0; //Se reinicia cada vez que muero
	private static int vidas = 4;
	private int tiempoRestante;
	private Personaje[][] mapa; 
	private static int diamantesRestantes;
	private static Mapa instancia = null;
	private Random generador = new Random();
	private static boolean hayUnaAmeba = false;
	private static int[] valorDiamante = {0,10,20,15,5,30,50,40,10,10,10};//Guarda el valor del diamante base por nivel
	private static int[] valorDiamanteBonus = {0,15,50,0,20,0,90,60,20,20,0};//Guarda el valor del diamante bonus por nivel
	private static int[] tiempo = {0,110,110,100,100,100,120,110,110,130,150};//Guarda el valor del timer por nivel
	
	/**
	 * Permite obtener la instancia del mapa, ya que este es singleton.
	 * @return Instancia de mapa.
	 */
	public static Mapa getInstancia(){
		if(instancia == null){
			instancia = new Mapa();
		}
		return instancia;
	}

	
	/**
	 * Esencia del juego. Crea el nivel solicitado.
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
						amebaOSuciedad(x,y);				
						break;
					}
					case TITANIUM:{
						mapa[x][y]=new MuroTitanio(x,y);
						break;
					}
					case WALL:{
						comunOMagico(x,y);
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
	
	/**
	 * Permite llamar al comportamiento para cambiar de nivel.
	 */
	public void avanzarDeNivel()
	{
		Comportamiento.cambiarDeNivel();
	}
	
	
	/**
	 * Reconstruye el mapa dependiendo el nivel.
	 */
	public void reconstruirMapa (){
		instancia = new Mapa();
		System.out.println("El mapa se acaba de reconstruir");
		Comportamiento.refrescarDiamantesNivel();
		hayUnaAmeba = false;
	}
	
	/**
	 * Se utiliza la primera vez que se construye el mapa, al inicializar el juego.
	 */
	public void construirMapa (){	
		Mapa.getInstancia().setNivelActual(OpcionesES.getNivel());
		instancia = new Mapa();
		vidas = 4 ; //Se restauran las vidas
		System.out.println("El mapa se acaba de construir");
		Comportamiento.refrescarDiamantesNivel();
		hayUnaAmeba = false;
	}
	
	/**
	 * Metodo que se encarga de determinar aleatoriamente si el muro sera magico o comun.
	 * @param x Posicion en x del objeto
	 * @param y Posicion en y del objeto
	 */
	private void comunOMagico(int x, int y) {
		if (generador.nextInt(100) == 77 && (y < 21) && (y > 0)) {
			mapa[x][y]=new MuroMagico(x,y);
		}
		else {
			mapa[x][y]=new MuroComun(x,y);
		}
	}
	
	/**
	 * Metodo que se encarga de determinar aleatoriamente si se genera ameba o suciedad.
	 * @param x Posicion en x del objeto
	 * @param y Posicion en y del objeto
	 */
	private void amebaOSuciedad(int x, int y) {		
		if (generador.nextInt(11100) == 77 && !hayUnaAmeba) {
			mapa[x][y]=new Ameba(x,y);
			hayUnaAmeba=true;
		}	
		else {
			mapa[x][y]= new Suciedad(x,y);
		}
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
	
	public int getTiempoRestante() {
		return tiempoRestante;
	}


	public void decrementarTiempoRestante() {
		this.tiempoRestante--;
	}


	public static int getTiempoAcumulado() {
		return tiempoAcumulado;
	}


	public static void setTiempoAcumulado(int tiempoAcumulado) {
		Mapa.tiempoAcumulado = tiempoAcumulado;
	}
	
	public Personaje getPersonaje(Posicion pos){
		return this.mapa[pos.getX()][pos.getY()];
	}

	public void setPersonaje(Personaje pers, Posicion pos){
		mapa[pos.getX()][pos.getY()] = pers;
	}
}


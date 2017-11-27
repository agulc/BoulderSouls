package com.boulderdash.principal;

import com.boulderdash.audio.Audio;
import com.boulderdash.entradasalida.Highscore;
import com.boulderdash.entradasalida.OpcionesES;
import com.boulderdash.interfaz.Gui;
import com.boulderdash.interfaz.GuiHUD;
import com.boulderdash.interfaz.GuiMuerte;
import com.boulderdash.personajes.Rockford;

public class Comportamiento {
	/**
	 * Crea el mapa del nivel seleccionado.
	 * @throws Exception .
	 */
	
	private static boolean rockfordMuerto = false;
	private static boolean muerteExtra = false; //Activa la muerte extra
	private static boolean piedrasConInercia = false; //Activa la muerte extra
	

	public static void setRockfordMuerto (boolean bool)
	{
		rockfordMuerto = bool; //Para dejar de actualizar objetos al morir
	}
	
	public static void Inicializar(){
		Mapa.getInstancia();
		Mapa.getInstancia().setNivelActual(OpcionesES.getNivel());
		Mapa.getInstancia().construirMapa();
		actualizarEstadoObjeto();
		CoordinadorDeEventos.iniciarTemporizador();
	}
	
	public static void Reinicializar(){
		rockfordMuerto = false;
		Mapa.getInstancia().construirMapa();
		actualizarEstadoObjeto();
		CoordinadorDeEventos.iniciarTemporizador();
	}
	/**
	 * Ciclo normal del juego una vez que fue inicializado.
	 * Solo se actualiza al graficar, ya que en esta etapa el juego funciona por "turnos".
	 * @param donde Dirección
	 * @throws Exception .
	 */
	public static void comportamientoNormal(){
		
		moverPersonajes();
		Gui.getInstancia().getMatriz().reconstruir();
		actualizarEstadoObjeto();
		
		//System.out.println(Mapa.getInstancia().getPuntuacionNivel());
		
	}
	
	public static void reconstruir(){
		Gui.getInstancia().getMatriz().reconstruir();
		GuiHUD.setDiamantesNivel(Mapa.getDiamantesRestantes());
	}
	
	public static void refrescarDiamantesNivel(){
		GuiHUD.setDiamantesNivel(Mapa.getDiamantesRestantes());
	}
	
	
	/**
	 * Se encarga de modificar la posición de cada objeto (salvo Rockford) del nivel en cada turno.
	 * @throws Exception .
	 */
	private static void moverPersonajes(){
		Posicion pos = new Posicion();
		Rockford.getInstancia().moverPersonajes();
		for (int y = 0; y < 22 && !rockfordMuerto; y++)  
		{
			for (int x = 0; x < 40 && !rockfordMuerto; x++)
			{
				pos.setX(x);
				pos.setY(y);
				Mapa.getInstancia().getPersonaje(pos).moverPersonajes();
			}
		}
			
		
		if (rockfordMuerto)
		{
			if (Mapa.getInstancia().getVidas() == 0) {
				Gui.getInstancia().getMatriz().reconstruir();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				CoordinadorDeEventos.detenerTemporizador();
				Audio.hasMuerto();
				GuiMuerte.muerte();
			}
			else {
			Gui.getInstancia().getMatriz().reconstruir();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Mapa.getInstancia().reconstruirMapa();
			setRockfordMuerto(false);
			}
		}
	}
	/**
	 * Actualiza el estado de cada objeto respecto a que debe realizar en ese turno. 
	 * El resultado final dependerá del objeto que se esté actualizando.
	 * @throws Exception .
	 */
	private static void actualizarEstadoObjeto(){
		Posicion pos = new Posicion();
		for (int y = 0; y < 22; y++)  {
			for (int x = 0; x < 40; x++) {
				pos.setX(x);
				pos.setY(y);
				Mapa.getInstancia().getPersonaje(pos).actualizarEstadoObjeto();
			}
		}
	}
	
	public static void cambiarDeNivel(){
		if(Mapa.getInstancia().getNivelActual()<10){
			Mapa.setPuntuacionAcumulada(Mapa.getInstancia().getPuntuacionNivel() + Mapa.getPuntuacionAcumulada() + Mapa.getInstancia().getTiempoRestante());
			Audio.pararMusica();
			Mapa.getInstancia().setNivelActual(Mapa.getInstancia().getNivelActual() + 1);
			Audio.musica();
			Mapa.getInstancia().setVidas(4);
			Mapa.getInstancia().reconstruirMapa();
		}
		else{
			Mapa.setPuntuacionAcumulada(Mapa.getInstancia().getPuntuacionNivel() + Mapa.getPuntuacionAcumulada() + Mapa.getInstancia().getTiempoRestante());
			Audio.pararMusica();
			Gui.getInstancia().remove(Gui.getInstancia().getJuego());
			Highscore high = new Highscore("",Mapa.getPuntuacionAcumulada(),Mapa.getTiempoAcumulado());
			
			if (Highscore.highscoreValido(high))
			{
				Gui.getInstancia().getNuevoHighscore().menuNuevoHighscore(high);
			}
			else
			{
				Gui.getInstancia().getTitulo().volverAlTitulo();
			}
		}
	}

	public static boolean getMuerteExtra() {
		return muerteExtra;
	}

	public static void setMuerteExtra(boolean muerteExtra) {
		Comportamiento.muerteExtra = muerteExtra;
	}

	public static boolean getPiedrasConInercia() {
		return piedrasConInercia;
	}

	public static void setPiedrasConInercia(boolean piedrasConInercia) {
		Comportamiento.piedrasConInercia = piedrasConInercia;
	}
	
}

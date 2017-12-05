package com.boulderdash.principal;

import com.boulderdash.audio.Audio;
import com.boulderdash.entradasalida.MejorPuntuacion;
import com.boulderdash.entradasalida.OpcionesES;
import com.boulderdash.interfaz.Gui;
import com.boulderdash.interfaz.GuiHUD;
import com.boulderdash.interfaz.GuiMuerte;
import com.boulderdash.personajes.Rockford;

/**
 * Clase utilizada para manejar el comportamiento en general del juego
 */
public class Comportamiento {
	
	private static boolean rockfordMuerto = false;
	private static boolean muerteExtra = false; //Activa la muerte extra
	private static boolean piedrasConInercia = false; //Activa la muerte extra
	
	/**
	 * Inicializa el juego por primera vez, seteando su nivel e inicializando el temporizador
	 */
	public static void Inicializar(){
		Mapa.getInstancia();
		Mapa.getInstancia().setNivelActual(OpcionesES.getNivel());
		actualizarEstadoObjeto();
		CoordinadorDeEventos.iniciarTemporizador();
	}
	
	/**
	 * Inicializa el juego nuevamente, luego de haber muerto
	 */
	public static void Reinicializar(){
		rockfordMuerto = false;
		Mapa.getInstancia().construirMapa();
		actualizarEstadoObjeto();
		CoordinadorDeEventos.iniciarTemporizador();
	}
	/**
	 * Ciclo normal del juego una vez que fue inicializado.
	 */
	public static void comportamientoNormal(){
		
		moverPersonajes();
		Gui.getInstancia().getMatriz().reconstruir();
		actualizarEstadoObjeto();
		
	}
	
	/**
	 * Reconstruye la interfaz grafica del mapa
	 */
	public static void reconstruir(){
		Gui.getInstancia().getMatriz().reconstruir();
		GuiHUD.setDiamantesNivel(Mapa.getDiamantesRestantes());
	}
	
	/**
	 * Refresca los diamantes del nivel en el hud del juego
	 */
	public static void refrescarDiamantesNivel(){
		GuiHUD.setDiamantesNivel(Mapa.getDiamantesRestantes());
	}
	
	
	/**
	 * Se encarga de modificar la posición de cada objeto del nivel en cada turno.
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
	
	/**
	 * Se encarga de cambiar de nivel al llegar a la puerta de salida
	 */
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
			MejorPuntuacion high = new MejorPuntuacion("",Mapa.getPuntuacionAcumulada(),Mapa.getTiempoAcumulado());
			
			if (MejorPuntuacion.highscoreValido(high))
			{
				Gui.getInstancia().getNuevaMejorPuntuacion().menuNuevaMejorPuntuacion(high);
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
	
	public static void setRockfordMuerto (boolean bool)
	{
		rockfordMuerto = bool; //Para dejar de actualizar objetos al morir
	}
	
	public static boolean getRockfordMuerto () {
		return rockfordMuerto;
	}
	
}

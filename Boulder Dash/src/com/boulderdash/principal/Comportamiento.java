package com.boulderdash.principal;

import com.boulderdash.audio.Audio;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.personajes.Rockford;

public class Comportamiento {
	/**
	 * Crea el mapa del nivel seleccionado.
	 * @throws Exception .
	 */
	
	private static boolean rockfordMuerto = false;
	private static boolean muerteExtra = false; //Activa la muerte extra

	
	
	public static void setRockfordMuerto (boolean bool)
	{
		rockfordMuerto = bool; //Para dejar de actualizar objetos al morir
	}
	
	public static void Inicializar(){
		Mapa.getInstancia();
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
		actualizarEstadoObjeto();
		
	}
	
	/**
	 * Se encarga de modificar la posición de cada objeto (salvo Rockford) del nivel en cada turno.
	 * @throws Exception .
	 */
	private static void moverPersonajes(){
		Posicion pos = new Posicion();
		for (int y = 21; y >= 0 && !rockfordMuerto; y--)  {
			for (int x = 39; x >= 0 && !rockfordMuerto; x--) {
				pos.setX(x);
				pos.setY(y);
				Mapa.getInstancia().getPersonaje(pos).moverPersonajes();
			}
		}
		if (rockfordMuerto)
		{
			if (Mapa.getInstancia().getVidas() == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Audio.hasMuerto();
				Gui.getInstancia().hasMuerto();
				CoordinadorDeEventos.detenerTemporizador();
			}
			else {
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
	
	public static void moverARockford(ParaDonde donde){
		if(!rockfordMuerto) {
			Rockford.getInstancia().mover(donde);
		}
	}

	public static boolean getMuerteExtra() {
		return muerteExtra;
	}

	public static void setMuerteExtra(boolean muerteExtra) {
		Comportamiento.muerteExtra = muerteExtra;
	}
	
}

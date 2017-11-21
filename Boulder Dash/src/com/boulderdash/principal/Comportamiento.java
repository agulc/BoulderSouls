package com.boulderdash.principal;

import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.personajes.Rockford;

public class Comportamiento {
	/**
	 * Crea el mapa del nivel seleccionado.
	 * @throws Exception .
	 */
	
	private static boolean rockfordMuerto = false;

	
	public static void setRockfordMuerto (boolean bool)
	{
		rockfordMuerto = bool; //Para dejar de actualizar objetos al morir
	}
	
	public static void Inicializar(){
		Mapa.getInstancia();
		//graficarMapa();
		actualizarEstadoObjeto();
		CoordinadorDeEventos.iniciarTemporizador();
		Mapa.getInstancia().setNivelActual(4);
		Mapa.getInstancia().reconstruirMapa();
	}
	/**
	 * Ciclo normal del juego una vez que fue inicializado.
	 * Solo se actualiza al graficar, ya que en esta etapa el juego funciona por "turnos".
	 * @param donde Dirección
	 * @throws Exception .
	 */
	public static void comportamientoNormal(){
		
		moverPersonajes();
		//graficarMapa();
		actualizarEstadoObjeto();
	}
	/**
	 * Grafica la posición en el mapa de todos los objetos una vez que se termina el turno.
	 * @throws Exception .
	 */
	public static void graficarMapa(){
		Posicion pos = new Posicion();
		for (int y = 0; y < 22; y++)  {
			for (int x = 0; x < 40; x++) {
				pos.setX(x);
				pos.setY(y);
				System.out.print(Mapa.getInstancia().getPersonaje(pos).getGraficos()+" ");
				
			}
			System.out.println();
		}
		System.out.println("Faltan " + Mapa.getDiamantesRestantes() + " diamantes para poder escapar!!!!");
		System.out.println();
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
		Rockford.getInstancia().mover(donde);
	}
	
}

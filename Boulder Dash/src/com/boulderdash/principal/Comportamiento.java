package com.boulderdash.principal;

import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.personajes.Rockford;

public class Comportamiento {
	/**
	 * Crea el mapa del nivel seleccionado.
	 * @throws Exception .
	 */
	
	public static void Inicializar(){
		Mapa.getInstancia();
		graficarMapa();
		actualizarEstadoObjeto();
	}
	/**
	 * Ciclo normal del juego una vez que fue inicializado.
	 * Solo se actualiza al graficar, ya que en esta etapa el juego funciona por "turnos".
	 * @param donde Direcci�n
	 * @throws Exception .
	 */
	public static void comportamientoNormal(ParaDonde donde){
		
		moverPersonajes();
		moverARockford(donde);
		graficarMapa();
		actualizarEstadoObjeto();
	}
	/**
	 * Grafica la posici�n en el mapa de todos los objetos una vez que se termina el turno.
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
	 * Se encarga de modificar la posici�n de cada objeto (salvo Rockford) del nivel en cada turno.
	 * @throws Exception .
	 */
	private static void moverPersonajes(){
		Posicion pos = new Posicion();
		for (int y = 0; y < 22; y++)  {
			for (int x = 0; x < 40; x++) {
				pos.setX(x);
				pos.setY(y);
				Mapa.getInstancia().getPersonaje(pos).moverPersonajes();
			}
		}
	}
	/**
	 * Actualiza el estado de cada objeto respecto a que debe realizar en ese turno. 
	 * El resultado final depender� del objeto que se est� actualizando.
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
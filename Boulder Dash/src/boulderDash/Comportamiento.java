package boulderDash;

import java.util.Scanner;

public class Comportamiento {
	/**
	 * Crea el mapa del nivel seleccionado.
	 * @throws Exception
	 */
	
	public static void Inicializar() throws Exception{
		/*Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el nivel que desea: ");
		int nivel = scanner.nextInt();
		scanner.close();
		Mapa.getInstancia().setNivelActual(nivel);*/
		Mapa.getInstancia();
		graficarMapa();
		actualizarEstadoObjeto();
	}
	/**
	 * Ciclio normal del juego una vez que fué inicializado.
	 * Solo se actualiza al graficar, ya que en esta etapa el juego funciona por "turnos".
	 * @param donde
	 * @throws Exception
	 */
	public static void comportamientoNormal(ParaDonde donde) throws Exception{
		
		moverPersonajes();
		moverARockford(donde);
		graficarMapa();
		actualizarEstadoObjeto();
	}
	/**
	 * Refrezca la posición en el mapa de todos los objetos una vez que se termina el turno.
	 * @throws Exception
	 */
	public static void graficarMapa() throws Exception{
		Posicion pos = new Posicion();
		for (int y = 0; y < 22; y++)  {
			for (int x = 0; x < 40; x++) {
				pos.setX(x);
				pos.setY(y);
				System.out.print(Mapa.getInstancia().getPersonaje(pos).getClass().getName()+",");
			}
			System.out.println();
		}
		System.out.println("Faltan " + Mapa.diamantesRestantes + " diamantes para poder escapar!!!!");
		System.out.println();
	}
	/**
	 * Se encarga de modificar la posición de cada objeto (salvo Rockford) del nivel en cada turno.
	 * @throws Exception
	 */
	private static void moverPersonajes() throws Exception{
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
	 * Actualiza el estado de cada objeto respecto a que deve realizar en ese turno. 
	 * El resultado final dependerá del objeto que se esté actualizando.
	 * @throws Exception
	 */
	private static void actualizarEstadoObjeto() throws Exception{
		Posicion pos = new Posicion();
		for (int y = 0; y < 22; y++)  {
			for (int x = 0; x < 40; x++) {
				pos.setX(x);
				pos.setY(y);
				Mapa.getInstancia().getPersonaje(pos).actualizarEstadoObjeto();
			}
		}
	}
	
	public static void moverARockford(ParaDonde donde) throws Exception{
		Rockford.getInstancia().mover(donde);
		
	}
	
}

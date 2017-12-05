package com.boulderdash.principal;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Clase que define un timer con comportamiento definido para coordinar los cuadros por segundo del juego, asi como tambien
 * decrementar el tiempo en el contador
 */
public class CoordinadorDeEventos extends TimerTask {

	public void run() {
			Comportamiento.comportamientoNormal();
	}
	private static Timer reloj;
	private static Timer cuentaAtras;
	
	private static CoordinadorDeEventos tarea;
	private static Contador tarea2;
	
	
	/**
	 * Inicializa los temporizadores, con sus tareas e intervalos de tiempo
	 */
	public static void iniciarTemporizador() {
		reloj = new Timer();
		tarea = new CoordinadorDeEventos();
		cuentaAtras = new Timer();
		tarea2 = new Contador();
		reloj.schedule(tarea, 1, 90);
		cuentaAtras.schedule(tarea2, 1, 1000);
	}
	
	/**
	 * Detiene los temporizadores
	 */
	public static void detenerTemporizador() {
		reloj.cancel();
		reloj.purge();
		cuentaAtras.cancel();
		cuentaAtras.purge();
	}
	
}

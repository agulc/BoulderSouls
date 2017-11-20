package com.boulderdash.principal;
import java.util.Timer;
import java.util.TimerTask;



public class CoordinadorDeEventos extends TimerTask {

	
	public void run() {
		Comportamiento.comportamientoNormal();
	}
	
	private static Timer reloj = new Timer();
	
	private static CoordinadorDeEventos tarea = new CoordinadorDeEventos();
	
	public static void iniciarTemporizador() {

		reloj.schedule(tarea, 0, 120);
	}
	
	public static void detenerTemporizador() {
		reloj.cancel();
	}
	

}

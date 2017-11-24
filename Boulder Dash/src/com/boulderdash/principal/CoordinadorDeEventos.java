package com.boulderdash.principal;
import java.util.Timer;
import java.util.TimerTask;

import com.boulderdash.interfaz.Gui;



public class CoordinadorDeEventos extends TimerTask {

	
	
	public void run() {
			Comportamiento.comportamientoNormal();
			Gui.getInstancia().getMatriz().actualizarImagenes();
	}
	private static Timer reloj = new Timer();;
	
	private static CoordinadorDeEventos tarea;
	
	public static void iniciarTemporizador() {
		reloj = new Timer();
		tarea = new CoordinadorDeEventos();
		reloj.schedule(tarea, 1, 240);
	}
	
	public static void detenerTemporizador() {
		reloj.cancel();
	}
	
}

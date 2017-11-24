package com.boulderdash.principal;
import java.util.Timer;
import java.util.TimerTask;

import com.boulderdash.interfaz.Gui;




public class CoordinadorDeEventos extends TimerTask {

	public void run() {
			Comportamiento.comportamientoNormal();
			Gui.getInstancia().getMatriz().reconstruir();
	}
	private static Timer reloj;
	private static Timer cuentaAtras;
	
	private static CoordinadorDeEventos tarea;
	private static Contador tarea2;
	
	public static void iniciarTemporizador() {
		reloj = new Timer();
		tarea = new CoordinadorDeEventos();
		cuentaAtras = new Timer();
		tarea2 = new Contador();
		reloj.schedule(tarea, 1, 120);
		cuentaAtras.schedule(tarea2, 1, 1000);
	}
	
	public static void detenerTemporizador() {
		reloj.cancel();
		reloj.purge();
		cuentaAtras.cancel();
		cuentaAtras.purge();
	}
	
}

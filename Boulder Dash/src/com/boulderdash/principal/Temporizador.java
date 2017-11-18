package com.boulderdash.principal;
import java.awt.event.*;
import javax.swing.Timer;



public class Temporizador {
	 
	static ActionListener ciclo = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Comportamiento.comportamientoNormal();
		}
	};
	
	static Timer reloj = new Timer (120, ciclo);
	
	public static void iniciarTemporizador() {
		reloj.start();
	}
	public static void detenerTemporizador() {
		reloj.stop();
	}

}

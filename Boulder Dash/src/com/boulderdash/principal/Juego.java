package com.boulderdash.principal;

import com.boulderdash.teclaescucha.MiTeclaEscucha;
import javax.swing.JFrame;


public class Juego{
	/**
	 * Programa principal con los movimientos que Rockford
	 * realizará en los niveles 1 y 2.
	 * @param args .
	 */
	public static void main(String args[]){
		Comportamiento.Inicializar();
		JFrame marco = new JFrame();
		marco.addKeyListener(new MiTeclaEscucha());
		marco.setSize(100, 100);
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
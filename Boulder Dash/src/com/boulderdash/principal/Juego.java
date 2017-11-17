package com.boulderdash.principal;

import com.boulderdash.teclaescucha.MiTeclaEscucha;

import javax.swing.*;

public class Juego {
	/**
	 * Programa principal con los movimientos que Rockford
	 * realizará en los niveles 1 y 2.
	 * @param args .
	 */
	public static void main(String args[]){
		Comportamiento.Inicializar();
		JFrame hola = new JFrame();
		hola.addKeyListener(new MiTeclaEscucha());
		hola.setSize(100, 100);
		hola.setVisible(true);
		System.out.println("Nivel 1 terminado, tu puntaje actual es: "+Mapa.getPuntaje());
	}
}
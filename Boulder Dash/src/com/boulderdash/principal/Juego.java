package com.boulderdash.principal;

import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.teclaescucha.MiTeclaEscucha;

import javax.swing.*;

public class Juego {
	/**
	 * Programa principal con los movimientos que Rockford
	 * realizará en los niveles 1 y 2.
	 * @param args .
	 * @throws Exception .
	 */
	public static void main(String args[]){
		Comportamiento.Inicializar();
		JFrame hola = new JFrame();
		hola.addKeyListener(new MiTeclaEscucha());
		hola.setSize(100, 100);
		hola.setVisible(true);
		System.out.println("Nivel 1 terminado, tu puntaje actual es: "+Mapa.getPuntaje());
		
		
		
		/*Mapa.getInstancia().setNivelActual(2); //Aumenta el nivel
		Mapa.getInstancia().reconstruirMapa(); //Reconstruye el mapa
	
		Comportamiento.comportamientoNormal(ParaDonde.DERECHA);

		for(int i=0;i<3;i++){
			Comportamiento.comportamientoNormal(ParaDonde.ARRIBA);
		}

		for(int i=0;i<14;i++){
			Comportamiento.comportamientoNormal(ParaDonde.IZQUIERDA);
		}
		
		Comportamiento.comportamientoNormal(ParaDonde.ARRIBA);
		System.out.println("Nivel 2 terminado, tu puntaje actual es: "+Mapa.getPuntaje());*/
		
	}
}
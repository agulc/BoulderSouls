package boulderDash;

import java.util.Scanner;

public class Juego {
	/**
	 * Programa principal con los movimientos que Rockford realizará en el nivel 1
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception{
		Comportamiento.Inicializar();
		/*
		Comportamiento.comportamientoNormal(ParaDonde.ABAJO);

		
		for(int i=0;i<7;i++){
			Comportamiento.comportamientoNormal(ParaDonde.DERECHA);
		}
		for(int i=0;i<2;i++){
			Comportamiento.comportamientoNormal(ParaDonde.ARRIBA);
		}
		
		Comportamiento.comportamientoNormal(ParaDonde.DERECHA);
		for(int i=0;i<2;i++){
			Comportamiento.comportamientoNormal(ParaDonde.ABAJO);
		}
		for(int i=0;i<8;i++){
			Comportamiento.comportamientoNormal(ParaDonde.DERECHA);
		}
		for(int i=0;i<2;i++){
			Comportamiento.comportamientoNormal(ParaDonde.ABAJO);
		}
		for(int i=0;i<5;i++){
			Comportamiento.comportamientoNormal(ParaDonde.DERECHA);
		}
		
		System.out.println("Nivel 1 terminado");
		
		
		
		Mapa.getInstancia().setNivelActual(2); //Aumenta el nivel
		Mapa.getInstancia().reconstruirMapa(); //Reconstruye el mapa
		*/
		for(int i=0;i<1;i++){
			Comportamiento.comportamientoNormal(ParaDonde.DERECHA);
		}

		for(int i=0;i<3;i++){
			Comportamiento.comportamientoNormal(ParaDonde.ARRIBA);
		}

		for(int i=0;i<14;i++){
			Comportamiento.comportamientoNormal(ParaDonde.IZQUIERDA);
		}

		for(int i=0;i<1;i++){
			Comportamiento.comportamientoNormal(ParaDonde.ARRIBA);
		}
		System.out.println("Nivel 2 terminado");
		
		
	}
}
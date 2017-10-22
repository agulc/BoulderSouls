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
		Comportamiento.comportamientoNormal(ParaDonde.ABAJO);
		for(int i=0;i<7;i++){
			//Hacerlo con un enumerativo, comportamiento del programa entero en una clase aparte, modelar movimiento en una clase aparte, que devuelva una posicion en vez de un vector
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
		System.out.println("Supuestamente esta todo terminado");
	}
}
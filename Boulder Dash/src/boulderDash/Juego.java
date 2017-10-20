package boulderDash;

import java.util.Scanner;

public class Juego {
	
	public static void main(String args[]) throws Exception{
		Comportamiento.Inicializar();
		Comportamiento.comportamientoNormal(paraDonde.ABAJO);
		for(int i=0;i<7;i++){
			//Hacerlo con un enumerativo, comportamiento del programa entero en una clase aparte, modelar movimiento en una clase aparte, que devuelva una posicion en vez de un vector
			Comportamiento.comportamientoNormal(paraDonde.DERECHA);
		}
		for(int i=0;i<2;i++){
			Comportamiento.comportamientoNormal(paraDonde.ARRIBA);
		}
		Comportamiento.comportamientoNormal(paraDonde.DERECHA);
		for(int i=0;i<2;i++){
			Comportamiento.comportamientoNormal(paraDonde.ABAJO);
		}
		for(int i=0;i<8;i++){
			Comportamiento.comportamientoNormal(paraDonde.DERECHA);
		}
		for(int i=0;i<2;i++){
			Comportamiento.comportamientoNormal(paraDonde.ABAJO);
		}
		for(int i=0;i<5;i++){
			Comportamiento.comportamientoNormal(paraDonde.DERECHA);
		}
		System.out.println("Supuestamente esta todo terminado");
	}
}
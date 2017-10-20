package boulderDash;

import java.util.Scanner;

public class Juego {
	
	public static void main(String args[]) throws Exception{
		Comportamiento.Inicializar();
		Mapa.getInstancia().moverARockford(paraDonde.ABAJO);
		Mapa.getInstancia().graficarMapa();
		for(int i=0;i<7;i++){
			Mapa.getInstancia().moverARockford(paraDonde.DERECHA);//Hacerlo con un enumerativo, comportamiento del programa entero en una clase aparte, modelar movimiento en una clase aparte, que devuelva una posicion en vez de un vector
			Mapa.getInstancia().graficarMapa();
		}
		for(int i=0;i<2;i++){
			Mapa.getInstancia().moverARockford(paraDonde.ARRIBA);
			Mapa.getInstancia().graficarMapa();
		}
		Mapa.getInstancia().moverARockford(paraDonde.DERECHA);
		Mapa.getInstancia().graficarMapa();
		for(int i=0;i<2;i++){
			Mapa.getInstancia().moverARockford(paraDonde.ABAJO);
			Mapa.getInstancia().graficarMapa();
		}
		for(int i=0;i<8;i++){
			Mapa.getInstancia().moverARockford(paraDonde.DERECHA);
			Mapa.getInstancia().graficarMapa();
		}
		for(int i=0;i<2;i++){
			Mapa.getInstancia().moverARockford(paraDonde.ABAJO);
			Mapa.getInstancia().graficarMapa();
		}
		for(int i=0;i<5;i++){
			Mapa.getInstancia().moverARockford(paraDonde.DERECHA);
			Mapa.getInstancia().graficarMapa();
		}
		System.out.println("Supuestamente esta todo terminado");
	}
}
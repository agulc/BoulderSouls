package boulderDash;

import java.util.Scanner;

public class Juego {
	
	public static void main(String args[]) throws Exception{
		Comportamiento.inicializar();
		mapita.moverARockford("down");
		mapita.graficarMapa();
		for(int i=0;i<7;i++){
			mapita.moverARockford("right");//Hacerlo con un enumerativo, comportamiento del programa entero en una clase aparte, modelar movimiento en una clase aparte, que devuelva una posicion en vez de un vector
			mapita.graficarMapa();
		}
		for(int i=0;i<2;i++){
			mapita.moverARockford("up");
			mapita.graficarMapa();
		}
		mapita.moverARockford("right");
		mapita.graficarMapa();
		for(int i=0;i<2;i++){
			mapita.moverARockford("down");
			mapita.graficarMapa();
		}
		for(int i=0;i<8;i++){
			mapita.moverARockford("right");
			mapita.graficarMapa();
		}
		for(int i=0;i<2;i++){
			mapita.moverARockford("down");
			mapita.graficarMapa();
		}
		for(int i=0;i<5;i++){
			mapita.moverARockford("right");
			mapita.graficarMapa();
		}
		System.out.println("Supuestamente esta todo terminado");
	}
}

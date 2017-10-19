package boulderDash;

import java.util.Scanner;

public class Juego {
	
	public static void main(String args[]) throws Exception{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el nivel que desea: ");
		int NivelElegido = scanner.nextInt();
		Mapa mapita = new Mapa(NivelElegido);
		mapita.graficarMapa();
		mapita.moverARockford("down");
		mapita.graficarMapa();
		for(int i=0;i<7;i++){
			mapita.moverARockford("right");
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

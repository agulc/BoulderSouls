package boulderDash;

import java.util.Scanner;

public class Comportamiento {
	public void Inicializar() throws Exception{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el nivel que desea: ");
		int NivelElegido = scanner.nextInt();
		Mapa mapita = new Mapa(NivelElegido);
		mapita.graficarMapa();
	}
}

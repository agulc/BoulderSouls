package Main;

import Personajes.Personaje;

public class Mapa {
	
	private Personaje[][] personajes;
	private int puntuacion;
	private int vidas;
	private int diamantesRestantes;
	
	public Mapa ()
	{
		personajes = new Personaje[40][22];
		this.vidas = 4;
		this.puntuacion = 0;
		
	}
	
	private void setPersonaje(int x, int y, Personaje psj){
		
	}
	
	private Personaje getPersonaje(int x, int y){
		return this.personajes[1][1];//Temporal, tenemos que evaluar su posicion
	}
}

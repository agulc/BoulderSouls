package com.boulderdash.personajes;

import javax.swing.ImageIcon;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;

/**
 * Clase que modeliza a la explosion, con sus atributos y comportamientos propios
 */
public class Explosion extends Personaje{
	
	private static ImageIcon icono = new ImageIcon("Texturas/explosion.png");
	
	Explosion(int x,int y){
		super(x,y);
		tiempo = 3;
	}
	
	private int tiempo;
	/**
	 * Hace referencia a la cantidad de "turnos" que debe durar una explosión.
	 * @return Tiempo restante.
	 */
	public int tiempoRestante(){
		return tiempo;
	}
	
	public boolean esTransitable(ParaDonde donde){
		return true;
	}
	
	/**
	 * Comportamiento de la explosion.
	 */
	public void actualizarEstadoObjeto(){
		tiempo--; //disminuye el tiempo restante
		
		if (tiempo <= 0) //Si se termina el tiempo
		{
			Mapa.getInstancia().setPersonaje(new Vacio(this.getPos()), this.getPos()); //Sobreescribo la explosion con un personaje vacio
		}
	}
	
	public boolean chequearSiSoy (BDTile tile){

		return false;
	}

	@Override
	public ImageIcon getGraficos() {
		return icono;
	}
	
}

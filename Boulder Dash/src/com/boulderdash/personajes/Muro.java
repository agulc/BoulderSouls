package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;

/**
 * Clase que modeliza al muro, con sus atributos y comportamientos propios
 */
public abstract class Muro extends Personaje{
	Muro(int x,int y){
		super(x,y);
	}
	
	public boolean chequearSiSoy (BDTile tile){
		return (tile == BDTile.WALL);
	}
	

}

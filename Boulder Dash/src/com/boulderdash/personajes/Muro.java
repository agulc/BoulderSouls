package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;

public abstract class Muro extends Personaje{
	Muro(int x,int y){
		super(x,y);
	}
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.WALL);
	}
}

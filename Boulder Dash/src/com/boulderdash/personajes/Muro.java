package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;

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
	
	public boolean soyMagico(){
		return false;
	}

	public void meEmpujanUnaRocaDentro() {
	}
	
	public boolean lateralesLibres(ParaDonde donde) {
		return false;
	}
	

}

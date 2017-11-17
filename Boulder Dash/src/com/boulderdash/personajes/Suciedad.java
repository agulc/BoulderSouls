package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;

public class Suciedad extends Personaje {
	
	public Suciedad(int x,int y){
		super(x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return true;
	}
	
	public void activarIA(){	
	}
	
	public String getGraficos(){
		return "S";
	}
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.DIRT);
	}
}

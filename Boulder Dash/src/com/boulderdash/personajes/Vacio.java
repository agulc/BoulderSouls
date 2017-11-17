package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;
import com.boulderdash.principal.Posicion;

public class Vacio extends Personaje{
	
	Vacio(Posicion pos){
		super(pos);
	}
	
	public Vacio(int x, int y){
		super(x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return true;
	}
	
	public void activarIA(){	
	}
	
	public String getGraficos(){
		return "�";
	}
	
	@Override
	public void meCaeAlgoEncima(){
		System.out.println(Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).getClass().getSimpleName() + " en la posicion x=" + super.getPos(ParaDonde.ARRIBA).getX() + " y=" + super.getPos(ParaDonde.ARRIBA).getY() + " acaba de caer");
		Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).mover(ParaDonde.ABAJO);
	}

	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.EMPTY);
	}
}
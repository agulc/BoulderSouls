package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;

public abstract class EnemigoMovil extends Enemigo {
	
	private ParaDonde direccionActual;
	
	EnemigoMovil(int x,int y){
		super(x,y);
		this.direccionActual = ParaDonde.ARRIBA; //Por defecto empieza hacia arriba aunque despues se chequea para donde debe ir al inicializar el juego
	}
	
	public ParaDonde getDireccionActual(){
		
		return this.direccionActual;
	}
	
	public void setDireccionActual(ParaDonde dir){
		
		this.direccionActual = dir;
	}
	
	public void meCaeAlgoEncima(){
		if(Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.ROCK)||Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.DIAMOND)){
			
			this.explotar();
			
		}
	}
	
	/**
	 * Forma en la que se expande una explosión al ocurrir dentro del mapa.
	 * @throws Exception . 
	 */
	
	
	@Override
	public void moverPersonajes(){

		this.mover(getDireccionActual());
		
	}
	
	
}

package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;
import com.boulderdash.principal.Posicion;

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
		if(Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.ROCK)){
			
			this.explotar();
			
		}
	}
	
	/**
	 * Forma en la que se expande una explosión al ocurrir dentro del mapa.
	 * @throws Exception . 
	 */
	public void explotar(){
		
		int a = this.getPos().getX() - 1; //Empieza en la esquina superior izquierda
		int b = this.getPos().getY() - 1;
		Posicion pos = new Posicion();
		int aAux = a+3;
		int bAux = b+3;
		
		for (int i = a; i<aAux; i++) //Recorre los personajes adyacentes
		{
			for (int j = b; j<bAux; j++)
			{
				pos.setX(i);
				pos.setY(j);
				Mapa.getInstancia().getPersonaje(pos).recibeExplosion(); //Envia la explosion al personaje
				
			}
		}
		System.out.println(this.getClass().getSimpleName() + " en la posicion x=" + this.getPos().getX() +" y=" + this.getPos().getY() + " acaba de explotar");
	}
	
	
	@Override
	public void moverPersonajes(){

		this.mover(getDireccionActual());
		
	}
	
	
}

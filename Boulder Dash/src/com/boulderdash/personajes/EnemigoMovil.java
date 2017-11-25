package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;
import com.boulderdash.principal.Posicion;

public abstract class EnemigoMovil extends Enemigo {
	
	private ParaDonde direccionActual;

	private boolean YaMeMoviEsteTurno = false;
	
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
		if(!YaMeMoviEsteTurno){
			this.mover(getDireccionActual());
			YaMeMoviEsteTurno = true;
		}
	}
	
	public void chequearSiExploto(){
		int a = this.getPos().getX()-1; //Empieza en la esquina superior izquierda
		  int b = this.getPos().getY()-1;
		  Posicion posAux = new Posicion();
		  int aAux = a+2;
		  int bAux = b+2;
		  posAux.setX(a+1);
		  for (int j = b; j <= bAux; j = j + 2)
			   {
			  	posAux.setY(j);
			    if (Mapa.getInstancia().getPersonaje(posAux).chequearSiSoy(BDTile.PLAYER)){ //Si el jugador es adyacente, la luciernaga explota 
			    	 Mapa.getInstancia().getPersonaje(posAux).recibeExplosion();
			    	 super.explotar();
				     break;
				    }
			   }
		  posAux.setY(b+1);
		  for (int j = a ; j <= aAux; j = j + 2) {
			    posAux.setX(j);
			    if (Mapa.getInstancia().getPersonaje(posAux).chequearSiSoy(BDTile.PLAYER)){ //Si el jugador es adyacente, la luciernaga explota 
			    	 Mapa.getInstancia().getPersonaje(posAux).recibeExplosion();
			    	 super.explotar();
				     break;
			    }
		   }
	}

	public boolean isYaMeMoviEsteTurno() {
		return YaMeMoviEsteTurno;
	}

	public void setYaMeMoviEsteTurno(boolean yaMeMoviEsteTurno) {
		YaMeMoviEsteTurno = yaMeMoviEsteTurno;
	}
	
	
	
}

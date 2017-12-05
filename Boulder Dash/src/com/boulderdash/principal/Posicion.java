package com.boulderdash.principal;

import com.boulderdash.enumerativos.ParaDonde;

/**
 * Clase utilizada para modelizar la posicion de cada uno de los personajes en la grilla de juego
 */
public class Posicion {
	private int coordX;
	private int coordY;
	
	public Posicion(int x, int y){
		this.coordX = x;
		this.coordY = y;
	}
	
	public Posicion(){
	}
	
	public int getX(){
		return coordX;
	}
	
	public int getY(){
		return coordY;
	}
	
	public void setX(int x){
		this.coordX = x;
	}
	
	public void setY(int y){
		this.coordY = y;
	}

	/**
	 * Devuelve una posicion adyacente al objeto, dependiendo del enumerativo
	 * que reciba por parametro
	 * @param donde Dirección.
	 * @return Nueva posición,
	 */
	public Posicion getPos(ParaDonde donde){
		Posicion pos = new Posicion();
		switch(donde){
			case ARRIBA:{
				if(coordY>0){
					pos.setX(this.coordX);
					pos.setY(this.coordY-1);
				}
				break;
			}
			case ABAJO:{
				if(coordY<22){
					pos.setX(this.coordX);
					pos.setY(this.coordY+1);
				}
				break;
			}
			case DERECHA:{
				if(coordX<40){
					pos.setX(this.coordX+1);
					pos.setY(this.coordY);
				}
				break;
			}
			case IZQUIERDA:{
				if(coordX>0){
					pos.setX(this.coordX-1);
					pos.setY(this.coordY);
				}
				break;
			}
		}
		return pos;
	}
}

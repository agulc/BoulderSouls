package com.boulderdash.personajes;

import com.boulderdash.audio.Audio;
import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.interfaz.Gui;
import com.boulderdash.principal.Mapa;
import com.boulderdash.principal.Posicion;
import javax.swing.*;

public class Mariposa extends EnemigoMovil{
	
	private static ImageIcon icono = new ImageIcon("Texturas/butterfly.gif");
	
	public Mariposa(int x,int y){
		super(x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return false;
	}
	
	/**
 	 * Comportamiento m�vil de la mariposa. Permite elegir la direcci�n a la cual se debe desplazar
	 * y que comportamiento tomar en caso de no poder moverse en dicha direcci�n.
	 */
	public void actualizarEstadoObjeto(){	
		
		//IMPLEMENTAR MOVIMIENTO
		switch (super.getDireccionActual()){
		
		case ABAJO:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.ABAJO)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.DERECHA);
			}
			break;
			
		case ARRIBA:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.IZQUIERDA);
			}
			break;
			
			
		case DERECHA:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.DERECHA)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.ARRIBA);
			}
			break;
			
			
		case IZQUIERDA:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.IZQUIERDA)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.ABAJO);
			}
			break;
		
		}
		
		  int x = this.getPos().getX()-1; //Empieza en la esquina superior izquierda
		  int y = this.getPos().getY()-1;
		  Posicion posAux = new Posicion();
		  int xAux = x + 3;
		  int yAux = y + 3;
		  posAux.setX(x+1);
		  for (int j = y; j < yAux; j = j + 2)
			   {
			  	posAux.setY(j);
			    if (Mapa.getInstancia().getPersonaje(posAux).chequearSiSoy(BDTile.PLAYER)){ //Si el jugador es adyacente en x, la luciernaga explota 
			    	 Mapa.getInstancia().getPersonaje(posAux).recibeExplosion();
			    	 super.explotar();
				     break;
				    }
			   }
		  posAux.setY(y+1);
		  for (int j = x ; j < xAux; j = j + 2) {
			    posAux.setX(j);
			    if (Mapa.getInstancia().getPersonaje(posAux).chequearSiSoy(BDTile.PLAYER)){ //Si el jugador es adyacente en y, la luciernaga explota 
			    	 Mapa.getInstancia().getPersonaje(posAux).recibeExplosion();
			    	 super.explotar();
				     break;
			    }
		   }
		
		
	}
	
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.BUTTERFLY);
	}

	@Override
	public ImageIcon getIcono() {
		// TODO Auto-generated method stub
		return icono;
	}
	
	public void explotarDiamantes()
	{
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
				  if (!Mapa.getInstancia().getPersonaje(pos).chequearSiSoy(BDTile.WALL) && !Mapa.getInstancia().getPersonaje(pos).chequearSiSoy(BDTile.PLAYER) && !Mapa.getInstancia().getPersonaje(pos).chequearSiSoy(BDTile.EXIT)) 
					  Mapa.getInstancia().setPersonaje(new Diamante(false,pos.getX(),pos.getY()), pos);
			  }
		  }
		  
		  Audio.explosion();
		
		  
	}
	
	public void meCaeAlgoEncima(){
		if(Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.ROCK)||Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.DIAMOND)){
			this.explotarDiamantes();
		}
	}
	
}

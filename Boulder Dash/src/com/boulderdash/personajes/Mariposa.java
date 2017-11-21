package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
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
 	 * Comportamiento móvil de la mariposa. Permite elegir la dirección a la cual se debe desplazar
	 * y que comportamiento tomar en caso de no poder moverse en dicha dirección.
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
		
		int a = this.getPos().getX() - 1; //Empieza en la esquina superior izquierda
		  int b = this.getPos().getY() - 1;
		  Posicion posAux = new Posicion();
		  int aAux = a+3;
		  int bAux = b+3;
		  
		  for (int i = a; a <=aAux; a++) //Recorre los personajes adyacentes
		  {
			   for (int j = b; b <=bAux; b++)
			   {
				    posAux.setX(i);
				    posAux.setY(j);
				    if (Mapa.getInstancia().getPersonaje(posAux).chequearSiSoy(BDTile.PLAYER)){ //Si el jugador es adyacente, la luciernaga explota 
					     this.explotar();
					     break;
				    }
		    
			   }
		  }
		
	}
	
	@Override
	public void explotar(){
		
		int a = this.getPos().getX() - 1; //Empieza en la esquina superior izquierda
		int b = this.getPos().getY() - 1;
		Posicion pos = new Posicion();
		
		for (int i = a; a <= (a+3); a++) //Recorre los personajes adyacentes
		{
			for (int j = b; b <= (b+3); b++)
			{
				pos.setX(i);
				pos.setY(j);
				if (!Mapa.getInstancia().getPersonaje(pos).chequearSiSoy(BDTile.WALL)) //Si no es una pared
				{
					Mapa.getInstancia().setPersonaje(new Diamante(false,pos.getX(),pos.getY()), pos); //Transforma el personaje en diamante
				}
				
				
			}
		}
	}
	
	public String getGraficos(){
		return "%";
	}
	
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.BUTTERFLY);
	}

	@Override
	public ImageIcon getIcono() {
		// TODO Auto-generated method stub
		return icono;
	}
	
	public void explotarDiamantes(){
		  
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
	}
	
	public void meCaeAlgoEncima(){
		if(Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.ROCK)){
			this.explotarDiamantes();
		}
	}
	
}

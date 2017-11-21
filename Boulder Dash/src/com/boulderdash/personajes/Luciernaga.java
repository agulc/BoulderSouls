package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;
import com.boulderdash.principal.Posicion;
import javax.swing.*;

public class Luciernaga extends EnemigoMovil{
	
	private static ImageIcon icono = new ImageIcon("firefly.gif");
	
	public Luciernaga(int x,int y){
		super(x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return false;
	}
	/**
	 * Comportamiento móvil de la luciérnaga. Permite elegir la dirección a la cual se debe desplazar
	 * y que comportamiento tomar en caso de no poder moverse en dicha dirección.
	 */
	public void actualizarEstadoObjeto(){	
		
		switch (super.getDireccionActual()){
		
		case ABAJO:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.ABAJO)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.IZQUIERDA);
			}
			break;
			
		case ARRIBA:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.DERECHA);
			}
			break;
			
			
		case DERECHA:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.DERECHA)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.ABAJO);
			}
			break;
			
			
		case IZQUIERDA:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.IZQUIERDA)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.ARRIBA);
			}
			break;
		
		}
		
		  int a = this.getPos().getX() - 1; //Empieza en la esquina superior izquierda
		  int b = this.getPos().getY() - 1;
		  Posicion posAux = new Posicion();
		  int aAux = a+3;
		  int bAux = b+3;
		  
		  for (int i = a; i < aAux; i++) //Recorre los personajes adyacentes
		  {
			   for (int j = b; j < bAux; j++)
			   {
				    posAux.setX(i);
				    posAux.setY(j);
				    if (Mapa.getInstancia().getPersonaje(posAux).chequearSiSoy(BDTile.PLAYER)){ //Si el jugador es adyacente, la luciernaga explota 
				    	 super.explotar();
					     break;
				    }
		    
			   }
		  }
		
	}
	
	

	
	public String getGraficos(){
		return "<";
	}
	
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.FIREFLY);
	}

	@Override
	public ImageIcon getIcono() {
		// TODO Auto-generated method stub
		return icono;
	}
	
			
}

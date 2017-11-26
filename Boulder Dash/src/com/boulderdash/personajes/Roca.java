package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Comportamiento;
import com.boulderdash.principal.Mapa;
import com.boulderdash.principal.Posicion;

import javax.swing.*;

public class Roca extends ObjetoNewton{
	
	private static ImageIcon icono = new ImageIcon("Texturas/boulder.gif");
	private int inercia = 0;
	public Roca(boolean cae,int x,int y){
		super(cae,x,y);
	}
	
	public Roca(boolean cae,Posicion pos){
		super(cae, pos.getX(), pos.getY());
	}
	
	/**
	 * Permite a Rockford mover las rocas.
	 */
	public boolean rockfordCaminaSobreMi(ParaDonde dir){
		
		if (Comportamiento.getPiedrasConInercia())
		{
			if (inercia >= 7 && (dir == ParaDonde.IZQUIERDA || dir == ParaDonde.DERECHA))
			{
				this.inercia = 0;
				this.mover(dir);
				return true;
			}
			else
			{
				this.inercia++;
				return false;
			}
		}
		else
		{
			if (dir == ParaDonde.IZQUIERDA || dir == ParaDonde.DERECHA)
			{
				if (Mapa.getInstancia().getPersonaje(this.getPos(dir)).soyMagico()) {
					Mapa.getInstancia().getPersonaje(this.getPos(dir)).meEmpujanUnaRocaDentro();;
				}
				this.mover(dir);


				return true;
	
			}
			else
				return false;
			
		}
	}
	
	public boolean esTransitable(ParaDonde donde){
		if(Mapa.getInstancia().getPersonaje(this.getPos(donde)).chequearSiSoy(BDTile.EMPTY) ||
			((Mapa.getInstancia().getPersonaje(this.getPos(donde)).soyMagico() && Mapa.getInstancia().getPersonaje(this.getPos(donde)).lateralesLibres(donde))))
		{
			return true;
		}
		else
			return false;
	}
	
	public void moverPersonajes(){	
		super.moverPersonajes();
	}
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.ROCK);
	}

	@Override
	public ImageIcon getIcono() {
		// TODO Auto-generated method stub
		return icono;
	}

	@Override
	public void actualizarEstadoObjeto(){
		super.actualizarEstadoObjeto();
		super.setYaMeMoviEsteTurno(false);
	}
	
	public void transmutar() {
		Posicion pos = new Posicion();
		Mapa.getInstancia().setPersonaje(new Vacio(this.getPos()), this.getPos()); 
		pos.setX(this.getPos().getX());
		pos.setY(this.getPos().getY()+2);
		Mapa.getInstancia().setPersonaje(new Diamante(false, pos), pos);
	}
	
	public void transmutarIzquierdaDerecha(){
		Posicion pos = new Posicion();
		Mapa.getInstancia().setPersonaje(new Vacio(this.getPos()), this.getPos()); 
		pos.setX(this.getPos().getX()+2);
		pos.setY(this.getPos().getY());
		Mapa.getInstancia().setPersonaje(new Diamante(false, pos), pos);
	}
	public void transmutarDerechaIzquierda(){
		Posicion pos = new Posicion();
		Mapa.getInstancia().setPersonaje(new Vacio(this.getPos()), this.getPos()); 
		pos.setX(this.getPos().getX()-2);
		pos.setY(this.getPos().getY());
		Mapa.getInstancia().setPersonaje(new Diamante(false, pos), pos);
	}

}

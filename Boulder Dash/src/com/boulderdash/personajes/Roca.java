package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Comportamiento;
import com.boulderdash.principal.Mapa;
import javax.swing.*;

public class Roca extends ObjetoNewton{
	
	private static ImageIcon icono = new ImageIcon("Texturas/boulder.gif");
	private int inercia = 0;
	public Roca(boolean cae,int x,int y){
		super(cae,x,y);
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
				this.mover(dir);
				return true;
			}
			else
				return false;
			
		}
	}
	
	public boolean esTransitable(ParaDonde donde){
		if(Mapa.getInstancia().getPersonaje(this.getPos(donde)).chequearSiSoy(BDTile.EMPTY))
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

}

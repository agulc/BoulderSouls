package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;
import javax.swing.*;

public class Roca extends ObjetoNewton{
	
	private static ImageIcon icono = new ImageIcon("boulder.gif");
	
	public Roca(boolean cae,int x,int y){
		super(cae,x,y);
	}
	
	/**
	 * Permite a Rockford mover las rocas.
	 */
	public boolean rockfordCaminaSobreMi(ParaDonde dir){
		
		if (dir == ParaDonde.IZQUIERDA || dir == ParaDonde.DERECHA)
		{
			this.mover(dir);
			return true;
		}
		else
		{
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
	
	public String getGraficos(){
		return "R";
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

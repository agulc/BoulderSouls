package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;


import javax.swing.*;

public class MuroMagico extends Muro{
	
	
	private static ImageIcon icono = new ImageIcon("Texturas/magic2.gif");
	
	public MuroMagico(int x,int y){
		super(x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return false;
	}

	@Override
	public ImageIcon getIcono() {
		// TODO Auto-generated method stub
		return icono;
	}
	

	
	public void meCaeAlgoEncima(){
		
		if((Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ABAJO)).chequearSiSoy(BDTile.EMPTY)) && (Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.ROCK)||Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.DIAMOND))){			
			Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).rensei();
		}
	}
	
	public boolean soyMagico() {
		return true;
	}
	
	
	
}

package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import javax.swing.*;

public class Suciedad extends Personaje {
	
	private static ImageIcon icono = new ImageIcon("dirt.gif");
	
	public Suciedad(int x,int y){
		super(x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return true;
	}
	
	public void activarIA(){	
	}
	
	public String getGraficos(){
		return "S";
	}
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.DIRT);
	}

	@Override
	public ImageIcon getIcono() {
		// TODO Auto-generated method stub
		return icono;
	}
}

package com.boulderdash.personajes;

import com.boulderdash.audio.Audio;
import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;
import javax.swing.*;

public class Diamante extends ObjetoNewton{
	
	private static ImageIcon icono = new ImageIcon("Texturas/diamond.gif");
	
	public Diamante(boolean cae,int x,int y){
		super(cae,x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return true;
	}
	
	public boolean rockfordCaminaSobreMi (ParaDonde dir){
		
		Audio.item();
		Mapa.setDiamantesRestantes(Mapa.getDiamantesRestantes() - 1);
		Mapa.incrementarPuntaje();
		return true;
	}
	
	public void moverPersonajes(){	
		super.moverPersonajes();
	}
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.DIAMOND);
	}

	@Override
	public ImageIcon getIcono() {
		// TODO Auto-generated method stub
		return icono;
	}
}

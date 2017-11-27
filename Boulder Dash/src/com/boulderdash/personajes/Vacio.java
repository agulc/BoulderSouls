package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;
import com.boulderdash.principal.Posicion;
import javax.swing.*;

public class Vacio extends Personaje{
	
	private static ImageIcon icono = new ImageIcon("Texturas/empty.gif");
	
	Vacio(Posicion pos){
		super(pos);
	}
	
	public Vacio(int x, int y){
		super(x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return true;
	}
	
	public void activarIA(){	
	}

	
	@Override
	public void meCaeAlgoEncima(){
		Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).mover(ParaDonde.ABAJO);
	}

	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.EMPTY);
	}

	@Override
	public ImageIcon getGraficos() {
		// TODO Auto-generated method stub
		return icono;
	}
}

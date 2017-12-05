package com.boulderdash.personajes;

import com.boulderdash.enumerativos.ParaDonde;

import javax.swing.ImageIcon;

/**
 * Clase que modeliza al muro comun, con sus atributos y comportamientos propios
 */
public class MuroComun extends Muro {
	
	private static ImageIcon icono = new ImageIcon("Texturas/magic.gif");
	
	public MuroComun(int x,int y){
		super(x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return false;
	}

	@Override
	public ImageIcon getGraficos() {
		return icono;
	}
	
	@Override
	public void explotar() { //No puede explotar
	}
	


}

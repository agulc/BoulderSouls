package com.boulderdash.personajes;

import javax.swing.ImageIcon;

import com.boulderdash.enumerativos.ParaDonde;

/**
 * Clase que modeliza al muro de titanio, con sus atributos y comportamientos propios
 */
public class MuroTitanio extends Muro {
	
	private static ImageIcon icono = new ImageIcon("Texturas/steel.gif");
	
	public MuroTitanio(int x,int y){
		super(x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return false;
	}

	/**
	 *De haber una explosión, este no se inmuta.
	 */
	@Override
	public void recibeExplosion(){ 
	}

	@Override
	public ImageIcon getGraficos() {
		return icono;
	}
	
	@Override
	public void explotar() { //No puede explotar
	}
	
}

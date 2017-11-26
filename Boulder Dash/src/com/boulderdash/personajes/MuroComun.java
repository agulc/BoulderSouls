package com.boulderdash.personajes;

import com.boulderdash.enumerativos.ParaDonde;

import javax.swing.ImageIcon;



public class MuroComun extends Muro {
	
	private static ImageIcon icono = new ImageIcon("Texturas/magic.gif");
	
	public MuroComun(int x,int y){
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
	
	@Override
	public void explotar() { //No puede explotar
	}
	


}

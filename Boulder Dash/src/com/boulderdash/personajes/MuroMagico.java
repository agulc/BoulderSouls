package com.boulderdash.personajes;

import com.boulderdash.enumerativos.ParaDonde;
import javax.swing.*;

public class MuroMagico extends Muro{
	
	private static ImageIcon icono = new ImageIcon("Texturas/magic.gif");
	
	public MuroMagico(int x,int y){
		super(x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return false;
	}
	
	public String getGraficos(){
		return "M";
	}

	@Override
	public ImageIcon getIcono() {
		// TODO Auto-generated method stub
		return icono;
	}
	


}

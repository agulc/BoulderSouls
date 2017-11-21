package com.boulderdash.personajes;

import com.boulderdash.enumerativos.ParaDonde;
import javax.swing.*;

public class MuroTitanio extends Muro {
	
	private static ImageIcon icono = new ImageIcon("Texturas/steel.gif");
	
	public MuroTitanio(int x,int y){
		super(x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return false;
	}
	
	public String getGraficos(){
		return "#";
	}
	/**
	 *De haber una explosión, este no se inmuta.
	 */
	@Override
	public void recibeExplosion(){ 
		//Si recibe una explosion, No hace nada (A diferencia del resto de personajes)
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

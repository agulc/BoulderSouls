package com.boulderdash.personajes;

import javax.swing.ImageIcon;

import com.boulderdash.enumerativos.ParaDonde;

public class MuroTitanio extends Muro {
	
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


}

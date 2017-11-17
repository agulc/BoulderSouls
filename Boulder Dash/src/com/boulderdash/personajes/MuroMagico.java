package com.boulderdash.personajes;

import com.boulderdash.enumerativos.ParaDonde;

public class MuroMagico extends Muro{
	
	public MuroMagico(int x,int y){
		super(x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return false;
	}
	
	public String getGraficos(){
		return "M";
	}
	


}

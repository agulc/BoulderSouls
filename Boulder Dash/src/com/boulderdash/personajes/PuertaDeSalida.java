package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;
import javax.swing.*;

public class PuertaDeSalida extends Personaje{
	
	private static ImageIcon icono = new ImageIcon("Texturas/exit.gif");
	
	public PuertaDeSalida(int x,int y){
		super(x,y);
		this.transitable = false;
	}
	
	private boolean transitable;
	
	public boolean esTransitable(ParaDonde donde){
		return transitable;
	}
	
	public void actualizarEstadoObjeto(){
		if(Mapa.getDiamantesRestantes()<=0){
			this.transitable=true;
			System.out.println("Ahora la puerta esta abierta!!!!! ESCAPAA!!");
		}
	}
	
	public String getGraficos(){
		return "@";
	}
	
	/**
	 * De haber una explosi�n, este no se inmuta.
	 */
	@Override
	public void recibeExplosion(){ //Si recibe una explosion, No hace nada (A diferencia del resto de personajes)

	}
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.EXIT);
	}
	
	public boolean rockfordCaminaSobreMi (ParaDonde donde){
		//IMPLEMENTAR
		//SI se llega a la salida y esta abierta, se aumenta el nivel, y se reconstruye el mapa
		return this.transitable;
	}

	@Override
	public ImageIcon getIcono() {
		// TODO Auto-generated method stub
		return icono;
	}

}

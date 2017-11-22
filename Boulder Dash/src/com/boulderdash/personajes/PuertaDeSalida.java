package com.boulderdash.personajes;

import com.boulderdash.audio.Audio;
import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Gui;
import com.boulderdash.principal.Mapa;
import javax.swing.*;

public class PuertaDeSalida extends Personaje{
	
	private static ImageIcon iconoAbierta = new ImageIcon("Texturas/exit.gif");
	private static ImageIcon iconoCerrada = new ImageIcon("Texturas/exitClosed.png");
	
	private boolean abierta = false;
	
	public PuertaDeSalida(int x,int y){
		super(x,y);
		this.transitable = false;
	}
	
	private boolean transitable;
	
	public boolean esTransitable(ParaDonde donde){
		return transitable;
	}
	
	public void actualizarEstadoObjeto(){
		if(Mapa.getDiamantesRestantes()<=0 && !abierta){
			this.transitable=true;
			System.out.println("Ahora la puerta esta abierta!!!!! ESCAPAA!!");
			abierta = true;
			Gui.getInstancia().actualizarImagenes(this.getPos());
			Audio.puertaAbierta();
		}
	}
	
	
	/**
	 * De haber una explosión, este no se inmuta.
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
		Audio.victoria();
		
		return this.transitable;
	}

	@Override
	public ImageIcon getIcono() {
		if (this.abierta)
		{
			return iconoAbierta;
		}
		else
		{
			return iconoCerrada;
		}
		
	}
	
	@Override
	public void explotar() { //No puede explotar
		
	}

}

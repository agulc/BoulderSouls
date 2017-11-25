package com.boulderdash.personajes;

import com.boulderdash.audio.Audio;
import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;
import javax.swing.*;

public class Diamante extends ObjetoNewton{
	
	private static ImageIcon icono = new ImageIcon("Texturas/diamond.gif");
	
	private static int valorDiamante = 100;
	
	public Diamante(boolean cae,int x,int y){
		super(cae,x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return true;
	}
	
	public boolean rockfordCaminaSobreMi (ParaDonde dir){
		
		Audio.item();
		if (Mapa.getDiamantesRestantes() > 0)
			Mapa.setDiamantesRestantes(Mapa.getDiamantesRestantes() - 1);
		else
		{
			setValorDiamante(Mapa.getValorDiamanteBonus()[Mapa.getInstancia().getNivelActual()]); //Cambia el valor de los diamantes cuando ya se agarraron todos
		}
		Mapa.getInstancia().setPuntuacionNivel(Mapa.getInstancia().getPuntuacionNivel() + valorDiamante);
		return true;
	}
	
	public void moverPersonajes(){	
		super.moverPersonajes();
	}
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.DIAMOND);
	}

	@Override
	public ImageIcon getIcono() {
		// TODO Auto-generated method stub
		return icono;
	}

	public static int getValorDiamante() {
		return valorDiamante;
	}

	public static void setValorDiamante(int valorDiamante) {
		Diamante.valorDiamante = valorDiamante;
	}
	
	@Override
	public void actualizarEstadoObjeto(){
		super.actualizarEstadoObjeto();
		super.setYaMeMoviEsteTurno(false);
	}
}

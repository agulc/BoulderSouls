package com.boulderdash.personajes;

import com.boulderdash.audio.Audio;
import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;
import com.boulderdash.principal.Posicion;

import javax.swing.*;

/**
 * Clase que modeliza al diamante, con sus atributos y comportamientos propios, extiende a ObjetoNewton ya que puede caer al igual que las rocas
 */
public class Diamante extends ObjetoNewton{
	
	private static ImageIcon icono = new ImageIcon("Texturas/diamond.gif");
	
	private static int valorDiamante = 0;
	
	public Diamante(boolean cae,int x,int y){
		super(cae,x,y);
	}
	
	/**
	 * Constructor de la clase, utilizando Posicion en vez de x e y
	 */
	public Diamante(boolean cae, Posicion pos){
		super(cae,pos.getX(),pos.getY());
	}
	
	public boolean esTransitable(ParaDonde donde){
		return true;
	}
	
	public boolean rockfordCaminaSobreMi (ParaDonde dir){
		
		Audio.item();
		Mapa.setDiamantesRestantes(Mapa.getDiamantesRestantes() - 1);
		if (Mapa.getDiamantesRestantes() <= 0)
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
	public ImageIcon getGraficos() {
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
		super.setyaMeMoviEsteTurno(false);
	}
	
}

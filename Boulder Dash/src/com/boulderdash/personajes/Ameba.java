package com.boulderdash.personajes;
import java.util.Random;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;
import com.boulderdash.principal.Posicion;
import javax.swing.*;

public class Ameba extends Enemigo{
	
	private static ImageIcon icono = new ImageIcon("Texturas/amoeba.gif");
	
	private Random generador = new Random();
	private static int contador = 1;
	
	public Ameba(int x,int y){
		super(x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return false;
	}
	/**
	 * Crea una ameba en la posición con el offset recibido, si esta es Suciedad o Vacío.
	 * @param offsetX Coordenada a expandirse en X.
	 * @param offsetY Coordenada a expandirse en Y.
	 */
	private void expandirse (int offsetX, int offsetY)
	{
		Posicion pos = new Posicion();
		pos.setX(this.getPos().getX() + offsetX);
		pos.setY(this.getPos().getY() + offsetY);
		
		if (Mapa.getInstancia().getPersonaje(pos).chequearSiSoy(BDTile.DIRT) || Mapa.getInstancia().getPersonaje(pos).chequearSiSoy(BDTile.EMPTY))
		{
			Ameba hijo = new Ameba(pos.getX(),pos.getY());
			Mapa.getInstancia().setPersonaje(hijo, pos);
			
			System.out.println("Hay "+(++contador)+" amebas");//Notifica en consola
		}
	}
	/**
	 * Para la reproducción de la Ameba, se han utilizado valores aleatorios con el fin
	 * de lograr el efecto solicitado.
	 */
	public void actualizarEstadoObjeto(){	
		
		int expandirse = 1 + generador.nextInt(100); //Genera un numero del 1 al 70
		int adyacente = 1 + generador.nextInt(8); //Determina en que cuadro adyacente intentara expandirse
	

		//Gui.getInstancia().actualizarImagenes(this.getPos());
		
		if (expandirse == 1) //Tiene una probabilidad de 1 en 70 de intentar expandirse
		{
			switch (adyacente)
			{
			case 1: 
				expandirse(-1,-1);
				break;
				
			case 2: 
				expandirse(-1,1);
				break;
				
			case 3: 
				expandirse(1,1);
				break;
				
			case 4: 
				expandirse(1,-1);
				break;
				
			case 5: 
				expandirse(0,1);
				break;
				
			case 6: 
				expandirse(0,-1);
				break;				
				
			case 7: 
				expandirse(1,0);
				break;				
				
			default: 
				expandirse(-1,0);
				break;				
			}
		}
	
	}
 
	public boolean chequearSiSoy (BDTile tile){
		return (tile == BDTile.AMOEBA);
	}

	@Override
	public ImageIcon getGraficos() {
		return icono;
	}

}

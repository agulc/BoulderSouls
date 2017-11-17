package com.boulderdash.personajes;
import java.util.Random;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;
import com.boulderdash.principal.Posicion;

public class Ameba extends Enemigo{
	
	Random generador = new Random();
	
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
			Mapa.getInstancia().setPersonaje(hijo, this.getPos());
			
			System.out.println("Una ameba se expande a ("+pos.getX()+","+pos.getY()+")"); //Notifica en consola
		}
	}
	/**
	 * Para la reproducción de la Ameba, se han utilizado valores aleatorios con el fin
	 * de lograr el efecto solicitado.
	 */
	public void actualizarEstadoObjeto(){	
		
		int expandirse = 1 + generador.nextInt(100); //Genera un numero del 1 al 100
		int adyacente = 1 + generador.nextInt(8); //Determina en que cuadro adyacente intentara expandirse
	

		if (expandirse == 100) //Tiene una probabilidad de 1 en 100 de intentar expandirse
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
	
	public String getGraficos(){
		return "A";
	}
 
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.AMOEBA);
	}

}

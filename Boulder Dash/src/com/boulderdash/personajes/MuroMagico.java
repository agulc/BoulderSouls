package com.boulderdash.personajes;

import javax.swing.ImageIcon;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;


/**
 * Clase que modeliza al muro magico, con sus atributos y comportamientos propios
 */
public class MuroMagico extends Muro{
	
	
	private static ImageIcon icono = new ImageIcon("Texturas/magic2.gif");
	
	public MuroMagico(int x,int y){
		super(x,y);
	}
	
	public boolean esTransitable(ParaDonde donde){
		return false;
	}

	@Override
	public ImageIcon getGraficos() {
		return icono;
	}
	

	
	public void meCaeAlgoEncima(){
		
		if((Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ABAJO)).chequearSiSoy(BDTile.EMPTY))) {
			if (Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.ROCK))
			{
				Mapa.getInstancia().setPersonaje(new Diamante(true,super.getPos(ParaDonde.ABAJO)), super.getPos(ParaDonde.ABAJO)); 
			}
			else
				if(Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.DIAMOND)) 
				{
					Mapa.getInstancia().setPersonaje(new Roca(true,super.getPos(ParaDonde.ABAJO)), super.getPos(ParaDonde.ABAJO)); 
				}
			Mapa.getInstancia().setPersonaje(new Vacio(super.getPos(ParaDonde.ARRIBA)), super.getPos(ParaDonde.ARRIBA));
						
		}
	}
	

	
	public boolean lateralesLibres(ParaDonde donde) {
		
		if ((Mapa.getInstancia().getPersonaje(super.getPos(donde)).chequearSiSoy(BDTile.EMPTY))){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * Si le empujan una roca encima, la convierte en diamante
	 */
	public void meEmpujanUnaRocaDentro() 
	{

		if((Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.DERECHA)).chequearSiSoy(BDTile.ROCK))) 
		{
			Mapa.getInstancia().setPersonaje(new Vacio(super.getPos(ParaDonde.DERECHA)), super.getPos(ParaDonde.DERECHA)); 
			Mapa.getInstancia().setPersonaje(new Diamante(true,super.getPos(ParaDonde.IZQUIERDA)), super.getPos(ParaDonde.IZQUIERDA)); 
			
		}

		else
			if((Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.IZQUIERDA)).chequearSiSoy(BDTile.ROCK)))
			{
				Mapa.getInstancia().setPersonaje(new Vacio(super.getPos(ParaDonde.IZQUIERDA)), super.getPos(ParaDonde.IZQUIERDA)); 
				Mapa.getInstancia().setPersonaje(new Diamante(true,super.getPos(ParaDonde.DERECHA)), super.getPos(ParaDonde.DERECHA)); 
			
			}
		
		
	}

	public boolean soyMagico() {
		return true;
	}
	
	
	
}

package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.Estado;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;

/**
 * Clase abstracta utilizada para modelizar a los objetos que pueden caer por su propio peso
 */
public abstract class ObjetoNewton extends Personaje{
	
	private Estado stat;

	private boolean yaMeMoviEsteTurno = false;
	
	/**
	 * Constructor de la clase ObjetoNewton que también recibe si está cayendo o no.
	 * @param cae Estado de movimiento del objeto.
	 * @param x Coordenada en X del nuevo objeto.
	 * @param y Coordenada en Y del nuevo objeto.
	 */
	public ObjetoNewton(boolean cae,int x, int y){
		super(x,y);
		if(cae){
			this.stat = Estado.CAYENDO;
		}
		else{
			this.stat = Estado.ESTACIONARIO;
		}
	}
	
	@Override
	public void moverPersonajes(){
		if(stat == Estado.CAYENDO && !yaMeMoviEsteTurno){
			Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ABAJO)).meCaeAlgoEncima();//Le informo al de abajo mio que voy a caer encima de el, enviandole mi posicion
			yaMeMoviEsteTurno = true;
		}
	}
	
	/**
	 * Utilizado para ver si el objeto newton debe resbalar, ya sea por tener un muro, roca, o diamante debajo
	 */
	private boolean chequearSiResbalo(ParaDonde donde, int x, int y)
	{
		if (donde == ParaDonde.IZQUIERDA)
			{
			return (((Mapa.getInstancia().getMapa()[x-1][y].chequearSiSoy(BDTile.EMPTY)) && (Mapa.getInstancia().getMapa()[x-1][y+1].chequearSiSoy(BDTile.EMPTY))) && 
		 	 		   (((( Mapa.getInstancia().getMapa()[x][y+1].chequearSiSoy(BDTile.DIAMOND) || (Mapa.getInstancia().getMapa()[x][y+1].chequearSiSoy(BDTile.WALL))||
		 		 	 		   ((Mapa.getInstancia().getMapa()[x][y+1].chequearSiSoy(BDTile.ROCK))))))));
			}
		else
		{
			return ((((Mapa.getInstancia().getMapa()[x+1][y].chequearSiSoy(BDTile.EMPTY)) && (Mapa.getInstancia().getMapa()[x+1][y+1].chequearSiSoy(BDTile.EMPTY))) && 
	 		 		   (((( Mapa.getInstancia().getMapa()[x][y+1].chequearSiSoy(BDTile.DIAMOND) || (Mapa.getInstancia().getMapa()[x][y+1].chequearSiSoy(BDTile.WALL))||
	 		 		   ((Mapa.getInstancia().getMapa()[x][y+1].chequearSiSoy(BDTile.ROCK)))))))));
		}
	}

	public void actualizarEstadoObjeto(){

		int x = this.getPos().getX();
		int y = this.getPos().getY();
		if((Mapa.getInstancia().getMapa()[x][y+1]).chequearSiSoy(BDTile.WALL) && ((Muro)Mapa.getInstancia().getMapa()[x][y+1]).soyMagico() && Mapa.getInstancia().getMapa()[x][y+2].chequearSiSoy(BDTile.EMPTY)){
				this.stat = Estado.CAYENDO;
			}
		
		else {
		if((Mapa.getInstancia().getMapa()[x][y+1].chequearSiSoy(BDTile.EMPTY))) /*Podriamos reemplazarlo por el chequear objeto debajo y actualizar dependiendo de eso*/
		{
			this.stat = Estado.CAYENDO;
 		}
	 	else{
	 		if (chequearSiResbalo(ParaDonde.IZQUIERDA,x,y))
	 	 		{
	 	 			super.mover(ParaDonde.IZQUIERDA);
	 	 			this.stat = Estado.CAYENDO;
	 	 		}
	 		else
	 			if (chequearSiResbalo(ParaDonde.DERECHA,x,y))
	 		 		{
	 		 			super.mover(ParaDonde.DERECHA);
	 		 			this.stat = Estado.CAYENDO;
	 		 			
	 		 		}
		 		else
		 			if((Mapa.getInstancia().getMapa()[x][y+1].chequearSiSoy(BDTile.PLAYER)) && this.stat == Estado.CAYENDO) /*Podriamos reemplazarlo por el chequear objeto debajo y actualizar dependiendo de eso*/
		 			{
		 				this.stat = Estado.CAYENDO;
		 	 		}
		 			else
			 		{
			 			this.stat = Estado.ESTACIONARIO;
			 		}
	 	}
		}
	}

	public boolean getyaMeMoviEsteTurno() {
		return yaMeMoviEsteTurno;
	}

	public void setyaMeMoviEsteTurno(boolean yaMeMoviEsteTurno) {
		this.yaMeMoviEsteTurno = yaMeMoviEsteTurno;
	}

}

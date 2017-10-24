package boulderDash;

public abstract class ObjetoNewton extends Personaje{
	
	private State stat;
	
	public enum State{
		Estacionario, Cayendo;
	}
	/**
	 * Constructor de la clase ObjetoNewton que también recibe si está cayendo o no.
	 * @param cae Estado de movimiento del objeto.
	 * @param x Coordenada en X del nuevo objeto.
	 * @param y Coordenada en Y del nuevo objeto.
	 */
	public ObjetoNewton(boolean cae,int x, int y){
		super(x,y);
		if(cae){
			this.stat = State.Cayendo;
		}
		else{
			this.stat = State.Estacionario;
		}
	}
	
	public void moverPersonajes() throws Exception{
		if(stat == State.Cayendo){
			Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ABAJO)).meCaeAlgoEncima();//Le informo al de abajo mio que voy a caer encima de el, enviandole mi posicion
		}
	}
	

	public void actualizarEstadoObjeto() throws Exception{

		int x = this.getPos().getX();
		int y = this.getPos().getY();
			//
		if((Mapa.getInstancia().mapa[x][y+1].chequearSiSoy(BDTile.EMPTY))){/*Podriamos reemplazarlo por el chequear objeto debajo y actualizar dependiendo de eso*/
	 		this.stat = State.Cayendo;
	 		System.out.println(Mapa.getInstancia().mapa[x][y].getClass().getSimpleName() + " en la posicion x=" + x + " y=" + y + " esta cayendo");
 		}
	 	else{
	 		if ((((Mapa.getInstancia().mapa[x-1][y].chequearSiSoy(BDTile.EMPTY)) && (Mapa.getInstancia().mapa[x-1][y+1].chequearSiSoy(BDTile.EMPTY))) && 
	 		   (((( Mapa.getInstancia().mapa[x][y+1].chequearSiSoy(BDTile.DIAMOND) || (Mapa.getInstancia().mapa[x][y+1].chequearSiSoy(BDTile.WALL))||
	 		   ((Mapa.getInstancia().mapa[x][y+1].chequearSiSoy(BDTile.ROCK)))))))))
	 		{
	 			super.mover(ParaDonde.IZQUIERDA);
	 			this.stat = State.Cayendo;
	 			System.out.println(Mapa.getInstancia().mapa[x][y].getClass().getSimpleName() + " en la posicion x=" + x + " y=" + y + " esta cayendo");
	 			
	 		}
	 		else
	 		{
	 			this.stat = State.Estacionario;
	 			System.out.println(Mapa.getInstancia().mapa[x][y].getClass().getSimpleName() + " en la posicion x=" + x + " y=" + y + " esta estacionari@");
	 		}
	 	}
	}

}

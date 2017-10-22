package boulderDash;

public abstract class ObjetoNewton extends Personaje{
	
	private State stat;
	
	public enum State{
		Estacionario, Cayendo;
	}
	/**
	 * Verifica si el objeto deve moverse hacia abajo "devido a la gravedad".
	 * @param cae
	 * @param x
	 * @param y
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
			Mapa.getInstancia().getPersonaje(super.getPos(paraDonde.ABAJO)).meCaeAlgoEncima();;//Le informo al de abajo mio que voy a caer encima de el, enviandole mi posicion
		}
	}
	

	public void actualizarEstadoObjeto() throws Exception{

		int x = this.getPos().getX(); 
		int y = this.getPos().getY();
		
		if((Mapa.getInstancia().mapa[x][y+1] instanceof Vacio)||(Mapa.getInstancia().mapa[x][y+1] instanceof Rockford)){/*Podriamos reemplazarlo por el chequear objeto debajo y actualizar dependiendo de eso*/
	 		this.stat = State.Cayendo;
	 		System.out.println(Mapa.getInstancia().mapa[x][y].getClass().getSimpleName() + " en la posicion x=" + x + " y=" + y + " esta cayendo");
 		}
	 	else{
	 		if((Mapa.getInstancia().mapa[x-1][y] instanceof Vacio)&&((Mapa.getInstancia().mapa[x-1][y+1] instanceof Vacio)||(Mapa.getInstancia().mapa[x-1][y+1] instanceof Rockford))){
	 			super.mover(paraDonde.IZQUIERDA);
	 			this.stat = State.Cayendo;
	 			System.out.println(Mapa.getInstancia().mapa[x][y].getClass().getSimpleName() + " en la posicion x=" + x + " y=" + y + " esta cayendo");
	 		}
	 		else{
	 			this.stat = State.Estacionario;
	 			System.out.println(Mapa.getInstancia().mapa[x][y].getClass().getSimpleName() + " en la posicion x=" + x + " y=" + y + " esta estacionari@");
	 		}
	 	}
	}

}

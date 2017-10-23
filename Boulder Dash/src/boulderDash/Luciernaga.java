package boulderDash;


public class Luciernaga extends EnemigoMovil{
	
	Luciernaga(int x,int y){
		super(x,y);
	}
	
	public boolean getRun(ParaDonde donde){
		return false;
	}
	/**
	 * Comportamiento movil de la luciernaga. Permite elegir la direcci�n a la cual se debe desplazar
	 * y que comportamiento tomar en caso de no poder moverse en dicha direcci�n. 
	 */
	public void actualizarEstadoObjeto() throws Exception{	
		
		//IMPLEMENTAR MOVIMIENTO
		switch (super.getDireccionActual()){
		
		case ABAJO:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.ABAJO)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.IZQUIERDA);
			}
			break;
			
		case ARRIBA:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.DERECHA);
			}
			break;
			
			
		case DERECHA:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.DERECHA)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.ABAJO);
			}
			break;
			
			
		case IZQUIERDA:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.IZQUIERDA)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.ARRIBA);
			}
			break;
		
		}
		
		int a = this.getPos().getX() - 1; //Empieza en la esquina superior izquierda
		  int b = this.getPos().getY() - 1;
		  Posicion posAux = new Posicion();
		  int aAux = a+3;
		  int bAux = b+3;
		  
		  for (int i = a; a <=aAux; a++) //Recorre los personajes adyacentes
		  {
			   for (int j = b; b <=bAux; b++)
			   {
				    posAux.setX(i);
				    posAux.setY(j);
				    if (Mapa.getInstancia().getPersonaje(posAux).chequearSiSoy(BDTile.PLAYER)){ //Si el jugador es adyacente, la luciernaga explota 
					     this.explotar();
					     break;
				    }
		    
			   }
		  }
		
	}
	
	

	
	public String getGraficos(){
		return "Luciernaga";
	}
	
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.FIREFLY);
	}
	
			
}

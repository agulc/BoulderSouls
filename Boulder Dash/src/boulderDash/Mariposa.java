package boulderDash;

public class Mariposa extends EnemigoMovil{
	
	Mariposa(int x,int y){
		super(x,y);
	}
	
	public boolean getRun(ParaDonde donde){
		return false;
	}
	
	/**
 	 * Comportamiento móvil de la mariposa. Permite elegir la dirección a la cual se debe desplazar
	 * y que comportamiento tomar en caso de no poder moverse en dicha dirección.
	 */
	public void actualizarEstadoObjeto() throws Exception{	
		
		//IMPLEMENTAR MOVIMIENTO
		switch (super.getDireccionActual()){
		
		case ABAJO:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.ABAJO)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.DERECHA);
			}
			break;
			
		case ARRIBA:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.IZQUIERDA);
			}
			break;
			
			
		case DERECHA:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.DERECHA)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.ARRIBA);
			}
			break;
			
			
		case IZQUIERDA:
			if (!Mapa.getInstancia().getPersonaje(this.getPos(ParaDonde.IZQUIERDA)).chequearSiSoy(BDTile.EMPTY)) {
				this.setDireccionActual(ParaDonde.ABAJO);
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
	
	@Override
	public void explotar() throws Exception{
		
		int a = this.getPos().getX() - 1; //Empieza en la esquina superior izquierda
		int b = this.getPos().getY() - 1;
		Posicion pos = new Posicion();
		
		for (int i = a; a <= (a+3); a++) //Recorre los personajes adyacentes
		{
			for (int j = b; b <= (b+3); b++)
			{
				pos.setX(i);
				pos.setY(j);
				if (!Mapa.getInstancia().getPersonaje(pos).chequearSiSoy(BDTile.WALL)) //Si no es una pared
				{
					Mapa.getInstancia().setPersonaje(new Diamante(false,pos.getX(),pos.getY()), pos); //Transforma el personaje en diamante
				}
				
				
			}
		}
	}
	
	public String getGraficos(){
		return "%";
	}
	
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.BUTTERFLY);
	}
	
}

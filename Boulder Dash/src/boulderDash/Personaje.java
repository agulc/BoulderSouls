package boulderDash;

public abstract class Personaje {
	private Posicion pos;
	
	Personaje(int x,int y){
		pos = new Posicion(x,y);
	}
	
	Personaje(Posicion pos2){
		pos = new Posicion();
		pos = pos2;
	}
	
	Personaje(){
		pos = new Posicion();
	}
	
	public Posicion getPos(){
		return pos;
	}
	
	public void setPos(Posicion posAux){
		this.pos = posAux;
	}
	
	public Posicion getPos(ParaDonde donde){
		return pos.getPos(donde);
	}
	/**
	 * Se encarga de realizar el movimiento del objeto que se debe actualizar.
	 * @param pos
	 * @param x
	 * @param y
	 * @throws Exception
	 */
	public boolean rockfordCaminaSobreMi (ParaDonde donde) throws Exception{
		
		return true;
	}
	
	public void movimiento(ParaDonde dir) throws Exception{

		if (Mapa.getInstancia().getPersonaje(this.getPos(dir)).chequearSiSoy(BDTile.EMPTY)){
			
			Mapa.getInstancia().setPersonaje(this , getPos(dir)); //Se mueve al siguiente casillero
			Mapa.getInstancia().setPersonaje(new Vacio(this.getPos()), this.getPos());
			setPos(getPos(dir)); //Actualizo mi posicion
			
		}
		
		
	}
	/**
	 * Permite seleccionar al objeto la dirección hacia donde debe desplazarse.
	 * @param donde
	 * @throws Exception
	 */
	public void mover(ParaDonde donde) throws Exception{


		if(this.permitirMovimiento(donde)){

			switch (donde) { //Cabe destacar que arriba y abajo se manejan al revez en este caso
				case ARRIBA: {
					this.movimiento(ParaDonde.ARRIBA);
					break;

				}
				case ABAJO: {
					this.movimiento(ParaDonde.ABAJO);
					break;

				}		
				case IZQUIERDA: {
					this.movimiento(ParaDonde.IZQUIERDA);
					break;

				}	
				case DERECHA: {
					this.movimiento(ParaDonde.DERECHA);
					break;

				}
			}
		}
	}
	
	
	public abstract String getGraficos();
	
	/**
	 * Verifica si el objeto que decea moverse puede hacerlo en la dirección que solicita.
	 * @param donde
	 * @param pos
	 * @return
	 * @throws Exception
	 */
	
	
	public boolean permitirMovimiento(ParaDonde donde) throws Exception{
		return (Mapa.getInstancia().getPersonaje(this.pos.getPos(donde)).getRun(donde));
	}
	
	
	//public abstract String getGrafico();
	
	public abstract boolean getRun(ParaDonde donde) throws Exception;
	
	public void moverPersonajes() throws Exception{
		//No hago nada por defecto
	}
	
	public void actualizarEstadoObjeto() throws Exception{
		//No hago nada por defecto
	}
	/**
	 * Define, dependiendo de la subclase del objeto, el comportamiento que deve realizar
	 * al caerle un ObjetoNewton encima.
	 * @throws Exception
	 */
	public void meCaeAlgoEncima() throws Exception{
		//No hago nada por defecto
	}
	
	/**
	 * El personaje es reemplazado por una explosion
	 * @throws Exception
	 */
	public void recibeExplosion() throws Exception{ 
		
		Explosion exp = new Explosion(this.getPos().getX(), this.getPos().getY());
		Mapa.getInstancia().setPersonaje(exp, this.getPos()); 
		
	}
	
	public abstract boolean chequearSiSoy(BDTile tile);
	
	
}

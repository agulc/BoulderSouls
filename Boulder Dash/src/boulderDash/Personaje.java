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
	public void movimiento(int[] pos, int x, int y) throws Exception{
		if(Mapa.getInstancia().mapa[pos[0]+x][pos[1]+y] instanceof Diamante){
			if(Mapa.getInstancia().mapa[pos[0]][pos[1]] instanceof Rockford){
				Mapa.diamantesRestantes--;
			}
			else{
				return;
			}
		}
		Mapa.getInstancia().mapa[pos[0]+x][pos[1]+y]=Mapa.getInstancia().mapa[pos[0]][pos[1]];
		Mapa.getInstancia().mapa[pos[0]+x][pos[1]+y].pos.setY(pos[1]+y);//Tambien debo actualizar su posicion en la instancia pos
		Mapa.getInstancia().mapa[pos[0]+x][pos[1]+y].pos.setX(pos[0]+x);//Tambien debo actualizar su posicion en la instancia pos
		Mapa.getInstancia().mapa[pos[0]][pos[1]]=new Vacio(pos[0],pos[1]);
	}
	/**
	 * Permite seleccionar al objeto la dirección hacia donde debe desplazarse.
	 * @param donde
	 * @throws Exception
	 */
	public void mover(ParaDonde donde) throws Exception{
		int[] pos = this.pos.getPos();

		if(this.permitirMovimiento(donde,pos)){

			switch (donde) { //Cabe destacar que arriba y abajo se manejan al revez en este caso
				case ARRIBA: {
					this.movimiento(pos, 0, -1);
					break;

				}
				case ABAJO: {
					this.movimiento(pos, 0, +1);
					break;

				}		
				case IZQUIERDA: {
					this.movimiento(pos, -1, 0);
					break;

				}	
				case DERECHA: {
					this.movimiento(pos, 1, 0);
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
	public boolean permitirMovimiento(ParaDonde donde,int[] pos) throws Exception{
		int x = pos[0];
		int y = pos[1];
		if((x>=0)&&(x<40)&&((y>=0)&&(y<22))){
			switch (donde) {
				case ARRIBA: return Mapa.getInstancia().mapa[x][y-1].getRun();
				case ABAJO: return Mapa.getInstancia().mapa[x][y+1].getRun();		
				case IZQUIERDA: return Mapa.getInstancia().mapa[x-1][y].getRun();		
				case DERECHA: return Mapa.getInstancia().mapa[x+1][y].getRun();
				default: return false;
			}
		}
		return false;
	}
	
	
	//public abstract String getGrafico();
	
	public abstract boolean getRun();
	
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
		//No hace nada por defecto
	}
	
	/**
	 * El personaje es reemplazado por una explosion
	 * @throws Exception
	 */
	public void recibeExplosion() throws Exception{ 
		
		Explosion exp = new Explosion(this.getPos().getX(), this.getPos().getY());
		Mapa.getInstancia().setPersonaje((Personaje)exp); 
		
	}
}

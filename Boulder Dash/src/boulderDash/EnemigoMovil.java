package boulderDash;

public abstract class EnemigoMovil extends Enemigo {
	
	private ParaDonde direccionActual;
	
	EnemigoMovil(int x,int y){
		super(x,y);
		this.direccionActual = ParaDonde.ARRIBA; //Por defecto empieza hacia arriba
	}
	
	public ParaDonde getDireccionActual(){
		
		return this.direccionActual;
	}
	
	public void setDireccionActual(ParaDonde dir){
		
		this.direccionActual = dir;
	}
	
	public void meCaeAlgoEncima() throws Exception{
		if(Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.ROCK)){
			
			this.explotar();
			
		}
	}
	
	/**
	 * Forma en la que se expande una explosión al ocurrir dentro del mapa.
	 * @throws Exception . 
	 */
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
				Mapa.getInstancia().getPersonaje(pos).recibeExplosion(); //Envia la explosion al personaje
				
			}
		}
	}
	
	
	@Override
	public void moverPersonajes() throws Exception{

		this.mover(getDireccionActual());
		
	}
	
	
}

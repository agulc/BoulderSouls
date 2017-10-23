package boulderDash;

public class Roca extends ObjetoNewton{
	
	public Roca(boolean cae,int x,int y){
		super(cae,x,y);
	}
	
	/**
	 * Permite a Rockford mover las rocas.
	 */
	public boolean rockfordCaminaSobreMi(ParaDonde dir) throws Exception{
		
		this.mover(dir);
		return true;
		
				
	}
	
	public boolean getRun(ParaDonde donde) throws Exception{
		if(Mapa.getInstancia().getPersonaje(this.getPos(donde)).chequearSiSoy(BDTile.EMPTY))
		{
			return true;
		}
		else
			return false;
	}
	
	public void moverPersonajes() throws Exception{	
		super.moverPersonajes();
	}
	
	public String getGraficos(){
		return "R";
	}
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.ROCK);
	}

}

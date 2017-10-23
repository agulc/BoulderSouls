package boulderDash;

public class Roca extends ObjetoNewton{
	
	public Roca(boolean cae,int x,int y){
		super(cae,x,y);
	}
	
	public boolean rockfordCaminaSobreMi(ParaDonde dir) throws Exception{
		if (Mapa.getInstancia().getPersonaje(this.getPos(dir)).chequearSiSoy(BDTile.EMPTY))
		{
			this.mover(dir);
			return true;
		}
		return false;
				
	}
	
	public boolean getRun(){
		return false;
	}
	
	public void moverPersonajes() throws Exception{	
		super.moverPersonajes();
	}
	
	public String getGraficos(){
		return "Roca";
	}
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.ROCK);
	}

}

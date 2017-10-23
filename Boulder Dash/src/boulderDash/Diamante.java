package boulderDash;

public class Diamante extends ObjetoNewton{
	
	Diamante(boolean cae,int x,int y){
		super(cae,x,y);
	}
	
	public boolean getRun(ParaDonde donde){
		return true;
	}
	
	public boolean rockfordCaminaSobreMi (ParaDonde dir){
		
		Mapa.diamantesRestantes--;
		Mapa.incrementarPuntaje();
		return true;
	}
	
	public void moverPersonajes() throws Exception{	
		super.moverPersonajes();
	}
	
	public String getGraficos(){
		return "Diamante";
	}
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.DIAMOND);
	}
}

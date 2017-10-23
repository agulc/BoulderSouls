package boulderDash;

public class Suciedad extends Personaje {
	
	Suciedad(int x,int y){
		super(x,y);
	}
	
	public boolean getRun(ParaDonde donde){
		return true;
	}
	
	public void activarIA(){	
	}
	
	public String getGraficos(){
		return "S";
	}
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.DIRT);
	}
}

package boulderDash;

public class Vacio extends Personaje{
	
	Vacio(int x,int y){
		super(x,y);
	}
	
	public boolean getRun(){
		return true;
	}
	
	public void activarIA(){	
	}
	
	public String getGraficos(){
		return "Vacio";
	}
	
}

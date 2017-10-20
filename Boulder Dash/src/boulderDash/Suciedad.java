package boulderDash;

public class Suciedad extends Personaje {
	
	Suciedad(int x,int y){
		super(x,y);
	}
	
	public boolean getRun(){
		return true;
	}
	
	public void activarIA(){	
	}
	
	public String getGraficos(){
		return "Suciedad";
	}
}

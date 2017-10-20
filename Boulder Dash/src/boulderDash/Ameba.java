package boulderDash;

public class Ameba extends Enemigo{
	
	Ameba(int x,int y){
		super(x,y);
	}
	
	public boolean getRun(){
		return false;
	}
	
	public String getGraficos(){
		return "Ameba";
	}
	
}

package boulderDash;

public class Explosion extends Personaje{
	
	Explosion(int x,int y){
		super(x,y);
	}
	
	private int tiempo;
	
	public int tiempoRestante(){
		return tiempo;
	}
	
	public boolean getRun(){
		return true;
	}
	
	public void activarIA(){	
	}
}

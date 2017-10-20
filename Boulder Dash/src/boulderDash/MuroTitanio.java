package boulderDash;

public class MuroTitanio extends Muro {
	
	MuroTitanio(int x,int y){
		super(x,y);
	}
	
	public boolean getRun(){
		return false;
	}
	
	public void activarIA(){	
	}
	
	public String getGraficos(){
		return "MuroTitanio";
	}

}

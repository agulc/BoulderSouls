package boulderDash;

public class MuroMagico extends Muro{
	
	MuroMagico(int x,int y){
		super(x,y);
	}
	
	public boolean getRun(ParaDonde donde){
		return false;
	}
	
	public String getGraficos(){
		return "M";
	}
	


}

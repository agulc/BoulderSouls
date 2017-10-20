package boulderDash;

public class Diamante extends ObjetoNewton{
	
	Diamante(boolean cae,int x,int y){
		super(cae,x,y);
	}
	
	public boolean getRun(){
		return true;
	}
	
	public void activarIA() throws Exception{	
		super.activarIA();
	}
	
	public String getGraficos(){
		return "Diamante";
	}
}

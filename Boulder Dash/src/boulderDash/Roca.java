package boulderDash;

public class Roca extends ObjetoNewton{
	
	public Roca(boolean cae,int x,int y){
		super(cae,x,y);
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

}

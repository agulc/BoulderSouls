package boulderDash;

public class MuroTitanio extends Muro {
	
	MuroTitanio(int x,int y){
		super(x,y);
	}
	
	public boolean getRun(){
		return false;
	}
	
	public String getGraficos(){
		return "MuroTitanio";
	}
	
	@Override
	public void recibeExplosion() throws Exception{ //Si recibe una explosion, No hace nada (A diferencia del resto de personajes)

	}

}

package boulderDash;

public class MuroTitanio extends Muro {
	
	MuroTitanio(int x,int y){
		super(x,y);
	}
	
	public boolean getRun(ParaDonde donde){
		return false;
	}
	
	public String getGraficos(){
		return "#";
	}
	/**
	 *De haber una explosión, este no se inmuta.
	 */
	@Override
	public void recibeExplosion() throws Exception{ 
		//Si recibe una explosion, No hace nada (A diferencia del resto de personajes)
	}

}

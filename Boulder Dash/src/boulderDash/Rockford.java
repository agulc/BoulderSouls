package boulderDash;

public class Rockford extends Personaje{
	
	private static Rockford rock = null;
	
	public static Rockford getInstancia(){
		if(rock == null){
			rock = new Rockford();
		}
		return rock;
	}
	
	private Rockford(){
	}
	
	public Personaje setPosicion(int x, int y){//Lo hacemos asi porque sino no seria un singleton
		if(rock!=null){
			rock.pos.setX(x);
			rock.pos.setY(y);
		}
		return rock;
	}
	
	public boolean getRun(){
		return false;
	}
	
	public void activarIA(){
	}
	
	public String getGraficos(){
		return "Rockford";
	}
}

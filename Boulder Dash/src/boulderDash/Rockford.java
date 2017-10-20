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
			rock.getPos().setX(x);
			rock.getPos().setY(y);
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
	
	public void meCaeAlgoEncima() throws Exception{
		if(Mapa.getInstancia().getPersonaje(super.getPos(paraDonde.ARRIBA)) instanceof Roca){
			/*Rockford muere, todavia no se como*/
		}
		else{//Si no es una roca, me elimino a mi mismo y los diamantes restantes pasan a ser uno menos
			Mapa.diamantesRestantes--;
			Mapa.getInstancia().setPersonaje((Personaje) new Vacio(super.getPos(paraDonde.ARRIBA)));
			System.out.println("Diamante" + " en la posicion x=" + super.getPos(paraDonde.ARRIBA).getX() + " y=" + super.getPos(paraDonde.ARRIBA).getY() + " cayo encima de rockford");
		}
	}
}

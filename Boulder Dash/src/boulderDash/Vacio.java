package boulderDash;

public class Vacio extends Personaje{
	
	Vacio(Posicion pos){
		super(pos);
	}
	
	Vacio(int x, int y){
		super(x,y);
	}
	
	public boolean getRun(){
		return true;
	}
	
	public void activarIA(){	
	}
	
	public String getGraficos(){
		return "Vacio";
	}
	
	@Override
	public void meCaeAlgoEncima(Posicion pos) throws Exception{
		Mapa.getInstancia().getPersonaje(pos).mover(paraDonde.ABAJO);
		System.out.println(Mapa.getInstancia().getPersonaje(pos).getGraficos() + " en la posicion x=" + pos.getX() + " y=" + pos.getY() + " acaba de caer");
	}
}

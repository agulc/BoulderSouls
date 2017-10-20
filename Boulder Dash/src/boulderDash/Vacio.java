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
	public void meCaeAlgoEncima() throws Exception{
		System.out.println(Mapa.getInstancia().getPersonaje(super.getPos(paraDonde.ARRIBA)).getGraficos() + " en la posicion x=" + super.getPos(paraDonde.ARRIBA).getX() + " y=" + super.getPos(paraDonde.ARRIBA).getY() + " acaba de caer");
		Mapa.getInstancia().getPersonaje(super.getPos(paraDonde.ARRIBA)).mover(paraDonde.ABAJO);
	}
}

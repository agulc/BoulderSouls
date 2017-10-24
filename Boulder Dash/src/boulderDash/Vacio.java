package boulderDash;

public class Vacio extends Personaje{
	
	Vacio(Posicion pos){
		super(pos);
	}
	
	Vacio(int x, int y){
		super(x,y);
	}
	
	public boolean getRun(ParaDonde donde){
		return true;
	}
	
	public void activarIA(){	
	}
	
	public String getGraficos(){
		return " ";
	}
	
	@Override
	public void meCaeAlgoEncima() throws Exception{
		System.out.println(Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).getClass().getSimpleName() + " en la posicion x=" + super.getPos(ParaDonde.ARRIBA).getX() + " y=" + super.getPos(ParaDonde.ARRIBA).getY() + " acaba de caer");
		Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).mover(ParaDonde.ABAJO);
	}

	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.EMPTY);
	}
}

package boulderDash;

public class PuertaDeSalida extends Personaje{
	
	PuertaDeSalida(int x,int y){
		super(x,y);
		this.transitable = false;
	}
	
	private boolean transitable;
	
	public boolean getRun(ParaDonde donde){
		return transitable;
	}
	
	public void actualizarEstadoObjeto(){
		if(Mapa.diamantesRestantes<=0){
			this.transitable=true;
			System.out.println("Ahora la puerta esta abierta!!!!! ESCAPAA!!");
		}
	}
	
	public String getGraficos(){
		return "@";
	}
	
	/**
	 * De haber una explosión, este no se inmuta.
	 */
	@Override
	public void recibeExplosion() throws Exception{ //Si recibe una explosion, No hace nada (A diferencia del resto de personajes)

	}
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.EXIT);
	}
	
	public boolean rockfordCaminaSobreMi (ParaDonde donde) throws Exception{
		//IMPLEMENTAR
		//SI se llega a la salida y esta abierta, se aumenta el nivel, y se reconstruye el mapa
		return this.transitable;
	}

}

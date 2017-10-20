package boulderDash;

public class PuertaDeSalida extends Personaje{
	
	PuertaDeSalida(int x,int y){
		super(x,y);
		this.transitable = false;
	}
	
	private boolean transitable;
	
	public boolean getRun(){
		return transitable;
	}
	
	public void actualizarEstadoObjeto(){
		if(Mapa.diamantesRestantes<=0){
			this.transitable=true;
			System.out.println("Ahora la puerta esta abierta!!!!! ESCAPAA!!");
		}
	}
	
	public String getGraficos(){
		return "PuertaDeSalida";
	}
	
	@Override
	public void recibeExplosion() throws Exception{ //Si recibe una explosion, No hace nada (A diferencia del resto de personajes)

	}

}

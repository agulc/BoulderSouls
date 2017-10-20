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
	
	public void activarIA(){
		if(Mapa.diamantesRestantes<=0){
			this.transitable=true;
			System.out.println("Ahora la puerta esta abierta!!!!! ESCAPAA!!");
		}
	}
	
	public String getGraficos(){
		return "PuertaDeSalida";
	}
}

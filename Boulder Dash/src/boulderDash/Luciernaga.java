package boulderDash;

public class Luciernaga extends EnemigoMovil{
	
	Luciernaga(int x,int y){
		super(x,y);
	}
	
	public boolean getRun(){
		return false;
	}

	public void activarIA(){	
	}
	
	public String getGraficos(){
		return "Luciernaga";
	}
	
	public void meCaeAlgoEncima() throws Exception{
		if(Mapa.getInstancia().getPersonaje(super.getPos(paraDonde.ARRIBA)) instanceof Roca){
			//La luciernaga explota, tampoco se como
		}
	}
			
}

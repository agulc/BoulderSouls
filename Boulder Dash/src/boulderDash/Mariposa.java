package boulderDash;

public class Mariposa extends EnemigoMovil{
	
	Mariposa(int x,int y){
		super(x,y);
	}
	
	public boolean getRun(){
		return false;
	}
	
	public void activarIA(){	
			
	}
	
	public String getGraficos(){
		return "Mariposa";
	}
	
	public void meCaeAlgoEncima() throws Exception{
		if(Mapa.getInstancia().getPersonaje(super.getPos(paraDonde.ARRIBA)) instanceof Roca){
			//La mariposa explota, tampoco se como
		}
	}
}

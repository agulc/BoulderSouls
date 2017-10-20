package boulderDash;

public class Explosion extends Personaje{
	
	Explosion(int x,int y){
		super(x,y);
		tiempo = 1;
	}
	
	private int tiempo;
	
	public int tiempoRestante(){
		return tiempo;
	}
	
	public boolean getRun(){
		return true;
	}
	
	public void activarIA(){	
		if(tiempo == 0){
			int[] pos = super.pos.getPos();
			Mapa.mapa[1][2] = new Vacio(pos[0]);
			
		}
	}
}

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
	
	public String getGraficos(){
		return "Explosion";
	}
	
	public void actualizarEstadoObjeto() throws Exception{
		tiempo--; //disminuye el tiempo restante
		
		if (tiempo <= 0) //Si se termina el tiempo
		{
			Vacio vacio = new Vacio(this.getPos().getX(), this.getPos().getY());
			Mapa.getInstancia().setPersonaje((Personaje)vacio); //Sobreescribo la explosion con un personaje vacio
		}
		
	}
	
}

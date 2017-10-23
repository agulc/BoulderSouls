package boulderDash;

public class Explosion extends Personaje{
	
	Explosion(int x,int y){
		super(x,y);
		tiempo = 1;
	}
	
	private int tiempo;
	/**
	 * Hace referencia a la cantidad de "turnos" que debe durar una explosion
	 * @return
	 */
	public int tiempoRestante(){
		return tiempo;
	}
	
	public boolean getRun(){
		return true;
	}
	
	public String getGraficos(){
		return "Explosion";
	}
	/**
	 * Comportamiento de la explosion
	 */
	public void actualizarEstadoObjeto() throws Exception{
		tiempo--; //disminuye el tiempo restante
		
		if (tiempo <= 0) //Si se termina el tiempo
		{
			Mapa.getInstancia().setPersonaje(new Vacio(this.getPos()), this.getPos()); //Sobreescribo la explosion con un personaje vacio
		}
		
	}
	
	public boolean chequearSiSoy (BDTile tile){

		return false;
	}
	
}

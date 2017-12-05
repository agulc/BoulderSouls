package com.boulderdash.personajes;

import com.boulderdash.audio.Audio;
import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Mapa;
import com.boulderdash.principal.Posicion;
import javax.swing.ImageIcon;

/**
 * Clase abstracta utilizada para modelizar a todos los personajes
 */
public abstract class Personaje {
	private Posicion pos;
	
	Personaje(int x,int y){
		pos = new Posicion(x,y);
	}
	
	Personaje(Posicion pos2){
		pos = new Posicion();
		pos = pos2;
	}
	
	Personaje(){
		pos = new Posicion();
	}
	
	public Posicion getPos(){
		return pos;
	}
	
	public void setPos(Posicion posAux){

		this.pos = posAux;
	}
	
	public Posicion getPos(ParaDonde donde){
		return pos.getPos(donde);
	}
	/**
	 * Permite al objeto tomar cierto comportamiento cuando Rockford
	 * intenta pasar sobre su posición.
	 * @param donde Dirección.
	 * @return Si caminará o no.
	 */
	public boolean rockfordCaminaSobreMi (ParaDonde donde){
		
		return true;
	}
	/**
	 * Verifica si es posible realizar el movimiento en la dirección deseada.
	 * Si es posible, lo realiza.
	 * @param dir Dirección a desplazarse.
	 */
	public void movimiento(ParaDonde dir){

		if (Mapa.getInstancia().getPersonaje(this.getPos(dir)).chequearSiSoy(BDTile.EMPTY)){

			Mapa.getInstancia().setPersonaje(this , getPos(dir)); //Se mueve al siguiente casillero
			Mapa.getInstancia().setPersonaje(new Vacio(this.getPos()), this.getPos());
			setPos(getPos(dir)); //Actualizo mi posicion
			
		}
	}
	/**
	 * Permite seleccionar al objeto la dirección hacia donde debe desplazarse.
	 * @param donde Dirección.
	 */
	public void mover(ParaDonde donde){


		if(this.permitirMovimiento(donde)){

			switch (donde) { 
				case ARRIBA: {
					this.movimiento(ParaDonde.ARRIBA);
					break;

				}
				case ABAJO: {
					this.movimiento(ParaDonde.ABAJO);
					break;

				}		
				case IZQUIERDA: {
					this.movimiento(ParaDonde.IZQUIERDA);
					break;

				}	
				case DERECHA: {
					this.movimiento(ParaDonde.DERECHA);
					break;

				}
			}
		}
	}
	
	/**
	 * Devuelve el icono del personaje en cuestion
	 */
	public abstract ImageIcon getGraficos();
	

	/**
	 * Permite saber si el casillero en la dirección hacia 
	 * donde el personaje desea moverse es transitable.
	 * @param donde Dirección de movimiento.
	 * @return Si es transitable o no.
	 */
	public boolean permitirMovimiento(ParaDonde donde){
		try {
			return (Mapa.getInstancia().getPersonaje(this.pos.getPos(donde)).esTransitable(donde));
		} catch (Exception e) {
			System.out.println("Error?");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Utilizado para saber si rockford puede transitar sobre el objeto o no
	 */
	public abstract boolean esTransitable(ParaDonde donde);
	
	/**
	 * Utilizado para mover al personaje, dependiendo de su comportamiento
	 */
	public void moverPersonajes(){
		//No hago nada por defecto
	}
	
	/**
	 * Utilizado para actualizar el estado del objeto (por ejemplo si un objeto newton esta cayendo o no), dependiendo de su comportamiento
	 */
	public void actualizarEstadoObjeto(){
		//No hago nada por defecto
	}
	/**
	 * Define, dependiendo de la subclase del objeto, el comportamiento que debe realizar.
	 * al caerle un ObjetoNewton encima.
	 */
	public void meCaeAlgoEncima(){
		//No hago nada por defecto
	}
	
	/**
	 * El personaje es reemplazado por una explosión.
	 */
	public void recibeExplosion(){ 
		
		Explosion exp = new Explosion(this.getPos().getX(), this.getPos().getY());
		Mapa.getInstancia().setPersonaje(exp, this.getPos());
		System.out.println(this.getClass().getSimpleName() + " en la posicion x=" + this.getPos().getX() +" y=" + this.getPos().getY() + " EXPLOTO!!!");
		
	}
	/**
	 * Verifica que el enumerativo que representa a la instancia del objeto en cuestión, concuerda
	 * con el enumerativo recibido por parámetro.
	 * @param tile Nombre el cual se desea saber si corresponde al del objeto
	 * @return Si es ese tipo de objeto o no.
	 */
	public abstract boolean chequearSiSoy(BDTile tile);
	
	/**
	 * Crea una explosion de 3x3
	 */
	public void explotar(){
		int a = this.getPos().getX() - 1; //Empieza en la esquina superior izquierda
		int b = this.getPos().getY() - 1;
		Posicion pos = new Posicion();
		int aAux = a+3;
		int bAux = b+3;
		
		Mapa.getInstancia().getPersonaje(this.getPos()).recibeExplosion();
		for (int i = a; i<aAux; i++) //Recorre los personajes adyacentes
		{
			for (int j = b; j<bAux; j++)
			{
				pos.setX(i);
				pos.setY(j);
				Mapa.getInstancia().getPersonaje(pos).recibeExplosion(); //Envia la explosion al personaje
				
			}
		}
		Audio.explosion();
	}

}

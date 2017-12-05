package com.boulderdash.personajes;

import javax.swing.ImageIcon;

import com.boulderdash.audio.Audio;
import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Comportamiento;
import com.boulderdash.principal.Mapa;

/**
 * Clase utilizada para modelizar a rockford, el cual es singleton, ya que se accede a el todo el tiempo
 */
public class Rockford extends Personaje{
	
	private static ImageIcon iconoActual = new ImageIcon("Texturas/RockfordStatic.gif");
	private static ImageIcon iconoIzquierda = new ImageIcon("Texturas/RockfordLeft.gif");
	private static ImageIcon iconoDerecha = new ImageIcon("Texturas/RockfordRight.gif");
	private static ImageIcon iconoParado = new ImageIcon("Texturas/RockfordStatic.gif");
	
	private static Rockford rock = null;
	
	private static ParaDonde direccionActual = null;
	
	public static Rockford getInstancia(){
		if(rock == null){
			rock = new Rockford();
		}
		return rock;
	}
	
	private Rockford(){
	}
	

	public Personaje setPosicion(int x, int y){//Lo hacemos asi porque sino no seria un singleton
		if(rock!=null){
			rock.getPos().setX(x);
			rock.getPos().setY(y);
		}
		return rock;
	}
	
	public boolean esTransitable(ParaDonde donde){
		return false;
	}
	
	/**
	 * Utilizado para modelizar la muerte de rockford, bajando una vida, o muriendo definitivamente
	 */
	public void muerte(){
		
		Mapa.getInstancia().setVidas(Mapa.getInstancia().getVidas() - 1); //Bajo las vidas
		
		if (Mapa.getInstancia().getVidas() == 0){
			System.out.println("HAS MUERTO");
			Comportamiento.setRockfordMuerto(true);
			
			if (Comportamiento.getMuerteExtra()) //Si la muerte extra esta activada, se ejecuta
				Audio.muerteExtra();
		}
		else
		{
			System.out.println("Te quedan "+Mapa.getInstancia().getVidas()+" vidas.");
			Comportamiento.setRockfordMuerto(true);
			
		}
		
	}
	
	public void meCaeAlgoEncima(){
		if(Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.ROCK)||Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.DIAMOND)){
			System.out.println("Roca" + " en la posicion x=" + super.getPos(ParaDonde.ARRIBA).getX() + " y=" + super.getPos(ParaDonde.ARRIBA).getY() + " cayo encima de rockford");
			this.explotar();
		}
	}
	
	@Override
	public void recibeExplosion(){ 
		
		Explosion exp = new Explosion(this.getPos().getX(), this.getPos().getY());
		Mapa.getInstancia().setPersonaje(exp, this.getPos());
		this.muerte();
		

	}

	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.PLAYER);
	}
	
	public void moverPersonajes(){

		if((direccionActual != null)&&(this.permitirMovimiento(direccionActual))){
			if (Mapa.getInstancia().getPersonaje(super.getPos(direccionActual)).rockfordCaminaSobreMi(direccionActual) ){ //Si se pudo mover
				
				Mapa.getInstancia().setPersonaje(Rockford.getInstancia(),super.getPos(direccionActual)); //Se mueve al siguiente casillero
				Mapa.getInstancia().setPersonaje(new Vacio(this.getPos()), this.getPos()); //Vacia el cacillero anterior
				super.setPos(super.getPos(direccionActual)); //Actualizo mi posicion
			}
			actualizarGif();
			direccionActual = null;
		}
			
	}
	
	public void actualizarEstadoObjeto(){
		if(iconoActual!=iconoParado){
			iconoActual = iconoParado;
		}
	}
	
	/**
	 * Utilizado para mostrar el gif correspondiente a donde me estoy moviendo
	 */
	public void actualizarGif(){
		if(direccionActual!=null){
			switch(direccionActual){
				case IZQUIERDA:{
					iconoActual = iconoIzquierda;
					break;
				}
				case DERECHA:{
					iconoActual = iconoDerecha;
					break;
				}
				default:{
				break;
				}
			}
		}
	}

	@Override
	public ImageIcon getGraficos() {
		return iconoActual;
	}
	
	public static void setMovimiento(ParaDonde pos){
		direccionActual = pos;
	}
	
}

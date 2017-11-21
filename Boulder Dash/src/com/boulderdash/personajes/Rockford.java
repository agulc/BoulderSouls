package com.boulderdash.personajes;

import com.boulderdash.entradasalida.BDTile;
import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Comportamiento;
import com.boulderdash.principal.CoordinadorDeEventos;
import com.boulderdash.principal.Mapa;
import com.boulderdash.principal.Posicion;
import javax.swing.*;

public class Rockford extends Personaje{
	
	private static ImageIcon icono = new ImageIcon("rockford.gif");
	
	private static Rockford rock = null;
	
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
	
	public String getGraficos(){
		return "®";
	}
	
	public void muerte(){
		
		Mapa.getInstancia().setVidas(Mapa.getInstancia().getVidas() - 1); //Bajo las vidas
		
		if (Mapa.getInstancia().getVidas() == 0){
			System.out.println("HAS MUERTO");
			Comportamiento.setRockfordMuerto(true);
		}
		else
		{
			System.out.println("Rockford exploto!"+" Te quedan "+Mapa.getInstancia().getVidas()+" vidas.");
			Comportamiento.setRockfordMuerto(true);
			
		}
		
		
		
	}
	
	public void meCaeAlgoEncima(){
		if(Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.ROCK)){
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
	
	public void movimiento(ParaDonde dir){

		if (Mapa.getInstancia().getPersonaje(super.getPos(dir)).rockfordCaminaSobreMi(dir)){ //Si se pudo mover
				
			Mapa.getInstancia().setPersonaje(Rockford.getInstancia(),super.getPos(dir)); //Se mueve al siguiente casillero
			Mapa.getInstancia().setPersonaje(new Vacio(this.getPos()), this.getPos()); //Vacia el cacillero anterior
			super.setPos(super.getPos(dir)); //Actualizo mi posicion
				
		}
			
	}
	
	public void explotar(){
		
		int a = this.getPos().getX() - 1; //Empieza en la esquina superior izquierda
		int b = this.getPos().getY() - 1;
		Posicion pos = new Posicion();
		int aAux = a+3;
		int bAux = b+3;
		
		for (int i = a; i<aAux; i++) //Recorre los personajes adyacentes
		{
			for (int j = b; j<bAux; j++)
			{
				pos.setX(i);
				pos.setY(j);
				Mapa.getInstancia().getPersonaje(pos).recibeExplosion(); //Envia la explosion al personaje
				
			}
		}
		System.out.println(this.getClass().getSimpleName() + " en la posicion x=" + this.getPos().getX() +" y=" + this.getPos().getY() + " acaba de explotar");
	}

	@Override
	public ImageIcon getIcono() {
		// TODO Auto-generated method stub
		return icono;
	}
	
}

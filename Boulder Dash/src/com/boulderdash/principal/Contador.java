package com.boulderdash.principal;
import java.util.TimerTask;

public class Contador extends TimerTask {

	public void run() {
		//Decrementa el contador en 1
		Mapa.getInstancia().decrementarTiempoRestante();
	}
}
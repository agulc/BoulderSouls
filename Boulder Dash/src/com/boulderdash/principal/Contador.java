package com.boulderdash.principal;
import java.util.TimerTask;

import com.boulderdash.interfaz.Gui;
import com.boulderdash.interfaz.GuiMuerte;
import com.boulderdash.personajes.Rockford;

public class Contador extends TimerTask {

	public void run() {
		//Decrementa el contador en 1
		Mapa.getInstancia().decrementarTiempoRestante();
		if(Mapa.getInstancia().getTiempoRestante() <= 0){
			//Morir
			if(Mapa.getInstancia().getVidas() <= 1){
				CoordinadorDeEventos.detenerTemporizador();
				Gui.getInstancia().getHud().actualizarHud();;
				Rockford.getInstancia().explotar();
				Gui.getInstancia().getMatriz().reconstruir();
				try {
					Thread.sleep(200); //Para que se grafique la explosion
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				GuiMuerte.muerte();
			}
			else{
			Rockford.getInstancia().explotar();
			}
		}
	}
}
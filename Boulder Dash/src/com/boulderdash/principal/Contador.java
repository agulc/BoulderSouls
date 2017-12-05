package com.boulderdash.principal;
import java.util.TimerTask;

import com.boulderdash.interfaz.Gui;
import com.boulderdash.interfaz.GuiMuerte;
import com.boulderdash.personajes.Rockford;

/**
 * Clase que define un timer task con comportamiento definido para decrementar el contador del hud
 */
public class Contador extends TimerTask {

	public void run() {
		
		Mapa.setTiempoAcumulado(Mapa.getTiempoAcumulado() + 1);
		
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
package com.boulderdash.teclaescucha;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.interfaz.Gui;
import com.boulderdash.personajes.Rockford;
import com.boulderdash.principal.Comportamiento;

/**
 * Clase para crear un key listener, que responda al movimiento de rockford con 
 * las flechas y wasd, que se pueda volver al menu principal con escape.
 */
public class MiTeclaEscucha extends KeyAdapter{

	/**
	 * Responde a las teclas presionadas
	 */
	public void keyPressed(KeyEvent e)
	{
		
		if(!Comportamiento.getRockfordMuerto()) {
			
		
		switch (e.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
		{
			Rockford.setMovimiento(ParaDonde.IZQUIERDA);
		}
		break;
		
		case KeyEvent.VK_RIGHT:
		{
			Rockford.setMovimiento(ParaDonde.DERECHA);
		}
		break;
		
		case KeyEvent.VK_DOWN:
		{
			Rockford.setMovimiento(ParaDonde.ABAJO);
		}
		break;
		
		case KeyEvent.VK_UP:
		{
			Rockford.setMovimiento(ParaDonde.ARRIBA);
		}
		break;
		
		case KeyEvent.VK_A:
		{
			Rockford.setMovimiento(ParaDonde.IZQUIERDA);
		}
		break;
		
		case KeyEvent.VK_D:
		{
			Rockford.setMovimiento(ParaDonde.DERECHA);
		}
		break;
		
		case KeyEvent.VK_S:
		{
			Rockford.setMovimiento(ParaDonde.ABAJO);
		}
		break;
		
		case KeyEvent.VK_W:
		{
			Rockford.setMovimiento(ParaDonde.ARRIBA);
		}
		break;
		
		
		case KeyEvent.VK_ESCAPE:
		{
			Gui.getInstancia().getTitulo().volverAlTitulo();
		}
		break;
		
		//Opciones usadas para testeo, pueden ser activadas, funcionan perfectamente
		/*case KeyEvent.VK_SPACE: //Rockford explota
		{
			Rockford.getInstancia().explotar();
		}
		break;
		
		case KeyEvent.VK_E: //Explota un bloque aleatorio en la zona central del mapa
		{
			Posicion pos = new Posicion ();
					
			pos.setX(5 + (int)(Math.random() * ((32 - 1) + 1)));
			pos.setY(5 + (int)(Math.random() * ((14 - 1) + 1)));
					
			Mapa.getInstancia().getPersonaje(pos).explotar();
		}
		break;*/
		
		}
		}	
	}
}

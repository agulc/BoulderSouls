package com.boulderdash.teclaescucha;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.principal.Comportamiento;



public class MiTeclaEscucha extends KeyAdapter{

	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
		{
			Comportamiento.moverARockford(ParaDonde.IZQUIERDA);
		}
		break;
		
		case KeyEvent.VK_RIGHT:
		{
			Comportamiento.moverARockford(ParaDonde.DERECHA);
		}
		break;
		
		case KeyEvent.VK_DOWN:
		{
			Comportamiento.moverARockford(ParaDonde.ABAJO);
		}
		break;
		
		case KeyEvent.VK_UP:
		{
			Comportamiento.moverARockford(ParaDonde.ARRIBA);
		}
		break;
			
		}

		
	}
}

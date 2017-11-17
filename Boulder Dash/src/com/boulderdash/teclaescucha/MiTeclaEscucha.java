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
			System.out.println("LEFT");
			Comportamiento.comportamientoNormal(ParaDonde.IZQUIERDA);
		}
		break;
		
		case KeyEvent.VK_RIGHT:
		{
			System.out.println("RIGHT");
			Comportamiento.comportamientoNormal(ParaDonde.DERECHA);
		}
		break;
		
		case KeyEvent.VK_DOWN:
		{
			System.out.println("DOWN");
			Comportamiento.comportamientoNormal(ParaDonde.ABAJO);
		}
		break;
		
		case KeyEvent.VK_UP:
		{
			System.out.println("UP");
			Comportamiento.comportamientoNormal(ParaDonde.ARRIBA);
		}
		break;
			
		}

		
	}
}

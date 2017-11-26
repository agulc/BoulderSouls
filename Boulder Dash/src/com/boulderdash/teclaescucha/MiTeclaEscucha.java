package com.boulderdash.teclaescucha;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.boulderdash.enumerativos.ParaDonde;
import com.boulderdash.interfaz.Gui;
import com.boulderdash.personajes.Rockford;
import com.boulderdash.principal.Comportamiento;



public class MiTeclaEscucha extends KeyAdapter{

	public void keyPressed(KeyEvent e)
	{
		
		
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
		
		case KeyEvent.VK_SPACE:
		{
			Rockford.getInstancia().explotar();
		}
		break;
		
		case KeyEvent.VK_ESCAPE:
		{
			Gui.getInstancia().getTitulo().volverAlTitulo();
		}
		break;
		
		
		
		}	
	}
}

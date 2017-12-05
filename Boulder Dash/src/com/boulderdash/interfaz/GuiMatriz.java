package com.boulderdash.interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.boulderdash.principal.Mapa;
import com.boulderdash.principal.Posicion;
import com.boulderdash.teclaescucha.MiTeclaEscucha;

@SuppressWarnings("serial")
/**
 * Clase utilizada para crear el panel del entorno del juego en si, el mapa
 */
public class GuiMatriz extends JPanel{
	
	private static MiTeclaEscucha teclaEscucha = new MiTeclaEscucha();
	private static JLabel labels[] = new JLabel[880];
	
	public GuiMatriz()
	{
		this.setLayout(new GridLayout(22,40,0,0));
		this.addKeyListener(teclaEscucha);
		this.setBackground(Color.black); 
		
		Mapa.getInstancia().construirMapa();
		Posicion pos = new Posicion();
		for (int i = 0; i < 880; i++) 
		{
			pos.setX(i%40);
			pos.setY(i/40);
			labels[(i)] = new JLabel(Mapa.getInstancia().getPersonaje(pos).getGraficos());
			this.add(labels[(i)], (i));
		}
	}
	
	/**
	 * Metodo utilizado cuando rockford muere, o cuando se pasa de nivel para reconstruir el entorno
	 */
	public void reconstruir() 
	{
		  Posicion pos = new Posicion();
		  Gui.getInstancia().getHud().actualizarHud();
		  
		  for (int i = 0; i < 880; i++) 
		  {
			  pos.setX(i%40);
			  pos.setY(i/40);
			  labels[i].setIcon(Mapa.getInstancia().getPersonaje(pos).getGraficos());
		  }
		  Gui.getInstancia().getMatriz().validate();
	}


	public static MiTeclaEscucha getTeclaEscucha() {
		return teclaEscucha;
	}


	public static void setTeclaEscucha(MiTeclaEscucha teclaEscucha) {
		GuiMatriz.teclaEscucha = teclaEscucha;
	}
	
	
	
}

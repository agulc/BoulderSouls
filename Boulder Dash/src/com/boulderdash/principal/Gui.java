package com.boulderdash.principal;

import java.awt.*;
import javax.swing.*;

import com.boulderdash.teclaescucha.MiTeclaEscucha;

public class Gui extends JFrame{
	
	
	private static JLabel labels[] = new JLabel[880];
	private static JPanel panel = new JPanel(new GridLayout(22,40,0,0));

	
	public Gui() {
		
		setSize(1206, 579);
	    

		addKeyListener(new MiTeclaEscucha());
		Posicion pos;
		for (int i = 0; i < 880; i++) {
			pos = new Posicion(i%40, i/40);
			labels[(i)] = new JLabel(Mapa.getInstancia().getPersonaje(pos).getIcono());
			panel.add(labels[(i)], (i));
		}
		add(panel);
		pack();
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void cargarImagenes(Posicion pos) {
		int x = pos.getX()*40 + pos.getY();
		labels[(x)] = new JLabel(Mapa.getInstancia().getPersonaje(pos).getIcono());
		panel.remove((x));
		panel.add(labels[(x)], (x));
		repaint();
		
	}
	
	
}

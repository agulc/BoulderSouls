package com.boulderdash.principal;

import java.awt.*;
import javax.swing.*;

import com.boulderdash.teclaescucha.MiTeclaEscucha;

public class GUI extends JFrame{
	
	
	private static JLabel labels[] = new JLabel[880];
	private static JPanel panel = new JPanel(new GridLayout(22,40,0,0));
	private static ImageIcon icono = new ImageIcon("steel.gif");

	
	public GUI() {
		
		setSize(1206, 579);
	    

		addKeyListener(new MiTeclaEscucha());
		for (int i = 0; i < 880; i++) {
			labels[i] = new JLabel(icono);
			panel.add(labels[i], i);
		}
		icono = new ImageIcon("diamond.gif");
		for (int x = 0; x < 880; x=x+2) {
			labels[x] = new JLabel(icono);
			panel.remove(x);
			panel.add(labels[x], x);
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
		add(panel);
		pack();
		setVisible(true);
		
	}
	
	private  void actualizar() {

	}
}

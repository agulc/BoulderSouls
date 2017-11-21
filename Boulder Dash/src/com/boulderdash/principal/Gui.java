package com.boulderdash.principal;

import java.awt.*;
import javax.swing.*;

import com.boulderdash.teclaescucha.MiTeclaEscucha;

public class Gui extends JFrame{
	
	
	private static JLabel labels[] = new JLabel[880];
	public static JPanel panel = new JPanel(new GridLayout(22,40,0,0));
	private static Gui instancia = null;
	
	private Gui() {
		
		setSize(1206, 579);
	    setResizable(false);

		addKeyListener(new MiTeclaEscucha());
		Posicion pos = new Posicion();
		for (int i = 0; i < 880; i++) {
			pos.setX(i%40);
			pos.setY(i/40);
			labels[(i)] = new JLabel(Mapa.getInstancia().getPersonaje(pos).getIcono());
			panel.add(labels[(i)], (i));
		}
		add(panel);
		pack();
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static Gui getInstancia(){
		if(instancia == null){
			instancia = new Gui();
		}
		return instancia;
	}
	
	public void cargarImagenes() {
		Posicion pos = new Posicion();
		for (int i = 0; i < 880; i++) {
			pos.setX(i%40);
			pos.setY(i/40);
			if(!(labels[(i)].equals(Mapa.getInstancia().getPersonaje(pos).getIcono()))){
				labels[(i)] = new JLabel(Mapa.getInstancia().getPersonaje(pos).getIcono());
				panel.remove(i);
				panel.add(labels[(i)], (i));
			}
		}
		pack();
		this.repaint();
	}	
}

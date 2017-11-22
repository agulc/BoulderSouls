package com.boulderdash.principal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.boulderdash.audio.Audio;
import com.boulderdash.teclaescucha.MiTeclaEscucha;

public class Gui extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JLabel labels[] = new JLabel[880];
	public static JPanel panel = new JPanel(new GridLayout(22,40,0,0));
	private static Gui instancia = null;
	private static JButton botonParaEmpezar;
	private static JComboBox<String> nivelAElegir = new JComboBox<String>();
	
	private Gui(){
		super("Boulder Dash");
		inicializarGui();
	}
	
	private void inicializarGui(){
		this.setLayout(new FlowLayout());
		setSize(1206, 579);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		botonParaEmpezar = new JButton("Empezar!!");
		botonParaEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mapa.getInstancia().setNivelActual(nivelAElegir.getSelectedIndex()+1);
				empezarAJugar();
			}
		});
		this.add(botonParaEmpezar);
		String[] items = {"1","2","3","4","5","6","7","8","9","10"};
		nivelAElegir = new JComboBox<String>(items);
		this.add(nivelAElegir);
		setVisible(true);
	}
	
	public static Gui getInstancia(){
		if(instancia == null){
			instancia = new Gui();
		}
		return instancia;
	}
	
	private void empezarAJugar(){
		this.remove(botonParaEmpezar);
		this.remove(nivelAElegir);
		this.setLayout(new BorderLayout());
		Mapa.getInstancia().construirMapa();
		addKeyListener(new MiTeclaEscucha());
		Posicion pos = new Posicion();
		for (int i = 0; i < 880; i++) {
			pos.setX(i%40);
			pos.setY(i/40);
			labels[(i)] = new JLabel(Mapa.getInstancia().getPersonaje(pos).getIcono());
			panel.add(labels[(i)], (i));
		}
		panel.setBackground(Color.black);
		add(panel);
		pack();
		repaint();
		Comportamiento.Inicializar();
		Audio.pararMusica();
		Audio.musica();
	}
	
	public void actualizarImagenes(Posicion pos) {
		int i = pos.getY()*40 + pos.getX();
		labels[(i)] = new JLabel(Mapa.getInstancia().getPersonaje(pos).getIcono());
		panel.remove(i);
		panel.add(labels[(i)], (i));
		pack();
		this.repaint();
	}
	
	public void reconstruir() {
		  Posicion pos = new Posicion();
		  for (int i = 0; i < 880; i++) {
		  pos.setX(i%40);
		  pos.setY(i/40);
		  labels[(i)] = new JLabel(Mapa.getInstancia().getPersonaje(pos).getIcono());
		  panel.remove(i);
		  panel.add(labels[(i)], (i));
		  }
	}
	
	
	public void hasMuerto()
	{
		remove(panel);
		
		ImageIcon image = new ImageIcon("./Texturas/You Died.gif");
		JLabel etiqueta = new JLabel(image);

		Panel pan = new Panel();
		pan.setLayout(new BorderLayout());
		
		pan.add(etiqueta);
		add(pan);
		
		pack();
		repaint();
		
		Audio.hasMuerto();
		try {
			Thread.sleep(2850);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		remove(pan);
		setVisible(false);
	}
	
}

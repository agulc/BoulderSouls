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
	public static JPanel panelTitulo = new JPanel(new FlowLayout());
	public static JPanel panel;
	private static Gui instancia = null;
	
	private static MiTeclaEscucha teclaEscucha = new MiTeclaEscucha();
	

	
	private Gui(){
		super("Boulder Dash");
		inicializarGui();
	}
	
	private void inicializarGui(){

		panelTitulo = new JPanel(new BorderLayout());
		
		JLabel labelTitulo = new JLabel(new ImageIcon("./Texturas/Titulo.png"));
		JLabel labelTitulo2 = new JLabel(new ImageIcon("./Texturas/TituloBonfire.gif"));
		JButton botonParaEmpezar;
		String[] items = {"1","2","3","4","5","6","7","8","9","10"};
		final JComboBox<String> nivelAElegir = new JComboBox<String>(items);
		
		panelTitulo.setBackground(Color.BLACK);

		setSize(1206, 579);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		panelTitulo.add(labelTitulo, BorderLayout.PAGE_START);
		
		botonParaEmpezar = new JButton("Empezar!!");
		botonParaEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mapa.getInstancia().setNivelActual(nivelAElegir.getSelectedIndex()+1);
				remove(panelTitulo);
				empezarAJugar();
			}
		});
		
		panelTitulo.add(labelTitulo2, BorderLayout.CENTER);
		
		Container container = new Container();
		container.setLayout(new FlowLayout());
		container.add(botonParaEmpezar);
		container.add(nivelAElegir);
		
		panelTitulo.add(container, BorderLayout.PAGE_END);
		
		
		
		
		this.add(panelTitulo);
		setVisible(true);
		
		
	}
	
	public static Gui getInstancia(){
		if(instancia == null){
			instancia = new Gui();
		}
		return instancia;
	}

	private void empezarAJugar(){
		
		Comportamiento.setRockfordMuerto(false);
		panel = new JPanel(new GridLayout(22,40,0,0));
		this.setLayout(new BorderLayout());
		Mapa.getInstancia().construirMapa();
		addKeyListener(teclaEscucha);
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
		
		 requestFocus(); //Se centra en el JFrame para responder al key listener
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
		  for (int i = 0; i < 880; i++) 
		  {
			  pos.setX(i%40);
			  pos.setY(i/40);
			  labels[(i)] = new JLabel(Mapa.getInstancia().getPersonaje(pos).getIcono());
			  panel.remove(i);
			  panel.add(labels[(i)], (i));
		  }
	}
	
	
	public void hasMuerto()
	{
		removeKeyListener(teclaEscucha);
		remove(panel);
		
		ImageIcon image = new ImageIcon("./Texturas/You Died.gif");
		JLabel etiqueta = new JLabel(image);

		Panel panelMuerte = new Panel();
		panelMuerte.setLayout(new BorderLayout());
		
		panelMuerte.add(etiqueta);
		add(panelMuerte);
		
		pack();
		repaint();
		
		Audio.hasMuerto();
		try {
			Thread.sleep(2850);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		remove(panelMuerte);
		
		this.reconstruir(); //Reconstruye el panel del mapa
		
		add(panelTitulo);
		Audio.musicaMenu();
		
		repaint();
		
	}
	
}

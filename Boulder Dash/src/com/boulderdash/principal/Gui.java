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
	public static JPanel panel = new JPanel(new GridLayout(22,40,0,0));
	private static Gui instancia = null;

	
	private Gui(){
		super("Boulder Dash");
		inicializarGui();
	}
	
	private void inicializarGui(){

		JLabel labelTitulo = new JLabel(new ImageIcon("./Texturas/Titulo.png"));
		JLabel labelTitulo2 = new JLabel(new ImageIcon("./Texturas/TituloBonfire.gif"));
		JButton botonParaEmpezar;
		String[] items = {"1","2","3","4","5","6","7","8","9","10"};
		final JComboBox<String> nivelAElegir = new JComboBox<String>(items);
		
		panelTitulo.setBackground(Color.BLACK);

		setSize(1206, 579);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		panelTitulo.add(labelTitulo);
		
		botonParaEmpezar = new JButton("Empezar!!");
		botonParaEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mapa.getInstancia().setNivelActual(nivelAElegir.getSelectedIndex()+1);
				empezarAJugar();
			}
		});
		panelTitulo.add(botonParaEmpezar);
		//String[] items = {"1","2","3","4","5","6","7","8","9","10"};
		//nivelAElegir = new JComboBox<String>(items);
		
		panelTitulo.add(nivelAElegir);
		
		panelTitulo.add(labelTitulo2);
		
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
		
		/*panelTitulo.remove(botonParaEmpezar);
		panelTitulo.remove(nivelAElegir);
		panelTitulo.remove(labelTitulo);
		panelTitulo.remo(labelTitulo2);*/
		remove(panelTitulo);
		
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
		
		setSize(1206, 579);
		add(panelTitulo);
		
		//repaint();
		//setVisible(false);
	}
	
}

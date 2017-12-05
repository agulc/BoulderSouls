package com.boulderdash.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.boulderdash.audio.Audio;
import com.boulderdash.principal.CoordinadorDeEventos;
import com.boulderdash.principal.Mapa;

@SuppressWarnings("serial")
/**
 * Clase utilizada para crear el panel del titulo
 */
public class GuiTitulo extends JPanel{

	public GuiTitulo()
	{
		super();
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);
		
		JLabel labelTitulo = new JLabel(new ImageIcon("./Texturas/Titulo.png"));
		JLabel labelTitulo2 = new JLabel(new ImageIcon("./Texturas/TituloBonfire.gif"));
		
		add(labelTitulo, BorderLayout.PAGE_START);
		
		
		Container container = new Container();
		container.setLayout(new FlowLayout());
		container.add(crearBotonEmpezar());
		container.add(crearBotonOpciones());
		container.add(crearBotonHighScores());
		container.add(crearBotonReglas());
		
		this.add(container, BorderLayout.PAGE_END);
		this.add(labelTitulo2, BorderLayout.CENTER);
	}
	
	/**
	 * Crea el boton de opciones, con su icono a mostrar cuando le pase por encima el cursor
	 */
	private JButton crearBotonOpciones()
	{
		JButton botonOpciones = new JButton();
		botonOpciones.setOpaque(false);
		botonOpciones.setContentAreaFilled(false);
		botonOpciones.setBorderPainted(false);
		botonOpciones.setFocusPainted(false);
		botonOpciones.setIcon(new ImageIcon("./Texturas/OpcionesInerte.png"));
		botonOpciones.setRolloverIcon(new ImageIcon("./Texturas/Opciones.png"));
		botonOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Gui.getInstancia().remove(Gui.getInstancia().getTitulo());
				System.out.println("Opciones presionado");
				Gui.getInstancia().getOpciones().menuOpciones();
			}
		});
		
		return botonOpciones;
	}
	
	/**
	 * Crea el boton de reglas, con su icono a mostrar cuando le pase por encima el cursor
	 */
	private JButton crearBotonReglas()
	{
		JButton botonReglas = new JButton();
		botonReglas.setOpaque(false);
		botonReglas.setContentAreaFilled(false);
		botonReglas.setBorderPainted(false);
		botonReglas.setFocusPainted(false);
		botonReglas.setIcon(new ImageIcon("./Texturas/ReglasInerte.png"));
		botonReglas.setRolloverIcon(new ImageIcon("./Texturas/Reglas.png"));
		botonReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gui.getInstancia().remove((Gui.getInstancia().getTitulo()));
				System.out.println("Reglas presionado");
				Gui.getInstancia().getReglas().menuReglas();
			}
		});
		
		return botonReglas;
	}
	
	/**
	 * Crea el boton de highscores, con su icono a mostrar cuando le pase por encima el cursor
	 */
	private JButton crearBotonHighScores()
	{
		JButton botonHighScores = new JButton();
		botonHighScores.setOpaque(false);
		botonHighScores.setContentAreaFilled(false);
		botonHighScores.setBorderPainted(false);
		botonHighScores.setFocusPainted(false);
		botonHighScores.setIcon(new ImageIcon("./Texturas/HighscoresInerte.png"));
		botonHighScores.setRolloverIcon(new ImageIcon("./Texturas/Highscores.png"));
		botonHighScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gui.getInstancia().remove(Gui.getInstancia().getTitulo());
				System.out.println("HighScores presionado");
				Gui.getInstancia().getMejorPuntuacion().menuHighScores();
			}
		});
		
		return botonHighScores;
	}
	
	/**
	 * Crea el boton para empezar, con su icono a mostrar cuando le pase por encima el cursor
	 */
	private JButton crearBotonEmpezar()
	{
		JButton botonParaEmpezar = new JButton();
		botonParaEmpezar.setOpaque(false);
		botonParaEmpezar.setContentAreaFilled(false);
		botonParaEmpezar.setBorderPainted(false);
		botonParaEmpezar.setFocusPainted(false);
		botonParaEmpezar.setIcon(new ImageIcon("./Texturas/botonNewGameInerte.png"));
		botonParaEmpezar.setRolloverIcon(new ImageIcon("./Texturas/botonNewGameSeleccionado.gif"));
		botonParaEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remove(Gui.getInstancia().getTitulo());
				Gui.getInstancia().empezarAJugar();
			}
		});
		
		return botonParaEmpezar;
	}

	/**
	 * Metodo para volver al titulo principal, cuando se vuelve del juego
	 */
	public void volverAlTitulo()
	{
		CoordinadorDeEventos.detenerTemporizador();
		Audio.pararMusica();
		Mapa.setPuntuacionAcumulada(0);
		Gui.getInstancia().remove(Gui.getInstancia().getJuego());
		Gui.getInstancia().add(Gui.getInstancia().getTitulo());
		if (Audio.getMusicaActivada())
			Audio.musicaMenu();
		Gui.getInstancia().pack();
		Gui.getInstancia().repaint();
		CoordinadorDeEventos.detenerTemporizador();
	}
}

package com.boulderdash.interfaz;


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.boulderdash.audio.Audio;
import com.boulderdash.principal.Comportamiento;

@SuppressWarnings("serial")
/**
 * Clase que se utiliza para manejar toda la grafica en general
 */
public class Gui extends JFrame{


	private static Gui instancia = null;
	private GuiTitulo titulo;
	private GuiOpciones opciones;
	private GuiMejorPuntuacion highscores;
	private GuiReglas reglas;
	private GuiHUD hud;
	private GuiMatriz matriz;
	private GuiMuerte muerte;
	private GuiNuevaMejorPuntuacion nuevoMejorPuntuacion;
	private JPanel juego;
	
	/**
	 * Constructor de la clase, el cual llama al superconstructor de JFrame
	 */
	private Gui(){
		super("Boulder Dash");
		inicializarGui();
	}
	
	/**
	 * Metodo utilizado para modularizar la inicializacion de la interfaz grafica
	 */
	private void inicializarGui()
	{
		titulo = new GuiTitulo();
		opciones = new GuiOpciones();
		highscores = new GuiMejorPuntuacion();
		reglas = new GuiReglas();
		nuevoMejorPuntuacion = new GuiNuevaMejorPuntuacion();

		setSize(1024, 720);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.add(titulo);
		pack();
		
		setVisible(true);
	}
	
	/**
	 * Metodo que se utiliza para obtener la unica instancia de Gui, ya que el mismo es singleton
	 */
	public static Gui getInstancia(){
		if(instancia == null){
			instancia = new Gui();
		}
		return instancia;
	}

	/**
	 * Metodo utilizado para inicializar el entorno grafico del juego
	 */
	public void empezarAJugar(){
		
		this.remove(titulo);
		
		juego = new JPanel(new BorderLayout()); 
		juego.setBackground(Color.WHITE);
		Comportamiento.setRockfordMuerto(false);

		
		hud = new GuiHUD();
		matriz = new GuiMatriz();
		hud.actualizarHud ();
		
		juego.add(hud, BorderLayout.NORTH);
		juego.add(matriz, BorderLayout.SOUTH); //La matriz del juego va debajo
		
		add(juego); 		
		pack();
		repaint();
		
		
		Comportamiento.Inicializar();
		Audio.pararMusica();
		Audio.musica();
		
		matriz.requestFocus(); //Se centra en el juego para responder al key listener
	}
	
	
	public GuiTitulo getTitulo() {
		return titulo;
	}

	public void setTitulo(GuiTitulo titulo) {
		this.titulo = titulo;
	}

	public GuiOpciones getOpciones() {
		return opciones;
	}

	public void setOpciones(GuiOpciones opciones) {
		this.opciones = opciones;
	}
	
	public GuiMejorPuntuacion getMejorPuntuacion() {
		return highscores;
	}

	public void setMejorPuntuacion(GuiMejorPuntuacion highscores) {
		this.highscores = highscores;
	}

	public GuiReglas getReglas() {
		return reglas;
	}

	public void setReglas(GuiReglas reglas) {
		this.reglas = reglas;
	}

	public GuiHUD getHud() {
		return hud;
	}

	public void setHud(GuiHUD hud) {
		this.hud = hud;
	}

	public GuiMatriz getMatriz() {
		return matriz;
	}

	public void setMatriz(GuiMatriz matriz) {
		this.matriz = matriz;
	}

	public GuiMuerte getMuerte() {
		return muerte;
	}

	public void setMuerte(GuiMuerte muerte) {
		this.muerte = muerte;
	}

	public JPanel getJuego() {
		return juego;
	}

	public void setJuego(JPanel juego) {
		this.juego = juego;
	}

	public GuiNuevaMejorPuntuacion getNuevaMejorPuntuacion() {
		return nuevoMejorPuntuacion;
	}

	public void setNuevaMejorPuntuacion(GuiNuevaMejorPuntuacion nuevoMejorPuntuacion) {
		this.nuevoMejorPuntuacion = nuevoMejorPuntuacion;
	}	
}

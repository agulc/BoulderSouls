package com.boulderdash.interfaz;

import java.awt.*;
import javax.swing.*;

import com.boulderdash.audio.Audio;
import com.boulderdash.principal.Comportamiento;

@SuppressWarnings("serial")
public class Gui extends JFrame{


	private static Gui instancia = null;
	
	private GuiTitulo titulo;
	private GuiOpciones opciones;
	private GuiHighscores highscores;
	private GuiReglas reglas;
	private GuiHUD hud;
	private GuiMatriz matriz;
	private GuiMuerte muerte;
	
	private JPanel juego;
	
	private Gui(){
		super("Boulder Dash");
		inicializarGui();
	}
	
	private void inicializarGui()
	{
		//Se construye un GuiTitulo
		//Se construye un GuiOpciones
		//Se construye un GuiHighscores
		//Se construye un GuiReglas

		setSize(1024, 720);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.add(titulo);
		pack();
		
		setVisible(true);
	}
	
	public static Gui getInstancia(){
		if(instancia == null){
			instancia = new Gui();
		}
		return instancia;
	}

	
	public void empezarAJugar(){
		
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
	
	
	public void volverDeOpciones()
	{
		add(titulo);
		pack();
		repaint();
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

	public GuiHighscores getHighscores() {
		return highscores;
	}

	public void setHighscores(GuiHighscores highscores) {
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

	
	
	
}

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
	public static JPanel panelTitulo = new JPanel(new BorderLayout());
	public static JPanel panelOpciones = new JPanel(new BorderLayout());
	public static JPanel panelHighScores = new JPanel(new BorderLayout());
	public static JPanel panelJuego;//Contiene a la matriz del juego y su HUD correspondiente
	public static JPanel panelMatriz;
	public static JPanel panelHud;
	
	private static Gui instancia = null;
	
	private static MiTeclaEscucha teclaEscucha = new MiTeclaEscucha();
	

	
	private Gui(){
		super("Boulder Dash");
		inicializarGui();
	}
	
	private void inicializarGui(){

		JLabel labelTitulo = new JLabel(new ImageIcon("./Texturas/Titulo.png"));
		JLabel labelTitulo2 = new JLabel(new ImageIcon("./Texturas/TituloBonfire.gif"));
		JButton botonParaEmpezar = new JButton();
		JButton botonOpciones = new JButton();
		JButton botonHighScores = new JButton();
		JCheckBox checkBoxMuerte = new JCheckBox();
		JCheckBox musicaActivada = new JCheckBox();
		String[] items = {"Nivel 1","Nivel 2","Nivel 3","Nivel 4","Nivel 5","Nivel 6","Nivel 7","Nivel 8","Nivel 9","Nivel 10"};
		final JComboBox<String> nivelAElegir = new JComboBox<String>(items);
		
		
		panelTitulo.setBackground(Color.BLACK);

	    setSize(1024, 720);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		panelTitulo.add(labelTitulo, BorderLayout.PAGE_START);

		botonParaEmpezar.setOpaque(false);
		botonParaEmpezar.setContentAreaFilled(false);
		botonParaEmpezar.setBorderPainted(false);
		botonParaEmpezar.setFocusPainted(false);
		botonParaEmpezar.setIcon(new ImageIcon("./Texturas/botonNewGameInerte.png"));
		botonParaEmpezar.setRolloverIcon(new ImageIcon("./Texturas/botonNewGameSeleccionado.gif"));
		botonParaEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mapa.getInstancia().setNivelActual(nivelAElegir.getSelectedIndex()+1);
				remove(panelTitulo);
				empezarAJugar();
			}
		});
		
		JLabel labelOpciones = new JLabel(new ImageIcon("./Texturas/OpcionesWolf.gif"));
		botonOpciones.setOpaque(false);
		botonOpciones.setContentAreaFilled(false);
		botonOpciones.setBorderPainted(false);
		botonOpciones.setFocusPainted(false);
		botonOpciones.setIcon(new ImageIcon("./Texturas/OpcionesInerte.png"));
		botonOpciones.setRolloverIcon(new ImageIcon("./Texturas/Opciones.png"));
		botonOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remove(panelTitulo);
				System.out.println("Opciones presionado");
				menuOpciones();
			}
		});
		
		JLabel labelHighScores = new JLabel(new ImageIcon("./Texturas/PraiseTheSun.gif"));
		botonHighScores.setOpaque(false);
		botonHighScores.setContentAreaFilled(false);
		botonHighScores.setBorderPainted(false);
		botonHighScores.setFocusPainted(false);
		botonHighScores.setIcon(new ImageIcon("./Texturas/HighscoresInerte.png"));
		botonHighScores.setRolloverIcon(new ImageIcon("./Texturas/Highscores.png"));
		botonHighScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remove(panelTitulo);
				System.out.println("HighScores presionado");
				menuHighScores();
			}
		});
		
		JButton botonRegresar = new JButton();
		botonRegresar.setOpaque(false);
		botonRegresar.setContentAreaFilled(false);
		botonRegresar.setBorderPainted(false);
		botonRegresar.setFocusPainted(false);
		botonRegresar.setIcon(new ImageIcon("./Texturas/BackInerte.png"));
		botonRegresar.setRolloverIcon(new ImageIcon("./Texturas/Back.png"));
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 remove(panelOpciones);
				 volverDeOpciones();
				 System.out.println("Regresar presionado");
			}
		});
		
		JButton botonRegresar2 = new JButton();
		botonRegresar2.setOpaque(false);
		botonRegresar2.setContentAreaFilled(false);
		botonRegresar2.setBorderPainted(false);
		botonRegresar2.setFocusPainted(false);
		botonRegresar2.setIcon(new ImageIcon("./Texturas/BackInerte.png"));
		botonRegresar2.setRolloverIcon(new ImageIcon("./Texturas/Back.png"));
		botonRegresar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 remove(panelHighScores);
				 volverDeOpciones();
				 System.out.println("Regresar presionado");
			}
		});
		
		
		
		checkBoxMuerte.addActionListener(new ActionListener() { //Determina si la muerte alternativa estara activada
			public void actionPerformed(ActionEvent arg0) {
				
				Comportamiento.setMuerteExtra(!Comportamiento.getMuerteExtra());
			}
		});
		checkBoxMuerte.setText("Muerte alternativa");
		
		musicaActivada.addActionListener(new ActionListener() { //Determina si la musica estara activada
			public void actionPerformed(ActionEvent arg0) {
				
				Audio.setMusicaActivada(!Audio.getMusicaActivada());
				if (!Audio.getMusicaActivada())
				{
					Audio.pararMusica(); //Para la musica del menu
				}
				else
				{
					Audio.musicaMenu();
				}
			}
		});
		musicaActivada.setText("Musica");
		musicaActivada.setSelected(true);
		
		
		panelTitulo.add(labelTitulo2, BorderLayout.CENTER);
		
		Container container = new Container();
		container.setLayout(new FlowLayout());
		container.add(botonParaEmpezar);
		container.add(botonOpciones);
		container.add(botonHighScores);
		panelTitulo.add(container, BorderLayout.PAGE_END);
		
		Container containerOpciones = new Container();
		Container containerOpciones2 = new Container();
		Container containerOpciones3 = new Container();
		containerOpciones.setLayout(new BorderLayout());
		containerOpciones2.setLayout(new FlowLayout());
		containerOpciones3.setLayout(new BorderLayout());
		containerOpciones2.add(nivelAElegir);
		containerOpciones2.add(checkBoxMuerte);
		containerOpciones2.add(musicaActivada);
        containerOpciones3.add(labelOpciones);
        containerOpciones.add(containerOpciones2, BorderLayout.NORTH);
        containerOpciones.add(containerOpciones3, BorderLayout.CENTER);
		containerOpciones.add(botonRegresar, BorderLayout.SOUTH);
		panelOpciones.setBackground(Color.BLACK);
		panelOpciones.add(containerOpciones, BorderLayout.CENTER);
		
		Container containerHighScores = new Container();
		Container containerHighScores2 = new Container();
		containerHighScores.setLayout(new BorderLayout()); //Donde va la lista de highscores
		containerHighScores2.setLayout(new BorderLayout());
		containerHighScores2.add(labelHighScores, BorderLayout.CENTER);
		containerHighScores2.add(botonRegresar2, BorderLayout.SOUTH);
		panelHighScores.setBackground(Color.BLACK);
		panelHighScores.add(containerHighScores);
		panelHighScores.add(containerHighScores2);
		
		
		this.add(panelTitulo);
		pack();
		
		setVisible(true);
		
		
	}

	private void menuOpciones()
	{
		this.add(panelOpciones);
		this.setSize(panelTitulo.getSize());
		repaint();
	}
	
	private void menuHighScores()
	{
		this.add(panelHighScores);
		this.setSize(panelTitulo.getSize());
		repaint();
	}
	
	
	
	public static Gui getInstancia(){
		if(instancia == null){
			instancia = new Gui();
		}
		return instancia;
	}

	private void empezarAJugar(){
		
		panelJuego = new JPanel(new BorderLayout()); 
		panelJuego.setBackground(Color.WHITE);
		Comportamiento.setRockfordMuerto(false);
		
		//HUD
		panelHud = new JPanel(new GridLayout());
		panelHud.setBackground(Color.BLACK);
		Font fuente = new Font("Serif", Font.BOLD, 20);
		JLabel vidas = new JLabel(new ImageIcon("./Texturas/heart.png"));
		vidas.setText("Vidas: ");
		vidas.setFont(fuente);
		vidas.setForeground(Color.WHITE);
		
		JLabel diamantesRestantes = new JLabel(new ImageIcon("./Texturas/diamond.gif"));
		
		diamantesRestantes.setText("Diamantes Restantes: ");
		diamantesRestantes.setFont(fuente);
		diamantesRestantes.setForeground(Color.WHITE);
		panelHud.add(vidas);
		panelHud.add(diamantesRestantes);
		
		//fin HUD

		
		panelMatriz = new JPanel(new GridLayout(22,40,0,0));
		panelMatriz.addKeyListener(teclaEscucha);
		panelMatriz.setBackground(Color.black);
		
		//setLayout(new BorderLayout());
		Mapa.getInstancia().construirMapa();
		Posicion pos = new Posicion();
		for (int i = 0; i < 880; i++) 
		{
			pos.setX(i%40);
			pos.setY(i/40);
			labels[(i)] = new JLabel(Mapa.getInstancia().getPersonaje(pos).getIcono());
			panelMatriz.add(labels[(i)], (i));
		}
		
		actualizarHud ();
		panelJuego.add(panelHud, BorderLayout.NORTH);
		panelJuego.add(panelMatriz, BorderLayout.SOUTH); //La matriz del juego va debajo
		
		
		add(panelJuego); 		
		
		pack();
		repaint();
		Comportamiento.Inicializar();
		Audio.pararMusica();
		Audio.musica();
		
		panelMatriz.requestFocus(); //Se centra en el juego para responder al key listener
	}
	
	public void actualizarImagenes(Posicion pos) 
	{
		actualizarHud ();
		int i = pos.getY()*40 + pos.getX();
		labels[(i)] = new JLabel(Mapa.getInstancia().getPersonaje(pos).getIcono());
		panelMatriz.remove(i);
		panelMatriz.add(labels[(i)], (i));
		pack();
		panelMatriz.repaint();
	}
	
	public void reconstruir() {
		  Posicion pos = new Posicion();
		  for (int i = 0; i < 880; i++) 
		  {
			  pos.setX(i%40);
			  pos.setY(i/40);
			  labels[(i)] = new JLabel(Mapa.getInstancia().getPersonaje(pos).getIcono());
			  panelMatriz.remove(i);
			  panelMatriz.add(labels[(i)], (i));
		  }
	}
	
	
	public void hasMuerto()
	{
		panelMatriz.removeKeyListener(teclaEscucha);
		remove(panelJuego);
		
		ImageIcon image = new ImageIcon("./Texturas/You Died.gif");
		JLabel etiqueta = new JLabel(image);

		Panel panelMuerte = new Panel();
		panelMuerte.setLayout(new BorderLayout());
		panelMuerte.setBackground(Color.BLACK);
		
		panelMuerte.add(etiqueta);
		add(panelMuerte);
		
		pack();
		setSize(panelJuego.getSize());
		repaint();
		
		Audio.hasMuerto();
		try {
			Thread.sleep(2850);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		remove(panelMuerte);
		
		this.reconstruir(); //Reconstruye el panel del mapa
		
		volverAlTitulo();
	}
	
	public void volverAlTitulo()
	{
		CoordinadorDeEventos.detenerTemporizador();
		Audio.pararMusica();
		remove(panelJuego);
		add(panelTitulo);
		if (Audio.getMusicaActivada())
			Audio.musicaMenu();
		pack();
		repaint();
	}
	
	public void volverDeOpciones()
	{
		add(panelTitulo);
		pack();
		repaint();
	}
	
	public void actualizarHud ()
	{
		
		((JLabel)(panelHud.getComponent(0))).setText("Vidas: " + Mapa.getInstancia().getVidas()); //Actualiza Las Vidas
		if (Mapa.getInstancia().getVidas() == 0 && Comportamiento.getMuerteExtra())
			((JLabel)(panelHud.getComponent(0))).setText("Mou shindeiru");
		
		((JLabel)(panelHud.getComponent(1))).setText("Diamantes restantes: " + Mapa.getDiamantesRestantes()); //Actualiza Los diamantes restantes
		
		
	}
	
}

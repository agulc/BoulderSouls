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
		JCheckBox checkBoxMuerte = new JCheckBox();
		JCheckBox musicaActivada = new JCheckBox();
		String[] items = {"1","2","3","4","5","6","7","8","9","10"};
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
		container.add(nivelAElegir);
		container.add(checkBoxMuerte);
		container.add(musicaActivada);
		
		panelTitulo.add(container, BorderLayout.PAGE_END);
		
		
		this.add(panelTitulo);
		pack();
		
		setVisible(true);
		
		
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
		
		volverAlTitulo();
	}
	
	public void volverAlTitulo()
	{
		Audio.pararMusica();
		remove(panelJuego);
		add(panelTitulo);
		if (Audio.getMusicaActivada())
			Audio.musicaMenu();
		
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

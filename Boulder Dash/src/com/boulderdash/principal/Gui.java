package com.boulderdash.principal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.table.TableColumn;

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
	public static JPanel panelReglas = new JPanel(new BorderLayout());
	public static JPanel panelJuego;//Contiene a la matriz del juego y su HUD correspondiente
	public static JPanel panelMatriz;
	public static JPanel panelHud;
	Font fuente = null;	   
	InputStream myStream = null;
	{
	try {
		myStream = new BufferedInputStream(new FileInputStream("src/fuentes/OptimusPrinceps.ttf"));
		fuente = Font.createFont(Font.TRUETYPE_FONT, myStream );
        fuente = fuente.deriveFont(Font.BOLD, 20);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FontFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
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
		
		inicializarOpciones();
		inicializarHighScores();
		inicializarReglas();
		
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
				remove(panelTitulo);
				empezarAJugar();
			}
		});
		

		JButton botonOpciones = new JButton();
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
		
		JButton botonHighScores = new JButton();
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
		
		JButton botonReglas = new JButton();
		botonReglas.setOpaque(false);
		botonReglas.setContentAreaFilled(false);
		botonReglas.setBorderPainted(false);
		botonReglas.setFocusPainted(false);
		botonReglas.setIcon(new ImageIcon("./Texturas/ReglasInerte.png"));
		botonReglas.setRolloverIcon(new ImageIcon("./Texturas/Reglas.png"));
		botonReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remove(panelTitulo);
				System.out.println("Reglas presionado");
				menuReglas();
			}
		});
		
		Container container = new Container();
		container.setLayout(new FlowLayout());
		container.add(botonParaEmpezar);
		container.add(botonOpciones);
		container.add(botonHighScores);
		container.add(botonReglas);
		
		panelTitulo.add(container, BorderLayout.PAGE_END);
		
		panelTitulo.add(labelTitulo2, BorderLayout.CENTER);
		this.add(panelTitulo);
		pack();
		
		setVisible(true);
		
		
	}
	

	private void inicializarReglas()
	{
		JLabel label = new JLabel(new ImageIcon("./Texturas/sid.gif"));
		
		JButton botonRegresar = new JButton();
		botonRegresar.setOpaque(false);
		botonRegresar.setContentAreaFilled(false);
		botonRegresar.setBorderPainted(false);
		botonRegresar.setFocusPainted(false);
		botonRegresar.setIcon(new ImageIcon("./Texturas/BackInerte.png"));
		botonRegresar.setRolloverIcon(new ImageIcon("./Texturas/Back.png"));
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 remove(panelReglas);
				 volverDeOpciones();
				 System.out.println("Regresar presionado");
			}
		});
		


		fuente = fuente.deriveFont(Font.BOLD, 21);
		JLabel regla1 = new JLabel(new ImageIcon("./Texturas/Rockford.gif"));
		regla1.setText("Controlas a Rockford");
		regla1.setFont(fuente);
		regla1.setForeground(Color.WHITE);
		
		JLabel regla2 = new JLabel(new ImageIcon("./Texturas/Diamond.gif"));
		regla2.setText("Debes juntar un numero minimo de diamantes");
		regla2.setFont(fuente);
		regla2.setForeground(Color.WHITE);
		
		JLabel regla3 = new JLabel(new ImageIcon("./Texturas/ExitClosed.png"));
		regla3.setText("Esta es la hoguera");
		regla3.setFont(fuente);
		regla3.setForeground(Color.WHITE);
		
		JLabel regla4 = new JLabel(new ImageIcon("./Texturas/Exit.gif"));
		regla4.setText("Cuando juntes los diamantes necesarios, la hoguera se encendera y deberas dirigirte a ella");
		regla4.setFont(fuente);
		regla4.setForeground(Color.WHITE);
		
		JLabel regla5 = new JLabel(new ImageIcon("./Texturas/boulder.gif"));
		regla5.setText("Evita ser golpeado por las piedras, aunque puedes empujarlas, y usarlas a tu favor");
		regla5.setFont(fuente);
		regla5.setForeground(Color.WHITE);
		
		JLabel regla6 = new JLabel(new ImageIcon("./Texturas/dirt.gif"));
		regla6.setText("Puedes moverte libremente a traves de la tierra");
		regla6.setFont(fuente);
		regla6.setForeground(Color.WHITE);
		
		JLabel regla7 = new JLabel(new ImageIcon("./Texturas/firefly.gif"));
		regla7.setText("Las luciernagas explotan cuando las tienes cerca");
		regla7.setFont(fuente);
		regla7.setForeground(Color.WHITE);
		
		JLabel regla8 = new JLabel(new ImageIcon("./Texturas/butterfly.gif"));
		regla8.setText("Las mariposas tambien explotan, pero puedes matarlas con piedras para conseguir diamantes");
		regla8.setFont(fuente);
		regla8.setForeground(Color.WHITE);
		
		JLabel regla9 = new JLabel(new ImageIcon("./Texturas/magic.gif"));
		regla9.setText("Puedes romper las paredes claras con explosiones");
		regla9.setFont(fuente);
		regla9.setForeground(Color.WHITE);
		
		JLabel regla10 = new JLabel(new ImageIcon("./Texturas/steel.gif"));
		regla10.setText("Las paredes oscuras son indestructibles");
		regla10.setFont(fuente);
		regla10.setForeground(Color.WHITE);
		
		JLabel regla11 = new JLabel(new ImageIcon("./Texturas/heart.png"));
		regla11.setText("Tienes 4 vidas por nivel");
		regla11.setFont(fuente);
		regla11.setForeground(Color.WHITE);
		
		JLabel regla12 = new JLabel(new ImageIcon("./Texturas/clock.gif"));
		regla12.setText("Hay un limite de tiempo para completar los niveles");
		regla12.setFont(fuente);
		regla12.setForeground(Color.WHITE);
		
		JLabel regla13 = new JLabel(new ImageIcon("./Texturas/Amoeba.gif"));
		regla13.setText("Las amebas estan programadas pero no aparecen en ningun nivel (^-^)");
		regla13.setFont(fuente);
		regla13.setForeground(Color.WHITE);
		
		
		
		
		Container containerReglas = new Container();
		Container container = new Container();
		Container container2 = new Container();
		
		containerReglas.setLayout(new GridLayout(0,1));
		containerReglas.add(regla1);
		containerReglas.add(regla2);
		containerReglas.add(regla3);
		containerReglas.add(regla4);
		containerReglas.add(regla5);
		containerReglas.add(regla6);
		containerReglas.add(regla7);
		containerReglas.add(regla8);
		containerReglas.add(regla9);
		containerReglas.add(regla10);
		containerReglas.add(regla11);
		containerReglas.add(regla12);
		containerReglas.add(regla13);
		
		container.setLayout(new BorderLayout()); //Donde va la lista de reglas
		container.add(label, BorderLayout.NORTH);
		container.add(containerReglas, BorderLayout.SOUTH);
		
		container2.setLayout(new BorderLayout());
		
		container2.add(botonRegresar, BorderLayout.SOUTH);
		panelReglas.setBackground(Color.BLACK);
		panelReglas.add(container);
		panelReglas.add(container2, BorderLayout.SOUTH);
	}
	
	private void inicializarHighScores()
	{
		JLabel labelHighScores = new JLabel(new ImageIcon("./Texturas/PraiseTheSun.gif"));
		
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
		

		String[] columnas = {"", "", "", "", "", ""};
		String[][] filas = {{"", "Posicion", "Nombre","Puntuacion", "Tiempo", ""}
							, {"", "1", "Juan", "1500","4000",""}
							, {"", "2", "Pedro", "1300","4500",""}
							, {"", "3", "Rockford", "950","4500",""}
							, {"", "", "", "","",""}};
		
		JTable tabla = new JTable(filas,columnas) 
		{
			public boolean isCellEditable(int data,int columns)
			{
				return false;
			}
		};
		fuente = fuente.deriveFont(Font.BOLD, 20);
		tabla.setFont(fuente);
		tabla.setForeground(Color.WHITE);
		tabla.setBackground(Color.BLACK);
		tabla.setGridColor(Color.BLACK);
		tabla.setFocusable(false);
		tabla.setRowSelectionAllowed(false);
		tabla.setFillsViewportHeight(true);
		tabla.setRowHeight(30);
		
		
		panelHighScores.setBackground(Color.BLACK);
		panelHighScores.add(labelHighScores, BorderLayout.NORTH);
		panelHighScores.add(tabla, BorderLayout.CENTER);
		panelHighScores.add(botonRegresar2, BorderLayout.SOUTH);
		
	}

	private void inicializarOpciones()
	{
		
		JCheckBox checkBoxMuerte = new JCheckBox();
		JCheckBox checkBoxpiedrasConInercia = new JCheckBox();
		JCheckBox musicaActivada = new JCheckBox();
		String[] items = {"Nivel 1","Nivel 2","Nivel 3","Nivel 4","Nivel 5","Nivel 6","Nivel 7","Nivel 8","Nivel 9","Nivel 10"};
		final JComboBox<String> nivelAElegir = new JComboBox<String>(items);
		nivelAElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					Mapa.getInstancia().setNivelActual(nivelAElegir.getSelectedIndex() + 1);
					System.out.println("Nivel cambiado");
			}
		});
		
		JLabel labelOpciones = new JLabel(new ImageIcon("./Texturas/estus.gif"));
		
		
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
		

		checkBoxMuerte.addActionListener(new ActionListener() { //Determina si la muerte alternativa estara activada
			public void actionPerformed(ActionEvent arg0) {
				
				Comportamiento.setMuerteExtra(!Comportamiento.getMuerteExtra());
			}
		});
		checkBoxMuerte.setText("Muerte alternativa");
		
		checkBoxpiedrasConInercia.addActionListener(new ActionListener() { //Determina si la muerte alternativa estara activada
			public void actionPerformed(ActionEvent arg0) {
				
				Comportamiento.setPiedrasConInercia(!Comportamiento.getPiedrasConInercia());
			}
		});
		checkBoxpiedrasConInercia.setText("Piedras con inercia");
		
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
		
		Container containerOpciones = new Container();
		Container containerOpciones2 = new Container();
		Container containerOpciones3 = new Container();
		containerOpciones.setLayout(new BorderLayout());
		containerOpciones2.setLayout(new FlowLayout());
		containerOpciones3.setLayout(new BorderLayout());
		containerOpciones2.add(nivelAElegir);
		containerOpciones2.add(checkBoxMuerte);
		containerOpciones2.add(checkBoxpiedrasConInercia);
		containerOpciones2.add(musicaActivada);
        containerOpciones3.add(labelOpciones);
        containerOpciones.add(containerOpciones2, BorderLayout.NORTH);
        containerOpciones.add(containerOpciones3, BorderLayout.CENTER);
		containerOpciones.add(botonRegresar, BorderLayout.SOUTH);
		panelOpciones.setBackground(Color.BLACK);
		panelOpciones.add(containerOpciones, BorderLayout.CENTER);
	}
	

	private void menuOpciones()
	{
		this.add(panelOpciones);
		this.setSize(panelTitulo.getSize());
		repaint();
	}
	
	private void menuReglas()
	{
		this.add(panelReglas);
		this.setSize( (int)panelTitulo.getSize().getWidth(), 620);
		
		repaint();
	}
	
	private void menuHighScores()
	{
		this.add(panelHighScores);
		pack();
		this.setSize(panelTitulo.getSize().width, panelHighScores.getHeight());
		//this.setSize(panelTitulo.getSize());
		repaint();
	}
	
	
	
	public static Gui getInstancia(){
		if(instancia == null){
			instancia = new Gui();
		}
		return instancia;
	}

	private void inicializarHUD()
	{
		panelHud = new JPanel(new GridLayout());
		panelHud.setBackground(Color.BLACK);

        
        //Font fuente = new Font("Serif", Font.BOLD, 20);
		fuente = fuente.deriveFont(Font.BOLD, 18);
	    
		JLabel vidas = new JLabel(new ImageIcon("./Texturas/heart.png"));
		vidas.setText("Vidas: ");
		vidas.setFont(fuente);
		vidas.setForeground(Color.WHITE);
		
		JLabel diamantesRestantes = new JLabel(new ImageIcon("./Texturas/diamond.gif"));
		diamantesRestantes.setText("Diamantes: ");
		diamantesRestantes.setFont(fuente);
		diamantesRestantes.setForeground(Color.WHITE);
		
		JLabel tiempoRestante = new JLabel(new ImageIcon("./Texturas/clock.gif"));
		tiempoRestante.setText("Timer: 120");
		tiempoRestante.setFont(fuente);
		tiempoRestante.setForeground(Color.WHITE);
		
		JLabel puntuacion = new JLabel();
		puntuacion.setText("Puntos: 0");
		puntuacion.setFont(fuente);
		puntuacion.setForeground(Color.WHITE);
		
		panelHud.add(vidas);
		panelHud.add(diamantesRestantes);
		panelHud.add(tiempoRestante);
		panelHud.add(puntuacion);
	}
	
	private void inicializarPanelMatriz()
	{
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
	}
	
	private void empezarAJugar(){
		
		panelJuego = new JPanel(new BorderLayout()); 
		panelJuego.setBackground(Color.WHITE);
		Comportamiento.setRockfordMuerto(false);
		
		inicializarHUD();
		inicializarPanelMatriz();

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
		
		((JLabel)(panelHud.getComponent(1))).setText("Diamantes: " + Mapa.getDiamantesRestantes()); //Actualiza Los diamantes restantes
		
		((JLabel)(panelHud.getComponent(2))).setText(((Integer)(Mapa.getInstancia().getTiempoRestante())).toString());
		
		Integer puntuacionTotal = (Mapa.getInstancia().getPuntuacionNivel() + Mapa.getPuntuacionAcumulada());
		((JLabel)(panelHud.getComponent(3))).setText("Puntos: " + puntuacionTotal.toString());
	}
	
}

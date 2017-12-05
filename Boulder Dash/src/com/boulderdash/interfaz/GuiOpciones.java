package com.boulderdash.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.boulderdash.audio.Audio;
import com.boulderdash.entradasalida.MejorPuntuacion;
import com.boulderdash.entradasalida.OpcionesES;
import com.boulderdash.fuente.MiFuente;
import com.boulderdash.principal.Comportamiento;
import com.boulderdash.principal.Mapa;

@SuppressWarnings("serial")
/**
 * Clase utilizada para crear el panel de opciones
 */
public class GuiOpciones extends JPanel{

	public GuiOpciones()
	{
		this.setLayout(new BorderLayout());
		JLabel labelOpciones = new JLabel(new ImageIcon("./Texturas/estus.gif"));
		
		Container containerOpciones = new Container();
		Container containerOpciones2 = new Container();
		Container containerOpciones3 = new Container();
		
		containerOpciones.setLayout(new BorderLayout());
		containerOpciones2.setLayout(new FlowLayout());
		containerOpciones3.setLayout(new BorderLayout());
		containerOpciones2.add(crearNivelAElegir());
		containerOpciones2.add(crearCantidadAMostrar());
		containerOpciones2.add(crearBoxMusicaActivada());
		containerOpciones2.add(crearBoxMuerte());
		containerOpciones2.add(crearBoxPiedrasConInercia());
		
        containerOpciones3.add(labelOpciones);
        containerOpciones.add(containerOpciones2, BorderLayout.NORTH);
        containerOpciones.add(containerOpciones3, BorderLayout.CENTER);
		containerOpciones.add(crearBotonRegresar(), BorderLayout.SOUTH);
		this.setBackground(Color.BLACK);
		
		this.add(containerOpciones, BorderLayout.CENTER);
	
	}
	
	/**
	 * Crea el check box para ver si esta activada o no la muerte alternativa en el juego
	 */
	private JCheckBox crearBoxMuerte()
	{
		JCheckBox checkBoxMuerte = new JCheckBox();
		checkBoxMuerte.setFont(MiFuente.getFuente(18));
		checkBoxMuerte.setBackground(Color.BLACK);
		checkBoxMuerte.setForeground(Color.WHITE);
		checkBoxMuerte.setBorderPainted(false);
		checkBoxMuerte.setIcon(new ImageIcon("./Texturas/boxOff.png"));
		checkBoxMuerte.setSelectedIcon(new ImageIcon("./Texturas/boxOn.png"));
		checkBoxMuerte.setDisabledIcon(new ImageIcon("./Texturas/boxOff.png"));
		checkBoxMuerte.setRolloverIcon(new ImageIcon("./Texturas/boxOffoff.png"));
		checkBoxMuerte.setRolloverSelectedIcon(new ImageIcon("./Texturas/boxOnon.png"));
	
		checkBoxMuerte.addActionListener(new ActionListener() { //Determina si la muerte alternativa estara activada
			public void actionPerformed(ActionEvent arg0) {
				
				Comportamiento.setMuerteExtra(!Comportamiento.getMuerteExtra());
				OpcionesES.setMuerteExtra(Comportamiento.getMuerteExtra());
			}
		});
		checkBoxMuerte.setText("Muerte alternativa");
		
		checkBoxMuerte.setSelected(Comportamiento.getMuerteExtra());
		
		return checkBoxMuerte;
	}
	
	/**
	 * Crea el check box para ver si estan activadas o no las piedras con inercia en el juego
	 */
	private JCheckBox crearBoxPiedrasConInercia()
	{
		JCheckBox checkBoxpiedrasConInercia = new JCheckBox();
	    checkBoxpiedrasConInercia.setFont(MiFuente.getFuente(18));
	    checkBoxpiedrasConInercia.setBackground(Color.BLACK);
	    checkBoxpiedrasConInercia.setForeground(Color.WHITE);
	    checkBoxpiedrasConInercia.setBorderPainted(false);
	    checkBoxpiedrasConInercia.setIcon(new ImageIcon("./Texturas/boxOff.png"));
	    checkBoxpiedrasConInercia.setSelectedIcon(new ImageIcon("./Texturas/boxOn.png"));
	    checkBoxpiedrasConInercia.setDisabledIcon(new ImageIcon("./Texturas/boxOff.png"));
	    checkBoxpiedrasConInercia.setRolloverIcon(new ImageIcon("./Texturas/boxOffoff.png"));
	    checkBoxpiedrasConInercia.setRolloverSelectedIcon(new ImageIcon("./Texturas/boxOnon.png"));

	    checkBoxpiedrasConInercia.addActionListener(new ActionListener() { //Determina si la muerte alternativa estara activada
			public void actionPerformed(ActionEvent arg0) {
				
				Comportamiento.setPiedrasConInercia(!Comportamiento.getPiedrasConInercia());
				OpcionesES.setPiedrasConInercia(Comportamiento.getPiedrasConInercia());
			}
		});
	    checkBoxpiedrasConInercia.setText("Piedras con inercia");

	    checkBoxpiedrasConInercia.setSelected(Comportamiento.getPiedrasConInercia());
	    
	    return checkBoxpiedrasConInercia;
	}

	/**
	 * Crea el check box para ver si esta activada o no la musica en el juego
	 */
	private JCheckBox crearBoxMusicaActivada()
	{
		final JCheckBox boxMusicaActivada = new JCheckBox();
		boxMusicaActivada.setFont(MiFuente.getFuente(18));
		boxMusicaActivada.setBackground(Color.BLACK);
		boxMusicaActivada.setForeground(Color.WHITE);
		boxMusicaActivada.setBorderPainted(false);
		boxMusicaActivada.setIcon(new ImageIcon("./Texturas/boxOff.png"));
		boxMusicaActivada.setSelectedIcon(new ImageIcon("./Texturas/boxOn.png"));
		boxMusicaActivada.setDisabledIcon(new ImageIcon("./Texturas/boxOff.png"));
		boxMusicaActivada.setRolloverIcon(new ImageIcon("./Texturas/boxOffoff.png"));
		boxMusicaActivada.setRolloverSelectedIcon(new ImageIcon("./Texturas/boxOnon.png"));
		
		boxMusicaActivada.addActionListener(new ActionListener() { //Determina si la musica estara activada
			public void actionPerformed(ActionEvent arg0) {
				
				Audio.setMusicaActivada(!Audio.getMusicaActivada());
				
				if (!Audio.getMusicaActivada())
				{
					Audio.pararMusica(); //Para la musica del menu
					OpcionesES.setMusica(false);
				}
				else
				{
					Audio.musicaMenu();
					OpcionesES.setMusica(true);
				}
				
			}
		});
		boxMusicaActivada.setText("Musica");

		boxMusicaActivada.setSelected(Audio.getMusicaActivada());
		
		return boxMusicaActivada;
	}
	
	/**
	 * Crea una combo box con todos los niveles que se pueden elegir, del 1 al 10
	 */
	private JComboBox<String> crearNivelAElegir()
	{
		String[] items = {"Nivel 1","Nivel 2","Nivel 3","Nivel 4","Nivel 5","Nivel 6","Nivel 7","Nivel 8","Nivel 9","Nivel 10"};
		final JComboBox<String> nivelAElegir = new JComboBox<String>(items);
		nivelAElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Mapa.getInstancia().setNivelActual(nivelAElegir.getSelectedIndex() + 1);
				OpcionesES.setNivel(nivelAElegir.getSelectedIndex() + 1);
				System.out.println("Nivel cambiado");
			}
		});
		nivelAElegir.setFont(MiFuente.getFuente(18));
		nivelAElegir.setBackground(Color.BLACK);
		nivelAElegir.setForeground(Color.WHITE);
		nivelAElegir.setSelectedIndex(OpcionesES.getNivel() - 1);
		
		return nivelAElegir;
	}
	
	/**
	 * Crea una combo box con la cantidad de puntajes a mostrar: 5, 10, 15 o 20
	 */
	private JComboBox<String> crearCantidadAMostrar()
	{
		String[] items = {"5 Elementos","10 Elementos","15 Elementos","20 Elementos"};
		final JComboBox<String> cantidadAMostrar = new JComboBox<String>(items);
		cantidadAMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MejorPuntuacion.setCantidadAMostrar((cantidadAMostrar.getSelectedIndex() + 1) * 5);
				OpcionesES.setElementosAMostrar((cantidadAMostrar.getSelectedIndex() + 1) * 5);
			}
		});
		cantidadAMostrar.setFont(MiFuente.getFuente(18));
		cantidadAMostrar.setBackground(Color.BLACK);
		cantidadAMostrar.setForeground(Color.WHITE);
		
		cantidadAMostrar.setSelectedIndex(OpcionesES.getElementosAMostrar() / 5 - 1);
		
		return cantidadAMostrar;
	}
	
	/**
	 * Crea el boton para regresar al menu principal
	 */
	private JButton crearBotonRegresar()
	{
		JButton botonRegresar = new JButton();
		botonRegresar.setOpaque(false);
		botonRegresar.setContentAreaFilled(false);
		botonRegresar.setBorderPainted(false);
		botonRegresar.setFocusPainted(false);
		botonRegresar.setIcon(new ImageIcon("./Texturas/BackInerte.png"));
		botonRegresar.setRolloverIcon(new ImageIcon("./Texturas/Back.png"));
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gui.getInstancia().remove(Gui.getInstancia().getOpciones());
				Gui.getInstancia().add(Gui.getInstancia().getTitulo());
				Gui.getInstancia().repaint();
				System.out.println("Regresar presionado");
			}
		});
		
		return botonRegresar;
	}
	
	/**
	 * Grafica el menu de opciones
	 */
	public void menuOpciones()
	{
		Gui.getInstancia().add(Gui.getInstancia().getOpciones());
		Gui.getInstancia().getOpciones().setSize(Gui.getInstancia().getTitulo().getSize());
		Gui.getInstancia().validate();
		this.repaint();
	}
	
	
	
}

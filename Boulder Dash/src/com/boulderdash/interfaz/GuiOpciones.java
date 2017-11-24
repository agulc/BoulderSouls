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
import com.boulderdash.principal.Comportamiento;
import com.boulderdash.principal.Mapa;

import fuentes.MiFuente;

@SuppressWarnings("serial")
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
		containerOpciones2.add(crearBoxMuerte());
		containerOpciones2.add(crearBoxPiedrasConInercia());
		containerOpciones2.add(crearBoxMusicaActivada());
		
        containerOpciones3.add(labelOpciones);
        containerOpciones.add(containerOpciones2, BorderLayout.NORTH);
        containerOpciones.add(containerOpciones3, BorderLayout.CENTER);
		containerOpciones.add(crearBotonRegresar(), BorderLayout.SOUTH);
		this.setBackground(Color.BLACK);
		this.add(containerOpciones, BorderLayout.CENTER);
	
	}
	
	
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
			}
		});
		checkBoxMuerte.setText("Muerte alternativa");
		
		return checkBoxMuerte;
	}
	
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
			}
		});
		checkBoxpiedrasConInercia.setText("Piedras con inercia");
	    
	    return checkBoxpiedrasConInercia;
	}

	private JCheckBox crearBoxMusicaActivada()
	{
		JCheckBox boxMusicaActivada = new JCheckBox();
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
				}
				else
				{
					Audio.musicaMenu();
				}
			}
		});
		boxMusicaActivada.setText("Musica");
		boxMusicaActivada.setSelected(true);
		
		return boxMusicaActivada;
	}
	
	private JComboBox<String> crearNivelAElegir()
	{
		String[] items = {"Nivel 1","Nivel 2","Nivel 3","Nivel 4","Nivel 5","Nivel 6","Nivel 7","Nivel 8","Nivel 9","Nivel 10"};
		final JComboBox<String> nivelAElegir = new JComboBox<String>(items);
		nivelAElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					Mapa.getInstancia().setNivelActual(nivelAElegir.getSelectedIndex() + 1);
					System.out.println("Nivel cambiado");
			}
		});
		nivelAElegir.setFont(MiFuente.getFuente(18));
		nivelAElegir.setBackground(Color.BLACK);
		nivelAElegir.setForeground(Color.WHITE);
		
		return nivelAElegir;
	}
	
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
				 remove(Gui.getInstancia().getOpciones());
				 Gui.getInstancia().volverDeOpciones();
				 System.out.println("Regresar presionado");
			}
		});
		
		return botonRegresar;
	}
	
	public void menuOpciones()
	{
		Gui.getInstancia().add(Gui.getInstancia().getOpciones());
		this.setSize(Gui.getInstancia().getTitulo().getSize());
		Gui.getInstancia().repaint();
	}
	
	
	
}

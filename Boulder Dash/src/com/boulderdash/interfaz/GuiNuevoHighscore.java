package com.boulderdash.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.boulderdash.audio.Audio;
import com.boulderdash.principal.Highscore;

import fuentes.MiFuente;

@SuppressWarnings("serial")
public class GuiNuevoHighscore extends JPanel{
	
	private Highscore highscore;
	private TextField text;

	public GuiNuevoHighscore()
	{
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);


		this.add(crearLabelHighscore(), BorderLayout.NORTH);
		this.add(crearContainerHighscore(), BorderLayout.CENTER);
		//this.add(crearBotonRegresar(), BorderLayout.SOUTH);
		this.add(crearBotonAceptar(), BorderLayout.SOUTH);

		
	}
	
	private JLabel crearLabelHighscore()
	{
		JLabel label = new JLabel(new ImageIcon ("./Texturas/Nuevohighscore.png"));
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setFont(MiFuente.getFuente(18));
		
		return label;
	}
	
	private Container crearContainerHighscore()
	{
		JLabel label = new JLabel();
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setFont(MiFuente.getFuente(30));
		label.setText("        Introduce un nombre: ");
		
		this.text = new TextField();
		text.setFont(MiFuente.getFuente(18));
		text.setBackground(Color.BLACK);
		text.setForeground(Color.WHITE);
		text.setColumns(30);
		
		JLabel label2 = new JLabel();
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setFont(MiFuente.getFuente(30));
		
		Container container = new Container();
		container.setLayout(new FlowLayout());
		
		container.add(label);
		container.add(text);
		container.add(label2);
		
		return container;
	}
	
	public void menuNuevoHighscore(Highscore highscore)
	{
		this.highscore = highscore;
		
		Gui.getInstancia().remove(Gui.getInstancia().getTitulo());
		Gui.getInstancia().add(Gui.getInstancia().getNuevoHighscore());
		Gui.getInstancia().getNuevoHighscore().setSize(Gui.getInstancia().getTitulo().getSize());
		
		
		Gui.getInstancia().validate();
		Gui.getInstancia().pack();
		this.repaint();
	}
	
	private JButton crearBotonAceptar()
	{
		JButton botonRegresar = new JButton();
		botonRegresar.setOpaque(false);
		botonRegresar.setContentAreaFilled(false);
		botonRegresar.setBorderPainted(false);
		botonRegresar.setFocusPainted(false);
		botonRegresar.setIcon(new ImageIcon("./Texturas/AceptarInerte.png"));
		botonRegresar.setRolloverIcon(new ImageIcon("./Texturas/Aceptar.png"));
		botonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nombre = text.getText();
				
				System.out.println("Aceptar presionado");
				
				highscore.setNombre(nombre);
				if (Highscore.nombreValido(highscore.getNombre())) 
				{
					if(!Highscore.nombreEnUso(nombre))
					{
						Highscore.introducirHighscore(highscore);
						
						Highscore.exportarHighscores();
						
						//Regresa al menu
						Audio.musicaMenu();
						Gui.getInstancia().remove(Gui.getInstancia().getNuevoHighscore());
						Gui.getInstancia().add(Gui.getInstancia().getTitulo());
						Gui.getInstancia().pack();
					}
					else
					{
						System.out.println("Nombre en uso");
					}
				}
				else
				{
					System.out.println("Nombre no valido");
				}
			}
		});
		
		return botonRegresar;
	}
	
}

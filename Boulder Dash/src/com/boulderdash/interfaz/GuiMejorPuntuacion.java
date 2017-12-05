package com.boulderdash.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.boulderdash.entradasalida.MejorPuntuacion;

@SuppressWarnings("serial")
/**
 * Clase utilizada para crear el panel de las mejores puntuaciones
 */
public class GuiMejorPuntuacion extends JPanel{
	
	private JTable tabla;
	
	public GuiMejorPuntuacion()
	{
		this.setLayout(new BorderLayout());
		MejorPuntuacion.cargarArregloMejorPuntuacion();
		
		ImageIcon image = new ImageIcon ("./Texturas/PraiseTheSun.gif");
		image.setImage(image.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
		JLabel labelHighScores = new JLabel(image);
		tabla = MejorPuntuacion.getTabla();
		
		this.add(labelHighScores, BorderLayout.NORTH);
		this.add(tabla, BorderLayout.CENTER);
		this.add(crearBotonRegresar(), BorderLayout.SOUTH);
		this.setBackground(Color.BLACK);
		
	}
	
	/**
	 * Crea el boton de regreso al menu principal
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
				Gui.getInstancia().remove(Gui.getInstancia().getMejorPuntuacion());
				Gui.getInstancia().add(Gui.getInstancia().getTitulo());
				Gui.getInstancia().pack();
				System.out.println("Regresar presionado");
			}
		});
		
		return botonRegresar;
	}
	
	/**
	 * Setea la las puntuaciones dependiendo los elementos a mostrar
	 */
	public void menuHighScores()
	{
		this.remove(tabla);
		tabla = MejorPuntuacion.getTabla();
		this.add(tabla, BorderLayout.CENTER);
		
		Gui.getInstancia().add(Gui.getInstancia().getMejorPuntuacion());
		
		Gui.getInstancia().pack();
		
		switch (MejorPuntuacion.getCantidadAMostrar())
		{
		case 5: Gui.getInstancia().setSize(Gui.getInstancia().getTitulo().getSize().width, 510);
		break;
		
		case 10: Gui.getInstancia().setSize(Gui.getInstancia().getTitulo().getSize().width, 660);
		break;
		
		case 15: Gui.getInstancia().setSize(Gui.getInstancia().getTitulo().getSize().width, 820);
		break;

		default: Gui.getInstancia().setSize(Gui.getInstancia().getTitulo().getSize().width, 960);
		break;
		}
		
		Gui.getInstancia().repaint();
	}

}

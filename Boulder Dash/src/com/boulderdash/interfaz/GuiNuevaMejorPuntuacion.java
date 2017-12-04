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
import com.boulderdash.entradasalida.MejorPuntuacion;
import com.boulderdash.principal.Mapa;

import fuentes.MiFuente;

@SuppressWarnings("serial")
/**
 * Clase utilizada para crear el panel que aparece al hacer una nueva mejor puntuacion
 */
public class GuiNuevaMejorPuntuacion extends JPanel{
	
	private MejorPuntuacion highscore;
	private TextField text;
	private JLabel mensaje;
	
	ImageIcon blank;
	ImageIcon nombreEnUso;
	ImageIcon nombreInvalido;

	/**
	 * Constructor de la clase
	 */
	public GuiNuevaMejorPuntuacion()
	{
		blank = new ImageIcon("./Texturas/Blank.png");
		nombreEnUso = new ImageIcon("./Texturas/nombreEnUso.png");
		nombreInvalido = new ImageIcon("./Texturas/nombreInvalido.png");
		
		mensaje = new JLabel();
		mensaje.setIcon(blank);
		mensaje.setHorizontalAlignment(JLabel.CENTER);
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);

		Container containerNorte = new Container();
		containerNorte.setLayout(new BorderLayout());
		containerNorte.add(crearLabelMejorPuntuacion(), BorderLayout.NORTH);
		containerNorte.add(crearContainerMejorPuntuacion(), BorderLayout.SOUTH);
		
		this.add(containerNorte, BorderLayout.NORTH);
		this.add(mensaje, BorderLayout.CENTER);
		this.add(crearBotonAceptar(), BorderLayout.SOUTH);

	}
	
	/**
	 * Metodo utilizado para crear un label, con la icono Nuevohighscore
	 */
	private JLabel crearLabelMejorPuntuacion()
	{
		JLabel label = new JLabel(new ImageIcon ("./Texturas/Nuevohighscore.png"));
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setFont(MiFuente.getFuente(18));
		
		return label;
	}
	
	/**
	 * Genera el container, con el campo para introducir el nombre del jugador
	 */
	private Container crearContainerMejorPuntuacion()
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
	
	/**
	 * Metodo utilizado para crear el menu para ingresar tu nombre
	 */
	public void menuNuevaMejorPuntuacion(MejorPuntuacion highscore)
	{
		this.text.setText("");
		
		this.highscore = highscore;
		
		Gui.getInstancia().remove(Gui.getInstancia().getTitulo());
		Gui.getInstancia().add(Gui.getInstancia().getNuevaMejorPuntuacion());
		Gui.getInstancia().getNuevaMejorPuntuacion().setSize(Gui.getInstancia().getTitulo().getSize());
		
		Gui.getInstancia().validate();
		Gui.getInstancia().pack();
		Mapa.setPuntuacionAcumulada(0);
		
		this.repaint();
	}
	
	/**
	 * Crea el boton de aceptar, el cual permitira volver al menu principal si el nombre es valido, en caso contrario informa por pantalla el error
	 */
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
				if (MejorPuntuacion.nombreValido(highscore.getNombre())) 
				{
					if(!MejorPuntuacion.nombreEnUso(nombre))
					{
						MejorPuntuacion.introducirMejorPuntuacion(highscore);
						
						MejorPuntuacion.exportarMejorPuntuacion();
						
						mensaje.setIcon(blank);
						
						//Regresa al menu
						Audio.musicaMenu();
						Gui.getInstancia().remove(Gui.getInstancia().getNuevaMejorPuntuacion());
						Gui.getInstancia().add(Gui.getInstancia().getTitulo());
						Gui.getInstancia().pack();
					}
					else
					{
						System.out.println("Nombre en uso");
	
						mensaje.setIcon(nombreEnUso);
					
					}
					
				}
				else
				{
					System.out.println("Nombre invalido");
					
					mensaje.setIcon(nombreInvalido);
				}
			}
		});
		
		return botonRegresar;
	}
	
}

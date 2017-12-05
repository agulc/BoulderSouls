package com.boulderdash.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.boulderdash.audio.Audio;
import com.boulderdash.entradasalida.MejorPuntuacion;
import com.boulderdash.fuente.MiFuente;
import com.boulderdash.principal.Mapa;

@SuppressWarnings("serial")
/**
 * Clase utilizada para crear el panel que aparece al hacer una nueva mejor puntuacion
 */
public class GuiNuevaMejorPuntuacion extends JPanel{
	
	private MejorPuntuacion highscore;
	private JTextField text;
	private JLabel mensaje;
	private JLabel mensajeDeCantidadDePuntos;
	
	private ImageIcon blank;
	private ImageIcon nombreEnUso;
	private ImageIcon nombreInvalido;

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
	 * Metodo utilizado para crear un label, con el icono Nuevohighscore
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
		label.setText("introduce un nombre: ");
		
		mensajeDeCantidadDePuntos = new JLabel();
		mensajeDeCantidadDePuntos.setBackground(Color.BLACK);
		mensajeDeCantidadDePuntos.setForeground(Color.WHITE);
		mensajeDeCantidadDePuntos.setFont(MiFuente.getFuente(30));
		mensajeDeCantidadDePuntos.setText("Su puntaje es: 1000000000");
		
		Container container2 = new Container();
		container2.setLayout(new FlowLayout());
		container2.add(label);
		
		Container container2b = new Container();
		container2b.setLayout(new FlowLayout());
		container2b.add(mensajeDeCantidadDePuntos);
		
		Container container2c = new Container();
		container2c.setLayout(new BorderLayout());
		container2c.add(container2,BorderLayout.SOUTH);
		container2c.add(container2b,BorderLayout.NORTH);
		
		this.text = new JTextField();
		text.setFont(MiFuente.getFuente(18));
		text.setBackground(Color.BLACK);
		text.setForeground(Color.WHITE);
		text.setColumns(30);
		
		Container container3 = new Container();
		container3.setLayout(new FlowLayout());
		container3.add(text);
		
		JLabel label2 = new JLabel();
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setFont(MiFuente.getFuente(30));
		
		Container container = new Container();
		container.setLayout(new BorderLayout());
		
		container.add(container2c,BorderLayout.NORTH);
		container.add(container3, BorderLayout.CENTER);
		container.add(label2,BorderLayout.SOUTH);
		
		return container;
	}
	
	/**
	 * Metodo utilizado para crear el menu para ingresar tu nombre
	 */
	public void menuNuevaMejorPuntuacion(MejorPuntuacion highscore)
	{
		this.text.setText("");
		
		this.mensajeDeCantidadDePuntos.setText("Su puntaje es: " + highscore.getPuntos());
		
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

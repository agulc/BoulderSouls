package com.boulderdash.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.boulderdash.fuente.MiFuente;

@SuppressWarnings("serial")
/**
 * Clase utilizada para crear el panel de reglas
 */
public class GuiReglas extends JPanel{

	public GuiReglas()
	{
		this.setLayout(new BorderLayout());
		JLabel label = new JLabel(new ImageIcon("./Texturas/sid.gif"));
		
		Container container = new Container();
		Container container2 = new Container();
		container.setLayout(new BorderLayout()); //Donde va la lista de reglas
		container.add(label, BorderLayout.NORTH);
		container.add(crearContainerReglas(), BorderLayout.SOUTH);
		
		container2.setLayout(new BorderLayout());
		
		container2.add(crearBotonRegresar(), BorderLayout.SOUTH);
		this.setBackground(Color.BLACK);
		this.add(container);
		this.add(container2, BorderLayout.SOUTH);
	}
	
	/**
	 * Crea el container con todas las reglas, con sus correspondientes gif
	 */
	private Container crearContainerReglas()
	{
		Font fuente = MiFuente.getFuente(21);
		
		JLabel regla1 = new JLabel(new ImageIcon("./Texturas/RockfordStatic.gif"));
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
		regla13.setText("Las amebas aparecen aleatoriamente, y se multiplican obstruyendo el camino");
		regla13.setFont(fuente);
		regla13.setForeground(Color.WHITE);
		
		JLabel regla14 = new JLabel(new ImageIcon("./Texturas/magic2.gif"));
		regla14.setText("Los muros magicos convierten rocas en diamantes y viceversa, se generan aleatoriamente");
		regla14.setFont(fuente);
		regla14.setForeground(Color.WHITE);
		
		Container containerReglas = new Container();

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
		containerReglas.add(regla14);
		
		return containerReglas;
	}

	/**
	 * Crea el boton regresar, con su propio action listener, el cual permite volver al titulo principal
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
				Gui.getInstancia().remove(Gui.getInstancia().getReglas());
				Gui.getInstancia().add(Gui.getInstancia().getTitulo());
				Gui.getInstancia().pack();
				System.out.println("Regresar presionado");
			}
		});
		
		return botonRegresar;
	}
	
	/**
	 * Grafica el menu de reglas
	 */
	public void menuReglas()
	{
		Gui.getInstancia().add(Gui.getInstancia().getReglas());
		Gui.getInstancia().setSize((int)Gui.getInstancia().getTitulo().getSize().getWidth(), 600);
		Gui.getInstancia().validate();
		Gui.getInstancia().repaint();
	}
}

package com.boulderdash.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.boulderdash.principal.Highscore;

@SuppressWarnings("serial")
public class GuiHighscores extends JPanel{
	
	public GuiHighscores()
	{
		this.setLayout(new BorderLayout());
		JLabel labelHighScores = new JLabel(new ImageIcon("./Texturas/PraiseTheSun.gif"));
		
		JTable tabla = Highscore.getTabla();
		
		this.setBackground(Color.BLACK);
		this.add(labelHighScores, BorderLayout.NORTH);
		this.add(tabla, BorderLayout.CENTER);
		this.add(crearBotonRegresar(), BorderLayout.SOUTH);
		
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
				Gui.getInstancia().remove(Gui.getInstancia().getHighscores());
				Gui.getInstancia().add(Gui.getInstancia().getTitulo());
				Gui.getInstancia().pack();
				System.out.println("Regresar presionado");
			}
		});
		
		return botonRegresar;
	}
	
	
	public void menuHighScores()
	{
		Gui.getInstancia().add(Gui.getInstancia().getHighscores());
		Gui.getInstancia().pack();
		Gui.getInstancia().setSize(Gui.getInstancia().getTitulo().getSize().width, Gui.getInstancia().getHighscores().getHeight());
		Gui.getInstancia().repaint();
	}

}

package com.boulderdash.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.boulderdash.audio.Audio;

@SuppressWarnings("serial")
public class GuiMuerte extends JPanel
{

	@SuppressWarnings("static-access")
	public static void muerte()
	{
		Gui.getInstancia().getMatriz().removeKeyListener(Gui.getInstancia().getMatriz().getTeclaEscucha());
		Gui.getInstancia().remove(Gui.getInstancia().getJuego());
		
		ImageIcon image = new ImageIcon("./Texturas/You Died.gif");
		JLabel etiqueta = new JLabel(image);

		Panel panelMuerte = new Panel();
		panelMuerte.setLayout(new BorderLayout());
		panelMuerte.setBackground(Color.BLACK);
		
		panelMuerte.add(etiqueta);
		
		Gui.getInstancia().add(panelMuerte);
		Gui.getInstancia().pack();
		
		Gui.getInstancia().setSize(Gui.getInstancia().getJuego().getSize());
		Gui.getInstancia().repaint();
		
		Audio.hasMuerto();
		try {
			Thread.sleep(2850);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Gui.getInstancia().remove(panelMuerte);
		
		Gui.getInstancia().getMatriz().reconstruir(); //Reconstruye el panel del mapa
		
		Gui.getInstancia().getTitulo().volverAlTitulo();
	}

}
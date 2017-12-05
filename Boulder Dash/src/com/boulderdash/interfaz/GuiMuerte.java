package com.boulderdash.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.boulderdash.audio.Audio;
import com.boulderdash.entradasalida.MejorPuntuacion;
import com.boulderdash.principal.Mapa;

@SuppressWarnings("serial")
/**
 * Clase utilizada para crear el panel de la muerte
 */
public class GuiMuerte extends JPanel
{

	@SuppressWarnings("static-access")
	/**
	 * Metodo para mostrar en pantalla el gif de has muerto
	 */
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
		
		MejorPuntuacion high = new MejorPuntuacion("",Mapa.getPuntuacionAcumulada(),Mapa.getTiempoAcumulado());
		
		if (MejorPuntuacion.highscoreValido(high))
		{
			Gui.getInstancia().getNuevaMejorPuntuacion().menuNuevaMejorPuntuacion(high);
		}
		else
		{
			Gui.getInstancia().getTitulo().volverAlTitulo();
		}
	}

}

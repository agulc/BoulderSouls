package com.boulderdash.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.boulderdash.personajes.Diamante;
import com.boulderdash.principal.Comportamiento;
import com.boulderdash.principal.Mapa;

import fuentes.MiFuente;

@SuppressWarnings("serial")
public class GuiHUD extends JPanel{

	private static int diamantesNivel;
	
	public GuiHUD()
	{
		GridLayout layout = new GridLayout();
		this.setLayout(layout);
		this.setBackground(Color.BLACK);

		Font fuente = MiFuente.getFuente(18);
	    
		JLabel vidas = new JLabel(new ImageIcon("./Texturas/heart.png"));
		vidas.setText("Vidas: ");
		vidas.setFont(fuente);
		vidas.setForeground(Color.WHITE);
		
		JLabel diamantesRestantes = new JLabel(new ImageIcon("./Texturas/diamond.gif"));
		diamantesRestantes.setText("Diamantes: ");
		diamantesRestantes.setFont(fuente);
		diamantesRestantes.setForeground(Color.WHITE);
		
		JLabel tiempoRestante = new JLabel(new ImageIcon("./Texturas/clock.gif"));
		tiempoRestante.setText("Timer: 0");
		tiempoRestante.setFont(fuente);
		tiempoRestante.setForeground(Color.WHITE);
		
		
		JLabel puntuacion = new JLabel();
		puntuacion.setText("Puntos: 0");
		puntuacion.setFont(fuente);
		puntuacion.setForeground(Color.WHITE);
		
		ImageIcon coin = new ImageIcon ("./Texturas/coin.png");
		coin.setImage(coin.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
		JLabel valorDiamantes = new JLabel(coin);
		valorDiamantes.setText("");
		valorDiamantes.setFont(fuente);
		valorDiamantes.setForeground(Color.WHITE);
		
		this.add(vidas);
		this.add(diamantesRestantes);
		this.add(valorDiamantes);
		this.add(tiempoRestante);
		this.add(puntuacion);
		diamantesNivel = Mapa.getDiamantesRestantes();
	}
	
	public void actualizarHud ()
	{
		((JLabel)(this.getComponent(0))).setText("" + Mapa.getInstancia().getVidas()); //Actualiza Las Vidas
		if (Mapa.getInstancia().getVidas() == 0 && Comportamiento.getMuerteExtra())
			((JLabel)(this.getComponent(0))).setText("Mou shindeiru");
		

		((JLabel)(this.getComponent(1))).setText("" + (diamantesNivel-Mapa.getDiamantesRestantes()) + "/" + diamantesNivel); //Actualiza Los diamantes restantes

		((JLabel)(this.getComponent(2))).setText(((Integer)(Diamante.getValorDiamante())).toString());
		
		((JLabel)(this.getComponent(3))).setText(((Integer)(Mapa.getInstancia().getTiempoRestante())).toString());
		
		Integer puntuacionTotal = (Mapa.getInstancia().getPuntuacionNivel() + Mapa.getPuntuacionAcumulada());
		((JLabel)(this.getComponent(4))).setText("Puntos: " + puntuacionTotal.toString());
	}
	
	public static void setDiamantesNivel(int valor){
		diamantesNivel = valor;
	}
	
}

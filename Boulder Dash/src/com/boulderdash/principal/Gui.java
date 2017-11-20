package com.boulderdash.principal;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.boulderdash.teclaescucha.MiTeclaEscucha;

public class Gui extends JFrame{

	private JLabel matriz [][]; //Matriz de JLabels para mostrar las imagenes
	
	public Gui()
	{
		addKeyListener(new MiTeclaEscucha());
		setSize(1206, 579);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cont = getContentPane();
		cont.setLayout(new GridLayout(22,40));
		
		JLabel label = new JLabel();
		//ImageIcon img = 
		
		matriz = new JLabel[40][22];
				
		for (int i = 0; i < 40;  i++)
		{
			for (int y = 0; y < 22;  y++)
			{
				matriz[i][y] = new JLabel();
				//matriz[i][y].setIcon(new ImageIcon(getClass().getResource("/Texturas/img.jpg")));
				cont.add(matriz[i][y]);
				//cont.add(new JLabel(new ImageIcon(getClass().getResource("/Texturas/img.jpg"))));
			}
		}
	
		pack();
		setVisible(true);

	}
	
	public void actualizarMatriz()
	{
		for (int i = 0; i < 40;  i++)
		{
			for (int y = 0; y < 22;  y++)
			{

				matriz[i][y].setIcon(new ImageIcon(getClass().getResource("/Texturas/img.jpg")));

			}
		}
	}
	
}

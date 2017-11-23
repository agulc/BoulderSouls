package com.boulderdash.principal;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTable;

import fuentes.MiFuente;

public class Highscore {
	
	private static Highscore[] arreglo = new Highscore[20];
	private static int dimensionLogica = 0;
	private static int cantidadAMostrar = 5;

	private String nombre;
	private int puntos;
	private int tiempo;
	
	public Highscore(String nombre, int puntos, int tiempo)
	{
		this.nombre = nombre;
		this.puntos = puntos;
		this.tiempo = tiempo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	
	
	////Metodos estaticos
	
	public static void introducirHighscore()
	{
		//Recibe un highscore e intenta introducirlo en el arreglo
		//Debera aumentar la dimension logica si esta no es 20 aun, de lo contrario debera reemplazar una puntuacion
	}
	
	public static int getElemento(int puesto)
	{
		//Devuelve el elemento en la posicion 'puesto - 1' del arreglo
		return 0;
	}
	
	public static void leerArchivoTxt()
	{
		//Leera el archivo txt y llenara el arreglo con los valores obtenidos
	}

	public static int getCantidadAMostrar() {
		return cantidadAMostrar;
	}

	public static void setCantidadAMostrar(int cantidadAMostrar) {
		Highscore.cantidadAMostrar = cantidadAMostrar;
	}
	
	public static JTable getTabla()
	{
		String[] columnas = {"", "", "", "", "", ""};
		String[][] filas = {{"", "Posicion", "Nombre","Puntuacion", "Tiempo", ""}
							, {"", "1", "Juan", "1500","4000",""}
							, {"", "2", "Pedro", "1300","4500",""}
							, {"", "3", "Rockford", "950","4500",""}
							, {"", "", "", "","",""}};
		
		JTable tabla = new JTable(filas,columnas) 
		{
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int data,int columns)
			{
				return false;
			}
		};
		
		Font fuente = MiFuente.getFuente(18);
		
		tabla.setFont(fuente);
		tabla.setForeground(Color.WHITE);
		tabla.setBackground(Color.BLACK);
		tabla.setGridColor(Color.BLACK);
		tabla.setFocusable(false);
		tabla.setRowSelectionAllowed(false);
		tabla.setFillsViewportHeight(true);
		tabla.setRowHeight(30);
		
		return tabla;
	}
	
}

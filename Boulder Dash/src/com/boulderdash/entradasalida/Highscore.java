package com.boulderdash.entradasalida;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import fuentes.MiFuente;

public class Highscore {
	
	private static Highscore[] arreglo = new Highscore[20];
	private static int cantidadAMostrar = 5;

	private String nombre;
	private int puntos;
	private int tiempo;
	
	
	public Highscore(String nombre, int puntos, int tiempo)
	{
		if (nombre.length() > 20) //Si es muy largo, lo corta
		{
			this.nombre = nombre.substring(0, 20);
		}
		else
		{
			this.nombre = nombre;
		}
		
		this.puntos = puntos;
		this.tiempo = tiempo;
	}
	
	public static void introducirHighscore(Highscore highscore)
	{
		for (int i = 0; i < 20; i++)
		{

			if (arreglo[i].getPuntos() < highscore.getPuntos())
				{
					for (int y = 19; y > i; y--)
					{
						arreglo[y] = arreglo[y-1];
					}
					
					arreglo[i] = highscore;
					
					System.out.println("Highscore introducido");
					
					break;
				}
		}
	}
	
	public static boolean nombreValido(String nombre)
	{
		if (nombre.length() < 2)
			return false;
		
		for (char c : nombre.toCharArray()) { //Si tiene un espacio en blanco no es valido
		    if (Character.isWhitespace(c)) {
		    	return false;
		    }
		}
		
		return true;
	}
	
	public static boolean nombreEnUso(String nombre)
	{
		for (int i = 0; i < 20; i++)
		{
			if (arreglo[i].getNombre().compareToIgnoreCase(nombre) == 0)
				return true;
		}
		
		return false;
	}
	
	public static boolean highscoreValido(Highscore h)
	{
		for (int i = 0; i < 20; i++)
		{
			if (arreglo[i].getPuntos() < h.getPuntos())
				return true;
		}
		
		return false;
	}
	
	
	public static Highscore getElemento(int puesto)
	{
		return arreglo[puesto-1];
	}
	
	public static void cargarArregloHighscores()
	{
		try
		{
			BufferedReader buffReader = new BufferedReader(new FileReader("./Archivos/Highscores.txt"));
		    String linea;
		    String[] lineaFragmentada;
		    
		    for (int i = 0; i < 20; i++)
		    {
		    	linea = buffReader.readLine();
		    	lineaFragmentada = linea.split(" ");
		    	
		    	arreglo[i] = new Highscore(lineaFragmentada[0],(Integer.parseInt(lineaFragmentada[1])), (Integer.parseInt(lineaFragmentada[2])));
		    	
		    	//System.out.println(lineaFragmentada[0] + " " + (Integer.parseInt(lineaFragmentada[1])) + " " + (Integer.parseInt(lineaFragmentada[2])));
		    	
		     }

		    buffReader.close(); 
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public static int getCantidadAMostrar() {
		return cantidadAMostrar;
	}

	public static void setCantidadAMostrar(int cantidadAMostrar) {
		Highscore.cantidadAMostrar = cantidadAMostrar;
	}
	
	private static String[][] arregloAMatriz()
	{
		String[][] filas = new String [22][4];
		filas[0][0] = "                 Posicion";
		filas[0][1] = "Nombre";
		filas[0][2] = "Puntuacion";
		filas[0][3] = "Tiempo";
		
		
		for (int i = 1; i < 21; i++)
		{
			filas[i][0] = ("                 " + (Integer)(i)).toString();
			filas[i][1] = arreglo[i-1].getNombre();
			filas[i][2] = ((Integer)arreglo[i-1].getPuntos()).toString();
			filas[i][3] = ((Integer)arreglo[i-1].getTiempo()).toString();
		}
		
		return filas;
	}
	
	@SuppressWarnings("serial")
	public static JTable getTabla()
	{
		//cargarArregloHighscores();
		
		String[] columnas = {"","","",""};
		String[][] filas = arregloAMatriz();

		JTable tabla = new JTable(filas,columnas) 
		{
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int data,int columns)
			{
				return false;
			}
		};
		
		Font fuente = MiFuente.getFuente(20);
		
		tabla.setFont(fuente);
		//tabla.setForeground(Color.WHITE);
		tabla.setBackground(Color.BLACK);
		tabla.setGridColor(Color.BLACK);
		tabla.setFocusable(false);
		tabla.setRowSelectionAllowed(false);
		tabla.setFillsViewportHeight(true);
		tabla.setRowHeight(30);
		
		tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
		    @Override
		    public Component getTableCellRendererComponent(JTable table,
		            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

		        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

		        if (row == 0)
		        {
		        	setForeground(Color.WHITE);
		        }
		        else
		        {
		        	if (row > cantidadAMostrar)
			        {
			        	setForeground(Color.BLACK);
			        }
			        else
			        {
			        	setForeground(Color.GRAY);
			        }
		        }
		        
		        
		        return this;
		    }   
		});
		
		return tabla;
	}
	
	public static void exportarHighscores ()
	{
		try
		{
			PrintWriter writer = new PrintWriter("./Archivos/Highscores.txt", "UTF-8");
			
			
			writer.write(""); 
			
			for (int i = 0; i < 20; i++)
			{
				writer.print(arreglo[i].getNombre() + " ");
				writer.print(((Integer)arreglo[i].getPuntos()).toString() + " ");
				writer.println(((Integer)arreglo[i].getTiempo()).toString());
			}
			writer.close();
			
			//Highscore.cargarArregloHighscores();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		
		if (nombre.length() > 20) //Si es muy largo, lo corta
		{
			this.nombre = nombre.substring(0, 20);
		}
		else
		{
			this.nombre = nombre;
		}
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

	
}

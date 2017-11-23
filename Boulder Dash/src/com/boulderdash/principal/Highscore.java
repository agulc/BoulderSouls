package com.boulderdash.principal;

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
	
}

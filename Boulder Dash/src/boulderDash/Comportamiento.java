package boulderDash;

public class Comportamiento {
	public static void Inicializar() throws Exception{
		Mapa.getInstancia();
		Mapa.getInstancia().graficarMapa();
	}
}

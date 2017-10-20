package boulderDash;

public class Comportamiento {
	public static void Inicializar() throws Exception{
		Mapa.getInstancia();
		graficarMapa();
	}
	public static void comportamientoNormal(paraDonde donde) throws Exception{
		activarIA();//Solo se actualiza al graficar, ya que en esta etapa el juego funciona por "turnos"
		moverARockford(donde);
		graficarMapa();
	}
	
	public static void graficarMapa() throws Exception{
		for (int y = 0; y < 22; y++)  {
			for (int x = 0; x < 40; x++) {
				System.out.print(Mapa.getInstancia().mapa[x][y].getGraficos()+",");
			}
			System.out.println();
		}
		System.out.println("Faltan " + Mapa.diamantesRestantes + " diamantes para poder escapar!!!!");
		System.out.println();
	}
	
	private static void activarIA() throws Exception{
		for (int y = 0; y < 22; y++)  {
			for (int x = 0; x < 40; x++) {
				Mapa.getInstancia().mapa[x][y].activarIA();
			}
		}
	}
	
	public static void moverARockford(paraDonde donde) throws Exception{
		Rockford.getInstancia().mover(donde);
	}
}

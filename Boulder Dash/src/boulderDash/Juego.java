package boulderDash;

public class Juego {
	/**
	 * Programa principal con los movimientos que Rockford
	 * realizará en los niveles 1 y 2
	 * @param args .
	 * @throws Exception .
	 */
	public static void main(String args[]) throws Exception{
		Comportamiento.Inicializar();
		
		Comportamiento.comportamientoNormal(ParaDonde.ABAJO);

		
		for(int i=0;i<7;i++){
			Comportamiento.comportamientoNormal(ParaDonde.DERECHA);
		}
		for(int i=0;i<2;i++){
			Comportamiento.comportamientoNormal(ParaDonde.ARRIBA);
		}
		
		Comportamiento.comportamientoNormal(ParaDonde.DERECHA);
		for(int i=0;i<2;i++){
			Comportamiento.comportamientoNormal(ParaDonde.ABAJO);
		}
		for(int i=0;i<8;i++){
			Comportamiento.comportamientoNormal(ParaDonde.DERECHA);
		}
		for(int i=0;i<2;i++){
			Comportamiento.comportamientoNormal(ParaDonde.ABAJO);
		}
		for(int i=0;i<5;i++){
			Comportamiento.comportamientoNormal(ParaDonde.DERECHA);
		}
		
		
		System.out.println("Nivel 1 terminado, tu puntaje actual es: "+Mapa.getPuntaje());
		
		
		
		Mapa.getInstancia().setNivelActual(2); //Aumenta el nivel
		Mapa.getInstancia().reconstruirMapa(); //Reconstruye el mapa
	
		Comportamiento.comportamientoNormal(ParaDonde.DERECHA);

		for(int i=0;i<3;i++){
			Comportamiento.comportamientoNormal(ParaDonde.ARRIBA);
		}

		for(int i=0;i<14;i++){
			Comportamiento.comportamientoNormal(ParaDonde.IZQUIERDA);
		}
		
		Comportamiento.comportamientoNormal(ParaDonde.ARRIBA);
		System.out.println("Nivel 2 terminado, tu puntaje actual es: "+Mapa.getPuntaje());
		
	}
}
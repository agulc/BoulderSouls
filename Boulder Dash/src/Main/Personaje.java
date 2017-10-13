package Main;

import java.util.Collections;
import java.util.List;

public abstract class Personaje {
	private Posicion pos;
	private boolean transitable;
	private List<Personaje> lista_de_personajes;
	
	protected List<Personaje> devolverAdyacentes(){
		return lista_de_personajes;
	}
	
	public void graficar(){
		
	}
}

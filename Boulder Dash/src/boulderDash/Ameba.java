package boulderDash;
import java.util.Random;

public class Ameba extends Enemigo{
	
	Random generador = new Random();
	
	Ameba(int x,int y){
		super(x,y);
	}
	
	public boolean getRun(){
		return false;
	}
	
	private void expandirse (int offsetX, int offsetY) throws Exception//Crea una ameba en la posicion con el offset recibido, si esta es Suciedad o Vacio
	{
		Posicion pos = new Posicion();
		pos.setX(this.getPos().getX() + offsetX);
		pos.setY(this.getPos().getY() + offsetY);
		
		if (Mapa.getInstancia().getPersonaje(pos) instanceof Suciedad || Mapa.getInstancia().getPersonaje(pos) instanceof Vacio)
		{
			Ameba hijo = new Ameba(pos.getX(),pos.getY());
			Mapa.getInstancia().setPersonaje(hijo);
			
			System.out.println("Una ameba se expande a ("+pos.getX()+","+pos.getY()+")"); //Notifica en consola
		}
	}
	
	public void actualizarEstadoObjeto()throws Exception{	
		
		int expandirse = 1 + generador.nextInt(100); //Genera un numero del 1 al 100
		int adyacente = 1 + generador.nextInt(8); //Determina en que cuadro adyacente intentara expandirse
	

		if (expandirse == 100) //Tiene una probabilidad de 1 en 100 de intentar expandirse
		{
			switch (adyacente)
			{
			case 1: 
				expandirse(-1,-1);
				break;
				
			case 2: 
				expandirse(-1,1);
				break;
				
			case 3: 
				expandirse(1,1);
				break;
				
			case 4: 
				expandirse(1,-1);
				break;
				
			case 5: 
				expandirse(0,1);
				break;
				
			case 6: 
				expandirse(0,-1);
				break;				
				
			case 7: 
				expandirse(1,0);
				break;				
				
			default: 
				expandirse(-1,0);
				break;				
			}
		}
		
		//IMPLEMENTAR EXPANSION/REPRODUCCION
		
		
	}
	
	public String getGraficos(){
		return "Ameba";
	}
 

}

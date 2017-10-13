package Main;

public class Posicion {
	private int coordX;
	private int coordY;
	
	public int getX(){
		return coordX;
	}
	
	public int getY(){
		return coordY;
	}
	
	public void setX(int x){
		this.coordX = x;
	}
	
	public void setY(int y){
		this.coordY = y;
	}
	
	int[] getPos(){
		int[] posiciones = new int[2];
		posiciones[1]=this.coordX;
		posiciones[2]=this.coordY;
		return posiciones;//Holis
	}
}

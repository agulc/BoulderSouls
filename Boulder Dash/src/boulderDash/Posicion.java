package boulderDash;

public class Posicion {
	private int coordX;
	private int coordY;
	
	public Posicion(int x, int y){
		this.coordX = x;
		this.coordY = y;
	}
	
	public Posicion(){
	}
	
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
	
	public int[] getPos(){
		int[] pos = new int[2];
		pos[0]=this.coordX;
		pos[1]=this.coordY;
		return pos;
	}
}

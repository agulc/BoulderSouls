package boulderDash;

public abstract class Muro extends Personaje{
	Muro(int x,int y){
		super(x,y);
	}
	
	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.WALL);
	}
}

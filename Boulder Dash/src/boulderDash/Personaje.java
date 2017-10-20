package boulderDash;

public abstract class Personaje {
	private Posicion pos;
	
	Personaje(int x,int y){
		pos = new Posicion(x,y);
	}
	
	public Posicion getPos(){
		return pos;
	}
	
	public void mover(String paraDonde){
		int[] pos = this.pos.getPos();
		if(this.permitirMovimiento(paraDonde,pos)){
			switch (paraDonde) { //Cabe destacar que arriba y abajo se manejan al revez en este caso
				case "up": {
					if(Mapa.mapa[pos[0]][pos[1]-1] instanceof Diamante){
						if(Mapa.mapa[pos[0]][pos[1]] instanceof Rockford){
							Mapa.diamantesRestantes--;
						}
						else{
							break;
						}
					}
					Mapa.mapa[pos[0]][pos[1]-1]=Mapa.mapa[pos[0]][pos[1]];
					Mapa.mapa[pos[0]][pos[1]-1].pos.setY(pos[1]-1);//Tambien debo actualizar su posicion en la instancia pos
					Mapa.mapa[pos[0]][pos[1]]=new Vacio(pos[0],pos[1]);
					break;
				}
				case "down": {
					if(Mapa.mapa[pos[0]][pos[1]+1] instanceof Diamante){
						if(Mapa.mapa[pos[0]][pos[1]] instanceof Rockford){
							Mapa.diamantesRestantes--;
						}
						else{
							break;
						}
					}
					Mapa.mapa[pos[0]][pos[1]+1]=Mapa.mapa[pos[0]][pos[1]];
					Mapa.mapa[pos[0]][pos[1]+1].pos.setY(pos[1]+1);//Tambien debo actualizar su posicion en la instancia pos
					Mapa.mapa[pos[0]][pos[1]]=new Vacio(pos[0],pos[1]);
					break;
				}		
				case "left": {
					if(Mapa.mapa[pos[0]-1][pos[1]] instanceof Diamante){
						if(Mapa.mapa[pos[0]][pos[1]] instanceof Rockford){
							Mapa.diamantesRestantes--;
						}
						else{
							break;
						}
					}
					Mapa.mapa[pos[0]-1][pos[1]]=Mapa.mapa[pos[0]][pos[1]];
					Mapa.mapa[pos[0]-1][pos[1]].pos.setX(pos[0]-1);//Tambien debo actualizar su posicion en la instancia pos
					Mapa.mapa[pos[0]][pos[1]]=new Vacio(pos[0],pos[1]);
					break;
				}	
				case "right": {
					if(Mapa.mapa[pos[0]+1][pos[1]] instanceof Diamante){
						if(Mapa.mapa[pos[0]][pos[1]] instanceof Rockford){
							Mapa.diamantesRestantes--;
						}
						else{
							break;
						}
					}
					Mapa.mapa[pos[0]+1][pos[1]]=Mapa.mapa[pos[0]][pos[1]];
					Mapa.mapa[pos[0]+1][pos[1]].pos.setX(pos[0]+1);//Tambien debo actualizar su posicion en la instancia pos
					Mapa.mapa[pos[0]][pos[1]]=new Vacio(pos[0],pos[1]);
					break;
				}
		}
		}
	}
	
	public boolean permitirMovimiento(String mov,int[] pos){
		int x = pos[0];
		int y = pos[1];
		if((x>=0)&&(x<40)&&((y>=0)&&(y<22))){
			switch (mov) {
				case "up": return Mapa.mapa[x][y-1].getRun();
				case "down": return Mapa.mapa[x][y+1].getRun();		
				case "left": return Mapa.mapa[x-1][y].getRun();		
				case "right": return Mapa.mapa[x+1][y].getRun();
				default: return false;
			}
		}
		return false;
	}
	
	
	//public abstract String getGrafico();
	
	public abstract boolean getRun();
	
	public abstract void activarIA();
}

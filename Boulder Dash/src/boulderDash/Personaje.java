package boulderDash;

public abstract class Personaje {
	public Posicion pos;
	
	Personaje(int x,int y){
		pos = new Posicion(x,y);
	}
	
	public Posicion getPos(){
		return pos;
	}
	
	/*public void mover2(paraDonde donde){
		Mapa.mapa[pos[0]][pos[1]-1]=Mapa.mapa[pos[0]][pos[1]];
		Mapa.mapa[pos[0]][pos[1]-1].pos.setY(pos[1]-1);//Tambien debo actualizar su posicion en la instancia pos
		Mapa.getInstancia().getPersonaje(this.pos)=new Vacio(pos[0],pos[1]);
	}*/
	
	public void mover(paraDonde donde){
		int[] pos = this.pos.getPos();
		if(this.permitirMovimiento(donde,pos)){
			switch (donde) { //Cabe destacar que arriba y abajo se manejan al revez en este caso
				case ARRIBA: {
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
				case ABAJO: {
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
				case IZQUIERDA: {
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
				case DERECHA: {
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
	
	public void actualizarPosiciones(){
		
	}
	
	public boolean permitirMovimiento(paraDonde donde,int[] pos){
		int x = pos[0];
		int y = pos[1];
		if((x>=0)&&(x<40)&&((y>=0)&&(y<22))){
			switch (donde) {
				case ARRIBA: return Mapa.mapa[x][y-1].getRun();
				case ABAJO: return Mapa.mapa[x][y+1].getRun();		
				case IZQUIERDA: return Mapa.mapa[x-1][y].getRun();		
				case DERECHA: return Mapa.mapa[x+1][y].getRun();
				default: return false;
			}
		}
		return false;
	}
	
	
	//public abstract String getGrafico();
	
	public abstract boolean getRun();
	
	public abstract void activarIA();
}

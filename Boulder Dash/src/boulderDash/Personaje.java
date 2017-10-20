package boulderDash;

public abstract class Personaje {
	private Posicion pos;
	
	Personaje(int x,int y){
		pos = new Posicion(x,y);
	}
	
	Personaje(Posicion pos2){
		pos = new Posicion();
		pos = pos2;
	}
	
	Personaje(){
		pos = new Posicion();
	}
	
	public Posicion getPos(){
		return pos;
	}
	
	public Posicion getPos(paraDonde donde){
		return pos.getPos(donde);
	}
	
	public void mover(paraDonde donde) throws Exception{
		int[] pos = this.pos.getPos();jajajajjanoandaaaaLOLHay que cambiar esto por la posicion
		if(this.permitirMovimiento(donde,pos)){
			switch (donde) { //Cabe destacar que arriba y abajo se manejan al revez en este caso
				case ARRIBA: {
					if(Mapa.getInstancia().mapa[pos[0]][pos[1]-1] instanceof Diamante){
						if(Mapa.getInstancia().mapa[pos[0]][pos[1]] instanceof Rockford){
							Mapa.diamantesRestantes--;
						}
						else{
							break;
						}
					}
					Mapa.getInstancia().mapa[pos[0]][pos[1]-1]=Mapa.getInstancia().mapa[pos[0]][pos[1]];
					Mapa.getInstancia().mapa[pos[0]][pos[1]-1].pos.setY(pos[1]-1);//Tambien debo actualizar su posicion en la instancia pos
					Mapa.getInstancia().mapa[pos[0]][pos[1]]=new Vacio(pos[0],pos[1]);
					break;
				}
				case ABAJO: {
					if(Mapa.getInstancia().mapa[pos[0]][pos[1]+1] instanceof Diamante){
						if(Mapa.getInstancia().mapa[pos[0]][pos[1]] instanceof Rockford){
							Mapa.diamantesRestantes--;
						}
						else{
							break;
						}
					}
					Mapa.getInstancia().mapa[pos[0]][pos[1]+1]=Mapa.getInstancia().mapa[pos[0]][pos[1]];
					Mapa.getInstancia().mapa[pos[0]][pos[1]+1].pos.setY(pos[1]+1);//Tambien debo actualizar su posicion en la instancia pos
					Mapa.getInstancia().mapa[pos[0]][pos[1]]=new Vacio(pos[0],pos[1]);
					break;
				}		
				case IZQUIERDA: {
					if(Mapa.getInstancia().mapa[pos[0]-1][pos[1]] instanceof Diamante){
						if(Mapa.getInstancia().mapa[pos[0]][pos[1]] instanceof Rockford){
							Mapa.diamantesRestantes--;
						}
						else{
							break;
						}
					}
					Mapa.getInstancia().mapa[pos[0]-1][pos[1]]=Mapa.getInstancia().mapa[pos[0]][pos[1]];
					Mapa.getInstancia().mapa[pos[0]-1][pos[1]].pos.setX(pos[0]-1);//Tambien debo actualizar su posicion en la instancia pos
					Mapa.getInstancia().mapa[pos[0]][pos[1]]=new Vacio(pos[0],pos[1]);
					break;
				}	
				case DERECHA: {
					if(Mapa.getInstancia().mapa[pos[0]+1][pos[1]] instanceof Diamante){
						if(Mapa.getInstancia().mapa[pos[0]][pos[1]] instanceof Rockford){
							Mapa.diamantesRestantes--;
						}
						else{
							break;
						}
					}
					Mapa.getInstancia().mapa[pos[0]+1][pos[1]]=Mapa.getInstancia().mapa[pos[0]][pos[1]];
					Mapa.getInstancia().mapa[pos[0]+1][pos[1]].pos.setX(pos[0]+1);//Tambien debo actualizar su posicion en la instancia pos
					Mapa.getInstancia().mapa[pos[0]][pos[1]]=new Vacio(pos[0],pos[1]);
					break;
				}
		}
		}
	}
	
	public abstract String getGraficos();
	
	public boolean permitirMovimiento(paraDonde donde,int[] pos) throws Exception{
		int x = pos[0];
		int y = pos[1];
		if((x>=0)&&(x<40)&&((y>=0)&&(y<22))){
			switch (donde) {
				case ARRIBA: return Mapa.getInstancia().mapa[x][y-1].getRun();
				case ABAJO: return Mapa.getInstancia().mapa[x][y+1].getRun();		
				case IZQUIERDA: return Mapa.getInstancia().mapa[x-1][y].getRun();		
				case DERECHA: return Mapa.getInstancia().mapa[x+1][y].getRun();
				default: return false;
			}
		}
		return false;
	}
	
	
	//public abstract String getGrafico();
	
	public abstract boolean getRun();
	
	public void moverPersonajes() throws Exception{
		//No hago nada por defecto
	}
	
	public void actualizarEstadoObjeto() throws Exception{
		//No hago nada por defecto
	}
	
	public void meCaeAlgoEncima() throws Exception{
		//No hace nada por defecto
	}
}

package boulderDash;

public abstract class ObjetoNewton extends Personaje{
	
	private State stat;
	
	public enum State{
		Estacionario, Cayendo;
	}
	
	public ObjetoNewton(boolean cae,int x, int y){
		super(x,y);
		if(cae){
			this.stat = State.Cayendo;
		}
		else{
			this.stat = State.Estacionario;
		}
	}
	
	public void activarIA() throws Exception{
		int x = super.pos.getX();
		int y = super.pos.getY();
		if(stat == State.Cayendo){
			String tipo = Mapa.getInstancia().mapa[x][y+1].getClass().getSimpleName();
			switch(tipo){
				case "Vacio":{
					this.mover(paraDonde.ABAJO);
					System.out.println(Mapa.getInstancia().mapa[x][y].getClass().getSimpleName() + " en la posicion x=" + x + " y=" + y + " acaba de caer");
					this.chequearObjetoDebajo(x, y+1);
				}
				case "Rockford":{
					if(this instanceof Roca){
						/*Rockford muere, todavia no se como*/
					}
					else{//Si no es una roca, me elimino a mi mismo y los diamantes restantes pasan a ser uno menos
						Mapa.diamantesRestantes--;
						Mapa.getInstancia().mapa[x][y] = new Vacio(x,y);
						System.out.println(Mapa.getInstancia().mapa[x][y].getClass().getSimpleName() + " en la posicion x=" + x + " y=" + y + " cayo encima de rockford");
					}
				}
				case "Luciernaga":{if(this instanceof Roca){/*La luciernaga explota, tampoco se como*/}}
				case "Mariposa":{if(this instanceof Roca){/*La mariposa explota, tampoco se como*/}}
			}
	 	}
		else{
	 	//Actualizo mi estado para en un futuro ver si caigo o no
	 	this.chequearObjetoDebajo(x, y);
		}
	}
	
	public void chequearObjetoDebajo(int x, int y) throws Exception{
		if((Mapa.getInstancia().mapa[x][y+1] instanceof Vacio)||(Mapa.getInstancia().mapa[x][y+1] instanceof Rockford)){/*Podriamos reemplazarlo por el chequear objeto debajo y actualizar dependiendo de eso*/
	 		this.stat = State.Cayendo;
	 		System.out.println(Mapa.getInstancia().mapa[x][y].getClass().getSimpleName() + " en la posicion x=" + x + " y=" + y + " esta cayendo");
 		}
	 	else{
	 		if((Mapa.getInstancia().mapa[x-1][y] instanceof Vacio)&&((Mapa.getInstancia().mapa[x-1][y+1] instanceof Vacio)||(Mapa.getInstancia().mapa[x-1][y+1] instanceof Rockford))){
	 			super.mover(paraDonde.IZQUIERDA);
	 			this.stat = State.Cayendo;
	 			System.out.println(Mapa.getInstancia().mapa[x][y].getClass().getSimpleName() + " en la posicion x=" + x + " y=" + y + " esta cayendo");
	 		}
	 		else{
	 			this.stat = State.Estacionario;
	 			System.out.println(Mapa.getInstancia().mapa[x][y].getClass().getSimpleName() + " en la posicion x=" + x + " y=" + y + " esta estacionari@");
	 		}
	 	}
	}

}

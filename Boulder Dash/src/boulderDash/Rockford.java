package boulderDash;

public class Rockford extends Personaje{
	
	private static Rockford rock = null;
	
	public static Rockford getInstancia(){
		if(rock == null){
			rock = new Rockford();
		}
		return rock;
	}
	
	private Rockford(){
	}
	
	public Personaje setPosicion(int x, int y){//Lo hacemos asi porque sino no seria un singleton
		if(rock!=null){
			rock.getPos().setX(x);
			rock.getPos().setY(y);
		}
		return rock;
	}
	
	public boolean getRun(){
		return false;
	}
	
	public void activarIA(){
	}
	
	public String getGraficos(){
		return "Rockford";
	}
	
	public void muerte() throws Exception{
		
		Mapa.getInstancia().setVidas(Mapa.getInstancia().getVidas() - 1); //Bajo las vidas
		
		if (Mapa.getInstancia().getVidas() == 0){
			System.out.println("Has Muerto");
		}
		else
		{
			Mapa.getInstancia().reconstruirMapa();
		}
		
		//
		
	}
	
	public void meCaeAlgoEncima() throws Exception{
		if(Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.ROCK)){
			this.muerte();
		}
		else{//Si no es una roca, me elimino a mi mismo y los diamantes restantes pasan a ser uno menos
			Mapa.diamantesRestantes--;
			Mapa.getInstancia().setPersonaje(new Vacio(super.getPos(ParaDonde.ARRIBA)) , super.getPos(ParaDonde.ARRIBA));
			System.out.println("Diamante" + " en la posicion x=" + super.getPos(ParaDonde.ARRIBA).getX() + " y=" + super.getPos(ParaDonde.ARRIBA).getY() + " cayo encima de rockford");
		}
	}
	
	@Override
	public void recibeExplosion() throws Exception{ 
		
		this.muerte();

	}

	public boolean chequearSiSoy (BDTile tile){

		return (tile == BDTile.PLAYER);
	}
	
	public void movimiento(ParaDonde dir) throws Exception{

		if (Mapa.getInstancia().getPersonaje(super.getPos(dir)).rockfordCaminaSobreMi(dir)){ //Si se pudo mover
				
			Mapa.getInstancia().setPersonaje(this.getInstancia(),super.getPos(dir)); //Se mueve al siguiente casillero
			Mapa.getInstancia().setPersonaje(new Vacio(this.getPos()), this.getPos());
			super.setPos(super.getPos(dir)); //Actualizo mi posicion
				
		}
			
	}
	
}

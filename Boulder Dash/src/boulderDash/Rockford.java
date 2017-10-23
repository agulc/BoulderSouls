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
	
	public boolean getRun(ParaDonde donde){
		return false;
	}
	
	public String getGraficos(){
		return "®";
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
		
		
		
	}
	
	public void meCaeAlgoEncima() throws Exception{
		if(Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)).chequearSiSoy(BDTile.ROCK)){
			System.out.println("ROCA" + " en la posicion x=" + super.getPos(ParaDonde.ARRIBA).getX() + " y=" + super.getPos(ParaDonde.ARRIBA).getY() + " cayo encima de rockford");
			this.explotar();
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
				
			Mapa.getInstancia().setPersonaje(Rockford.getInstancia(),super.getPos(dir)); //Se mueve al siguiente casillero
			Mapa.getInstancia().setPersonaje(new Vacio(this.getPos()), this.getPos()); //Vacia el cacillero anterior
			super.setPos(super.getPos(dir)); //Actualizo mi posicion
				
		}
			
	}
	
	public void explotar() throws Exception{
		
		int a = this.getPos().getX() - 1; //Empieza en la esquina superior izquierda
		int b = this.getPos().getY() - 1;
		Posicion pos = new Posicion();
		
		for (int i = a; a <= (a+3); a++) //Recorre los personajes adyacentes
		{
			for (int j = b; b <= (b+3); b++)
			{
				pos.setX(i);
				pos.setY(j);
				Mapa.getInstancia().getPersonaje(pos).recibeExplosion(); //Envia la explosion al personaje
				
			}
		}
	}
	
}

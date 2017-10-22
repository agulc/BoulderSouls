package boulderDash;


public class Luciernaga extends EnemigoMovil{
	
	Luciernaga(int x,int y){
		super(x,y);
	}
	
	public boolean getRun(){
		return false;
	}

	public void activarIA(){	
		
		//IMPLEMENTAR MOVIMIENTO
	}
	
	public String getGraficos(){
		return "Luciernaga";
	}
	
	public void meCaeAlgoEncima() throws Exception{
		if(Mapa.getInstancia().getPersonaje(super.getPos(ParaDonde.ARRIBA)) instanceof Roca){
			this.explotar();
			
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

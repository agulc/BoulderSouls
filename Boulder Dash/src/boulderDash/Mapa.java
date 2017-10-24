package boulderDash;

public class Mapa {
	
	private static int nivelActual = 1;
	private static int puntuacion = 0;
	private static int vidas = 4;
	public Personaje[][] mapa; 
	public static int diamantesRestantes;
	private static Mapa instancia = null; 

	public static Mapa getInstancia() throws Exception{
		if(instancia == null){
			instancia = new Mapa();
		}
		return instancia;
	}

	
	/**
	 * Escencia del juego. Crea el nivel solicitado
	 * @throws Exception .
	 */
	private Mapa () throws Exception
	{
		BDLevelReader lectorNiveles = new BDLevelReader();
		lectorNiveles.readLevels("levels.xml");
		lectorNiveles.setCurrentLevel(nivelActual);
		mapa = new Personaje[lectorNiveles.getWIDTH()][lectorNiveles.getHEIGHT()];
		diamantesRestantes = lectorNiveles.getDiamondsNeeded();
		for(int x=0;x<lectorNiveles.getWIDTH();x++){
			for(int y=0;y<lectorNiveles.getHEIGHT();y++){
				switch(lectorNiveles.getTile(x,y)){
					case EMPTY:{
						mapa[x][y]=new Vacio(x,y);
						break;
					}
					case DIRT:{
						mapa[x][y]=new Suciedad(x,y);
						break;
					}
					case TITANIUM:{
						mapa[x][y]=new MuroTitanio(x,y);
						break;
					}
					case WALL:{
						mapa[x][y]=new MuroMagico(x,y);
						break;
					}
					case ROCK:{
						mapa[x][y]=new Roca(false,x,y);
						break;
					}
					case FALLINGROCK:{
						mapa[x][y]=new Roca(true,x,y);
						break;
					}
					case DIAMOND:{
						mapa[x][y]=new Diamante(false,x,y);
						break;
					}
					case FALLINGDIAMOND:{
						mapa[x][y]=new Diamante(true,x,y);
						break;
					}
					case AMOEBA:{
						mapa[x][y]=new Ameba(x,y);
						break;
					}
					case FIREFLY:{
						mapa[x][y]=new Luciernaga(x,y);
						break;
					}
					case BUTTERFLY:{
						mapa[x][y]=new Mariposa(x,y);
						break;
					}
					case EXIT:{
						mapa[x][y]=new PuertaDeSalida(x,y);
						break;
					}
					case PLAYER:{
						mapa[x][y]=Rockford.getInstancia().setPosicion(x,y);
						break;
					}
				}
			}
		}
	}
	
	public Personaje getPersonaje(Posicion pos){
		return this.mapa[pos.getX()][pos.getY()];
	}

	public void setPersonaje(Personaje pers, Posicion pos){
		mapa[pos.getX()][pos.getY()] = pers;
	}
	
	public void reconstruirMapa () throws Exception{
		
		instancia = new Mapa();
		System.out.println("El mapa se acaba de reconstruir");
		
	}
	
	public void setNivelActual(int nivel){
		Mapa.nivelActual = nivel;
	}
	
	public void setVidas(int vidas){
		Mapa.vidas = vidas;
		
	}
	
	public int getVidas(){
		return Mapa.vidas;
		
	}
	
	public static void incrementarPuntaje(){
		Mapa.puntuacion = Mapa.puntuacion + 100;
	}
	
	public static int getPuntaje(){
		return Mapa.puntuacion;
	}
}

package boulderDash;

public class Mapa {
	
	public static Personaje[][] mapa; //Sera estatico para poder ser accedido por otros metodos o clases
	private int puntuacion;
	private int vidas;
	public static int diamantesRestantes;
	
	public Mapa (int NivelElegido) throws Exception
	{
		this.vidas = 4;
		this.puntuacion = 0;
		BDLevelReader lectorNiveles = new BDLevelReader();
		lectorNiveles.readLevels("levels.xml");
		lectorNiveles.setCurrentLevel(NivelElegido);
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
						mapa[x][y]=new Rockford(x,y);
						break;
					}
				}
			}
		}
	}
	
	int[] getPosicionRockford(){
		for (int x = 0; x < 40; x++) {
			for (int y = 0; y < 22; y++) {
				if(Mapa.mapa[x][y] instanceof Rockford){
					return Mapa.mapa[x][y].pos.getPos();
				}
			}
		}
	return null;
	}
	
	public void moverARockford(String paraDonde){
		int[] pos = getPosicionRockford();
		mapa[pos[0]][pos[1]].mover(paraDonde);
	}
	
	public void graficarMapa(){
		activarIA();//Solo se actualiza al graficar, ya que en esta etapa el juego funciona por "turnos"
		for (int y = 0; y < 22; y++)  {
			for (int x = 0; x < 40; x++) {
				System.out.print(mapa[x][y].getClass().getName()+",");
			}
			System.out.println();
		}
		System.out.println("Faltan " + diamantesRestantes + " diamantes para poder escapar!!!!");
		System.out.println();
	}
	
	private void activarIA(){
		for (int y = 0; y < 22; y++)  {
			for (int x = 0; x < 40; x++) {
				mapa[x][y].activarIA();
			}
		}
	}
}

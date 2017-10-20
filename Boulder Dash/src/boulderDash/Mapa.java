package boulderDash;

import java.util.Scanner;

public class Mapa {
	
	private int puntuacion;
	private int vidas;
	public Personaje[][] mapa; //Sera estatico para poder ser accedido por otros metodos o clases	
	public static int diamantesRestantes;
	private static Mapa instancia = null; 
	
	public static Mapa getInstancia() throws Exception{
		if(instancia == null){
			instancia = new Mapa();
		}
		return instancia;
	}
	
	private Mapa () throws Exception
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el nivel que desea: ");
		int NivelElegido = scanner.nextInt();
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
	
	public void setPersonaje(Personaje pers){
		mapa[pers.getPos().getX()][pers.getPos().getY()] = pers;
	}
}

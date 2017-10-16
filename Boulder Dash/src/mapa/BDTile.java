package mapa;
public enum BDTile {
         EMPTY(true)               , 
         DIRT(true)                ,
         TITANIUM(false)           , 
         WALL(false)               , 
         ROCK(false)               , 
         FALLINGROCK(false)        , 
         DIAMOND(true)             , 
         FALLINGDIAMOND(true)      , 
         AMOEBA(false)             , 
         FIREFLY(false)            , 
         BUTTERFLY(false)          , 
         EXIT(false)               , 
         PLAYER(true);//Aunque nunca voy a intentar caminar encima mio
	private boolean runnable;
	BDTile(boolean run){
		this.runnable=run;
	}
	
	public boolean getRun(){
		return this.runnable;
	}
	
	void invRun(){
		this.runnable=!this.runnable;
	}
}
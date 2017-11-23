package fuentes;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MiFuente {
	
	private static Font fuente = null;	   
	private static InputStream myStream = null;
	{
	
	}
	
	public static Font getFuente(int size)
	{
		
		//fuente = fuente.deriveFont(Font.BOLD, 12);
		
		
		try {
			myStream = new BufferedInputStream(new FileInputStream("src/fuentes/OptimusPrinceps.ttf"));
			fuente = Font.createFont(Font.TRUETYPE_FONT, myStream );
	        fuente = fuente.deriveFont(Font.BOLD, size);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fuente;
		
		//return new Font("Serif",Font.BOLD,10);
	}

}

package juegos.modificalo;

import com.badlogic.gdx.graphics.Pixmap;

public class Ubicacion {
	public String elemento;
	public int mx1;
	public int mx2;
	public int my1;
	public int my2;
	public int xF;
	public int yF;
	public int modificador;
	
	public Ubicacion(String e,int xF,int yF,int mod) {
		this.modificador = mod; 
		this.elemento = e;
		this.xF = xF;
		this.yF = yF;
		this.mx1 = xF - modificador;
		this.mx2 = xF + modificador;
		this.my1 = yF - modificador;
		this.my2 = yF + modificador;
	}
}

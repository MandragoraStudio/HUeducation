package juegos.museo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class Cuadro extends Button {
	
	private boolean inicializado;
	
	public Cuadro(CuadroXL cuadroxl){
		super("cuadro",new TextureRegion(new Texture("imagenes2/museo/TexturesMuseo.png"), 199, 600, 385, 305));
	}
	
	public void Initialize(){
		inicializado=false;
	}
	

	public boolean isInicializado() {
		return inicializado;
	}

	public void setInicializado(boolean inicializado) {
		this.inicializado = inicializado;
	}
	
}

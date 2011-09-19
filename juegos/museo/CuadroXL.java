package juegos.museo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class CuadroXL extends Button {
	
	private boolean inicializado;
	
	public CuadroXL(){
		super("cuadro",new TextureRegion(new Texture("imagenes2/museo/TexturesMuseo2.png"), 0, 0, 814, 549));
		
	}
	
	public void Initialize(){
		this.x=103;
		this.y=30;
		inicializado=false;
	}

	public boolean isInicializado() {
		return inicializado;
	}

	public void setInicializado(boolean inicializado) {
		this.inicializado = inicializado;
	}
}

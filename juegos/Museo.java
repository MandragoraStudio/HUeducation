package juegos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class Museo extends Juego{
	
	private Image fondo;
	
	 public Museo(){
	    }
	 public void Initialize(){
	    	super.Initialize();
	    	fondo = new Image("fondo", new Texture("imagenes/museo/fondoMuseo.png"));
	    	this.escena.addActor(fondo);
	    }
}

package juegos.museo;

import juegos.Juego;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class Museo extends Juego{
	
	private Image fondo;
	
	 public Museo(){
		 super();
		 
	    }
	 @Override
	 public void Load(){
		 
		 
	 }
	 @Override
	 public void Initialize(){
	    	super.Initialize();
	    	fondo = new Image("fondo", new Texture("imagenes/museo/fondoMuseo.png"));
	    	this.escena.addActor(fondo);
	    }
}

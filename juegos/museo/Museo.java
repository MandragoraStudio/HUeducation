package juegos.museo;

import juegos.Juego;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Image;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;

public class Museo extends Juego{
	
	private Image fondo;
	private Button izquierda;
	private Button derecha;
	
	 public Museo(){
		 super();
		 
	    }
	 @Override
	 public void Load(){
		 
		 
	 }
	 @Override
	 public void Initialize(){
	    	super.Initialize();
	    	fondo = new Image("fondo", new TextureRegion(new Texture("imagenes/museo/TexturesMuseo.png"), 0,0,1024,600));
	    	this.escena.addActor(fondo);
	    	
	    	this.setButtons();
	    }
	 private void setButtons(){
		 derecha = new Button("derecha", new TextureRegion(new Texture("imagenes/museo/TexturesMuseo.png"), 0,600,101,110));
		 derecha.x=900;
		 derecha.y=270;
			this.escena.addActor(derecha);
			derecha.clickListener=new ClickListener(){
			
				public void clicked(Button arg0) {

				}};
		    
	 		izquierda = new Button("izquierda", new TextureRegion(new Texture("imagenes/museo/TexturesMuseo.png"), 101,600,98,110));
			izquierda.x=40;
			izquierda.y=270;
			this.escena.addActor(izquierda);
			izquierda.clickListener=new ClickListener(){
			
				public void clicked(Button arg0) {

				}};
		    }
}

package juegos.mezcla;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

import juegos.Juego;

public class MezclaColores extends Juego {

	Image fondo;
	Image lienzo;
	
    public MezclaColores () {
    }

    public void Draw () {
    }

    public void Update () {
    }
    
    public void Load(){
    	fondo =new Image("fondo",new Texture("imagenes/mezcla/fondo.png"));
    	lienzo=new Image("fondo",new Texture("imagenes/mezcla/lienzo.png"));
    	lienzo.y=50;
    	lienzo.x=50;
    }
    
    public void Initialize(){
    	super.Initialize();
    	this.escena.addActor(fondo);
    	this.escena.addActor(lienzo);
    	
    	
    }
}


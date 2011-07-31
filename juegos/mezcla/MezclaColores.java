package juegos.mezcla;

import juegos.Juego;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class MezclaColores extends Juego {

	Image fondo;
	Image lienzo;
	Paleta paleta;
	
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
    	paleta= new Paleta("paleta");
    	paleta.x=450;
    	paleta.height=600;
    }
    
    public void Initialize(){
    	super.Initialize();
    	this.escena.addActor(fondo);
    	this.escena.addActor(lienzo);
    	this.escena.addActor(paleta);
    	
    	
    }
}


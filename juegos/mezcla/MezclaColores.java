package juegos.mezcla;

import juegos.Juego;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class MezclaColores extends Juego {

	Image fondo;
	static DrawableImage lienzo;
	Paleta paleta;
	
	
	
	
    public MezclaColores () {
    }

    public void Draw () {
    }

    public void Update () {
    	super.Update();
    }
    
    public void Load(){
    	fondo =new Image("fondo",new Texture("imagenes/mezcla/fondo.png"));
    	Texture papel = new Texture(550,500,Format.RGBA8888);
    	Pixmap blanco = new Pixmap(550,500,Format.RGBA8888);
    	blanco.setColor(1,1,1,1);
    	blanco.fill();
    	papel.draw(blanco,0,0);
    	lienzo=new DrawableImage("fondo",papel);
    	cambiarColorPincel(1,0,0);
    	lienzo.y=50;
    	lienzo.x=25;
    	paleta= new Paleta("paleta");
    	paleta.x=600;
    	paleta.height=600;
    }
    
    public void Initialize(){
    	super.Initialize();
    	this.escena.addActor(fondo);
    	this.escena.addActor(lienzo);
    	this.escena.addActor(paleta);
    	
    	
    }
    
    public static void cambiarColorPincel(float r,float g, float b){
		lienzo.pincel.setColor(r, g, b, 1);
		lienzo.pincel.fillCircle(5, 5, 5);
	}
}


package juegos.mezcla;

import principal.ScreenManager;
import juegos.Juego;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Image;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;

public class MezclaColores extends Juego {

	Image fondo;
	static DrawableImage lienzo;
	Paleta paleta;
	private Button BAtras;
	
	
	
	
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
    	
		// Boton atras
		BAtras = new Button("salir",new TextureRegion(new Texture("imagenes2/Menu/atras sin pulsar.png")),new TextureRegion(new Texture("imagenes2/Menu/atras pulsado.png")));
		BAtras.x = this.escena.width() - BAtras.width -20;
		BAtras.y = this.escena.height() - BAtras.height -20;
		this.escena.addActor(BAtras);
		BAtras.clickListener=new ClickListener(){
			public void clicked(Button b){
				ScreenManager.getScreenManager().setCurrentScreen("menu");
			}
		};   	
    	
    }
    
    public static void cambiarColorPincel(float r,float g, float b){
		lienzo.pincel.setColor(r, g, b, 1);
		lienzo.pincel.fillCircle(5, 5, 5);
	}
}


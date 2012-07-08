package juegos.mezcla;

import principal.GameGlobals;
import principal.ScreenManager;
import juegos.Juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
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
	
	// Ardilla
	private int i = 0;
	private int j = 0;

	private Music[] take = new Music[5];
	int indice = 0;
	int MAXtakes = 5;
	int Xardilla = GameGlobals.posXardilla;
	int Yardilla = GameGlobals.posYardilla;
	
	private long tiempoSalida = 700;
	private boolean saliendo = false;
	
	boolean reproducir = true;
	
	
	
	
    public MezclaColores () {
    }

    public void Draw () {
    }

    public void Update () {
		// Animacion ardilla
		if(System.currentTimeMillis() - GameGlobals.ultimotiempo >= GameGlobals.changetime && !saliendo && Yardilla > -GameGlobals.A[0].height){
			GameGlobals.ultimotiempo = System.currentTimeMillis();
			i++;
			if(i >= GameGlobals.MAXimages){
				i = 0;
			}
			GameGlobals.A[i].x = Xardilla;
			GameGlobals.A[i].y = Yardilla;
			// El resto aparecen invisibles
			for(j = 0; j < i; j++){
				GameGlobals.A[j].x = this.escena.width();
				GameGlobals.A[j].y = this.escena.height();
			}
			for(j = i+1; j < GameGlobals.MAXimages; j++){
				GameGlobals.A[j].x = this.escena.width();
				GameGlobals.A[j].y = this.escena.height();
			}
		}
		
		// Animacion de la ardilla haciendose llendose
		if(saliendo){
			for(Image img: GameGlobals.A){
				img.y -= img.height/this.tiempoSalida;
				
				if(img.y <= -img.height){
					saliendo = false;
				}
			}
			Yardilla = (int) GameGlobals.A[0].y;
			Xardilla = (int) GameGlobals.A[0].x;
		}
		
		// Se van reproduciendo los takes (uno detras de otro)
		// Si se pulsa escape o en la pantalla (click) se salta el splash
		if(indice >= MAXtakes){
			// La ardilla se va
			saliendo = true;
		}else{
			if(reproducir == true){
				take[indice].play();
				reproducir = false;
			}
			
			if(!take[indice].isPlaying()){
				reproducir = true;
					indice++;
			}
		}
		if(Gdx.input.isTouched() || Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			if(indice < MAXtakes){
				reproducir = false;
				take[indice].stop();
			}
			// La ardilla se va
			saliendo = true;
		}
    	super.Update();
    }
    
    public void Load(){
    	fondo =new Image("fondo",new Texture("imagenes2/mezcla/fondo.png"));
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
		
		// Ardilla
		GameGlobals.ultimotiempo=System.currentTimeMillis();
		// Imagenes de las ardillas hablando
		GameGlobals.A[0].x = GameGlobals.posXardilla;
		GameGlobals.A[0].y = GameGlobals.posYardilla;
		// La 2 y la 3 aparecen inicialmente invisibles
		GameGlobals.A[1].x = this.escena.width();
		GameGlobals.A[1].y = this.escena.height();
		GameGlobals.A[2].x = this.escena.width();
		GameGlobals.A[2].y = this.escena.height();
		this.escena.addActor(GameGlobals.A[0]);
		this.escena.addActor(GameGlobals.A[1]);
		this.escena.addActor(GameGlobals.A[2]);
		// Sonidos de la ardilla hablando
		take[0] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesmezcladecolor/Take 1.wav"));
		take[1] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesmezcladecolor/Take 2.wav"));
		take[2] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesmezcladecolor/Take 3.wav"));
		take[3] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesmezcladecolor/Take 4.wav"));
		take[4] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesmezcladecolor/Take 5.wav"));
		//take[5] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesmezcladecolor/Take 6.wav"));
    	
    }
    
    public static void cambiarColorPincel(float r,float g, float b){
		lienzo.pincel.setColor(r, g, b, 1);
		lienzo.pincel.fillCircle(5, 5, 5);
	}
}


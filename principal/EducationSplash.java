package principal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class EducationSplash extends Screen {
	
	
	private int i = 0;
	private int j = 0;

	private Music[] take = new Music[10];
	int indice = 0;
	int MAXtakes = 10;
	boolean reproducir = true;
	
	// Imagenes de cuentos contorneados
	Image cuento;
	Image modificalo;
	Image museo;
	Image mezcla;
	
	// Imagen del contador
	Image contador;

	@Override
	public void Update(){
		// Animacion ardilla
		if(System.currentTimeMillis() - GameGlobals.ultimotiempo >= GameGlobals.changetime){
			GameGlobals.ultimotiempo = System.currentTimeMillis();
			i++;
			if(i >= GameGlobals.MAXimages){
				i = 0;
			}
			GameGlobals.A[i].x = GameGlobals.posXardilla;
			GameGlobals.A[i].y = GameGlobals.posYardilla;
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
		
		// Se van reproduciendo los takes (uno detras de otro)
		// Si se pulsa escape o en la pantalla (click) se salta el splash
		if(indice >= MAXtakes){
			ScreenManager.getScreenManager().setCurrentScreen("menu");
		}else{
			if(reproducir == true){
				switch(indice){
				case 3:
					contador.scaleX = 1.0f;
					contador.scaleY = 1.0f;
					break;
				case 5:
					cuento.scaleX = 1.2f;
					cuento.scaleY = 1.2f;
					break;
				case 6:
					mezcla.scaleX = 1.2f;
					mezcla.scaleY = 1.2f;
					break;
				case 7:
					modificalo.scaleX = 1.2f;
					modificalo.scaleY = 1.2f;
					break;
				case 8:
					museo.scaleX = 1.2f;
					museo.scaleY = 1.2f;
					break;
				}
				take[indice].play();
				reproducir = false;
			}
			
			if(!take[indice].isPlaying()){
				switch(indice){
				case 3:
					contador.scaleX = 0.00001f;
					contador.scaleY = 0.00001f;
					break;
				case 5:
					cuento.scaleX = 0.00001f;
					cuento.scaleY = 0.00001f;
					break;
				case 6:
					mezcla.scaleX = 0.00001f;
					mezcla.scaleY = 0.00001f;
					break;
				case 7:
					modificalo.scaleX = 0.00001f;
					modificalo.scaleY = 0.00001f;
					break;
				case 8:
					museo.scaleX = 0.00001f;
					museo.scaleY = 0.00001f;
					break;
				}
				reproducir = true;
				indice++;
			}
		}
		if(Gdx.input.isTouched() || Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			ScreenManager.getScreenManager().setCurrentScreen("menu");
			take[indice].stop();
		}
	}
	
	@Override
	public void Initialize(){
		super.Initialize();
		
		Image i = new Image("img",new TextureRegion(new Texture("imagenes2/splash/esplash.png"), 0, 0, 1024, 600));
		this.escena.addActor(i);
		GameGlobals.ultimotiempo=System.currentTimeMillis();
		
		// Imagenes de las ardillas hablando
		this.escena.addActor(GameGlobals.A[0]);
		this.escena.addActor(GameGlobals.A[1]);
		this.escena.addActor(GameGlobals.A[2]);
		
		GameGlobals.A[0].x = GameGlobals.posXardilla;
		GameGlobals.A[0].y = GameGlobals.posYardilla;
		// La 2 y la 3 aparecen inicialmente invisibles
		GameGlobals.A[1].x = this.escena.width();
		GameGlobals.A[1].y = this.escena.height();
		GameGlobals.A[2].x = this.escena.width();
		GameGlobals.A[2].y = this.escena.height();
		
		// Sonidos de la ardilla hablando
		take[0] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesdelinicio/Take 1.wav"));
		take[1] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesdelinicio/Take 2.wav"));
		take[2] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesdelinicio/Take 3.wav"));
		take[3] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesdelinicio/Take 4.wav"));
		take[4] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesdelinicio/Take 5.wav"));
		take[5] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesdelinicio/Take 6.wav"));
		take[6] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesdelinicio/Take 7.wav"));
		take[7] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesdelinicio/Take 8.wav"));
		take[8] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesdelinicio/Take 9.wav"));
		take[9] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesdelinicio/Take 10.wav"));
		
		// Imagenes de los juegos contorneadas de amarillo
		museo = new Image("museo",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 876, 736, 1015-876, 960-736));
		this.escena.addActor(museo);
		museo.x=780;
		museo.y=373;
		museo.scaleX = 0.00001f;
		museo.scaleY = 0.00001f;
		modificalo = new Image("modificalo",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 207, 751, 443-207, 1020-751));
		this.escena.addActor(modificalo);
		modificalo.x=307;
		modificalo.y=-9;
		modificalo.scaleX = 0.00001f;
		modificalo.scaleY = 0.00001f;
		cuento = new Image("cuento",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 31, 567, 226-31, 757-567));
		this.escena.addActor(cuento);
		cuento.x=37;
		cuento.y=184;
		cuento.scaleX = 0.00001f;
		cuento.scaleY = 0.00001f;
		mezcla = new Image("mezcla",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 455, 602, 623-455, 802-602));
		this.escena.addActor(mezcla);
		mezcla.x=370;
		mezcla.y=397;
		mezcla.scaleX = 0.00001f;
		mezcla.scaleY = 0.00001f;
		
		// Imagen del contador
		contador = new Image("contador",new TextureRegion(new Texture("imagenes2/Menu/contadorresaltado.png")));
		this.escena.addActor(contador);
		contador.x = this.escena.width() - contador.width - 4;
		contador.y = this.escena.height() - contador.height-1;
		contador.scaleX = 0.00001f;
		contador.scaleY = 0.00001f;
	}
	
	
}

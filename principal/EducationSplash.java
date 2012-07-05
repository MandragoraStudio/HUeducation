package principal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class EducationSplash extends Screen {
	
	private long ultimotiempo=0;
	private long changetime=200;
	private int i = 0;
	private int j = 0;
	
	// Ardilla Hablando
	private Image[] A = new Image[3];	
	private int MAXimages = 3;
	private int posX = 0;
	private int posY = 0;

	private Music[] take = new Music[3];
	int indice = 0;
	int MAXtakes = 3;
	boolean reproducir = true;
	

	@Override
	public void Update(){
		// Animacion ardilla
		if(System.currentTimeMillis() - ultimotiempo >= changetime){
			ultimotiempo = System.currentTimeMillis();
			i++;
			if(i >= MAXimages){
				i = 0;
			}
			A[i].x = posX;
			A[i].y = posY;
			// El resto aparecen invisibles
			for(j = 0; j < i; j++){
				A[j].x = this.escena.width();
				A[j].y = this.escena.height();
			}
			for(j = i+1; j < MAXimages; j++){
				A[j].x = this.escena.width();
				A[j].y = this.escena.height();
			}
		}
		
		// Se van reproduciendo los takes (uno detras de otro)
		// Si se pulsa escape o en la pantalla (click) se salta el splash
		if(indice >= MAXtakes){
			ScreenManager.getScreenManager().setCurrentScreen("menu");
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
			ScreenManager.getScreenManager().setCurrentScreen("menu");
			take[indice].stop();
		}
	}
	
	@Override
	public void Initialize(){
		super.Initialize();
		
		Image i = new Image("img",new TextureRegion(new Texture("imagenes2/splash/esplash.png"), 0, 0, 1024, 600));
		this.escena.addActor(i);
		ultimotiempo=System.currentTimeMillis();
		
		// Imagenes de las ardillas hablando
		A[0] = new Image("mandrilla1",new TextureRegion(new Texture("imagenes2/ardilla/hablando/mandrilla1.png")));
		this.escena.addActor(A[0]);
		A[1] = new Image("mandrilla2",new TextureRegion(new Texture("imagenes2/ardilla/hablando/mandrilla2.png")));
		this.escena.addActor(A[1]);
		A[2] = new Image("mandrilla3",new TextureRegion(new Texture("imagenes2/ardilla/hablando/mandrilla3.png")));
		this.escena.addActor(A[2]);
		A[0].x = posX;
		A[0].y = posY;
		// La 2 y la 3 aparecen inicialmente invisibles
		A[1].x = this.escena.width();
		A[1].y = this.escena.height();
		A[2].x = this.escena.width();
		A[2].y = this.escena.height();
		
		// Sonidos de la ardilla hablando
		take[0] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesdelinicio/Take 1.wav"));
		take[1] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesdelinicio/Take 2.wav"));
		take[2] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesdelinicio/Take 3.wav"));
	}
	
	
}

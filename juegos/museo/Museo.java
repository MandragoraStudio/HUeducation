package juegos.museo;

import java.io.File;
import java.util.ArrayList;

import principal.GameGlobals;
import principal.ScreenManager;
import juegos.Juego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.MoveTo;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class Museo extends Juego {

	private Image fondo;
	private Button izquierda;
	private Button derecha;
	private TextureRegion marcoChico;
	private Button marcoGrande;
	private Button BAtras;
	private float factorDeReduccionX;
	private float factorDeReduccionY;
	private float cuadro1Pos = 120;
	private float cuadro2Pos = 530;
	
	private ArrayList<Cuadro> cuadros;
	int contador = 0;
	
	// Ardilla
	private int i = 0;
	private int j = 0;

	private Music[] take = new Music[2];
	int indice = 0;
	int MAXtakes = 2;
	int Xardilla = GameGlobals.posXardilla;
	int Yardilla = GameGlobals.posYardilla;
	
	private long tiempoSalida = 700;
	private boolean saliendo = false;
	
	boolean reproducir = true;

	public Museo() {
		super();

	}
	
	@Override
	public void Load() {
	}

	@Override
	public void Initialize() {
		super.Initialize();
		
		// Imagen de fondo
		fondo = new Image("fondo", new TextureRegion(new Texture(
		"imagenes2/museo/TexturesMuseo.png"), 0, 0, 1024, 600));
		this.escena.addActor(fondo);
		
		// Boton derecha
		derecha = new Button("derecha", new TextureRegion(new Texture(
		"imagenes2/museo/TexturesMuseo.png"), 0, 600, 101, 110));
		derecha.x = 1024 - 10 - this.derecha.width;
		derecha.y = 270;
		this.escena.addActor(derecha);
		derecha.clickListener = new ClickListener() {		
			public void clicked(Button arg0) {
				if(cuadros.size() != 0){
					if(cuadros.get(cuadros.size() - 1).getMarco().x != (cuadros.size()%2 == 0? cuadro2Pos:cuadro1Pos)){
						if(System.currentTimeMillis() - GameGlobals.pressTime >= 2000){
							for(Cuadro cuadro:cuadros){
								if(cuadro.isAmpliado()){
									cuadro.reducir();
								}
								cuadro.setXreducida(cuadro.getCuadro().x + 1024);
								cuadro.getCuadro().action(MoveTo.$(cuadro.getCuadro().x - 1024, cuadro.getCuadro().y, 2));
								cuadro.getMarco().action(MoveTo.$(cuadro.getMarco().x - 1024, cuadro.getMarco().y, 2));						
							}
							GameGlobals.pressTime = System.currentTimeMillis();
						}
					}
				}
			}
		};
		
		
		// Boton izquierda
		izquierda = new Button("izquierda", new TextureRegion(new Texture(
				"imagenes2/museo/TexturesMuseo.png"), 101, 600, 98, 110));
		izquierda.x = 10;
		izquierda.y = 270;
		this.escena.addActor(izquierda);
		izquierda.clickListener = new ClickListener() {		
			public void clicked(Button arg0) {
				if(cuadros.size() != 0){
					if(cuadros.get(0).getMarco().x != cuadro1Pos){
						if(System.currentTimeMillis() - GameGlobals.pressTime >= 2000){
							for(Cuadro cuadro:cuadros){
								if(cuadro.isAmpliado()){
									cuadro.reducir();
								}	
								cuadro.setXreducida(cuadro.getCuadro().x + 1024);
								cuadro.getCuadro().action(MoveTo.$(cuadro.getCuadro().x + 1024, cuadro.getCuadro().y, 2));
								cuadro.getMarco().action(MoveTo.$(cuadro.getMarco().x + 1024, cuadro.getMarco().y, 2));
							}
							GameGlobals.pressTime = System.currentTimeMillis();
						}
					}
				}
			}
		};
		
		// Marco de las imagenes grande
		marcoGrande = new Button("marcoGrande",new TextureRegion(new Texture("imagenes2/museo/TexturesMuseo2.png"), 0, 0, 803, 538));
		marcoGrande.x = 115;
		marcoGrande.y = 30;
		marcoGrande.touchable = false;
		
		// Marco de las imagenes chico
		marcoChico = new TextureRegion(new Texture("imagenes2/museo/TexturesMuseo.png"), 199, 600, 371, 285);
		// Factor de reduccion
		// Esta variable se usa para escalar los cuadros al mostrarlos pequeños
		factorDeReduccionX = marcoChico.getRegionWidth()/marcoGrande.width;
		factorDeReduccionY = marcoChico.getRegionHeight()/marcoGrande.height;
		
		// Se cargan los cuadros
		cuadros = new ArrayList<Cuadro>();
		this.cargarCuadros();	// Carga y posiciona los cuadros
		
		// Se añade a la escena el marco chico y el cuadro
		for(Cuadro cuadro:cuadros){
			
			this.escena.addActor(cuadro.getMarco());
			this.escena.addActor(cuadro.getCuadro());	
		}
		
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
		take[0] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesMuseo/Take 1.wav"));
		take[1] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesMuseo/Take 2.wav"));
	}

	public void Update() {
		
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
	
	public void cargarCuadros(){
		FileHandle carpeta = Gdx.files.external("/campamentomandrilla/cuadros");
		int i = 0;
		Button boton;
		
		for(FileHandle c: carpeta.list()){
			boton = new Button("cuadro" + Integer.toString(i), 
					new TextureRegion(new Texture(c), 0, 0, 737, 484));
			
				cuadros.add(new Cuadro(boton, marcoChico,(i%2 == 0? this.cuadro1Pos: this.cuadro2Pos) + GameGlobals.ScreenWidth*(i/2), 170, this.factorDeReduccionX, this.factorDeReduccionY));
				i++;
		}
		if(i>=5){
			GameGlobals.MuseoFinished = true;
		}
	}
	
	public void mostrarMarcoGrande(){
		this.escena.addActor(marcoGrande);
	}
	
	public void ocultarMarcoGrande(){
		this.escena.removeActor(marcoGrande);
	}

	public Button getMarcoGrande() {
		return marcoGrande;
	}

	public void setMarcoGrande(Button marcoGrande) {
		this.marcoGrande = marcoGrande;
	}
	
	

}

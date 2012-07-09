package juegos.Cuento;

import java.util.LinkedList;
import java.util.List;

import juegos.Juego;
import principal.GameGlobals;
import principal.ScreenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class CuentoClasico extends Juego {

	private Button abrirCuento; //botón portada
	//Sistema de control de páginas similar al del control de Screens
	public static List<Pagina> paginas;
	public static Pagina paginaActual;

	private Image fondo;
	private Image fondoCuento;
	private Button BAtras;

	public CuentoClasico() {
		this.paginas = new LinkedList();
	}
	
	// Ardilla
	private int i = 0;
	private int j = 0;

	private Music[] take = new Music[3];
	int indice = 0;
	int MAXtakes = 3;
	int Xardilla = GameGlobals.posXardilla;
	int Yardilla = GameGlobals.posYardilla;
	
	private long tiempoSalida = 700;
	private boolean saliendo = false;
	
	boolean reproducir = true;

	@Override
	public void Initialize() {
		super.Initialize();
		fondo = new Image("fondoCuento",new TextureRegion(new Texture("imagenes2/cuento/fondoCuento.png"), 
				0, 0, 1024, 600));
		this.escena.addActor(this.fondo);
		setButtons();
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
		take[0] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/Take 1.wav"));
		take[1] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/Take 2.wav"));
		take[2] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/Take 3.wav"));		
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
				/*if(indice == 2){
					escena.removeActor(abrirCuento);
					escena.getRoot().addActorBefore(GameGlobals.A[0], fondoCuento);
					dibujaPagina();
				}*/
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

	@Override
	public void Load() {
		//fondo del cuento
		this.fondoCuento=new Image("fondoCuento",new TextureRegion(new Texture("imagenes2/cuento/Cuento.png"), 
				0, 0, 960, 600));
		//aqui van todas las páginas del cuento.

		//página 1
		paginas.add(new Pagina(0, "B", new Image("hoja1", new TextureRegion(
				new Texture("imagenes2/cuento/TextureCuento1.png"), 0, 0, 340,
				500)), new TextureRegion(new Texture(
				"imagenes2/cuento/TextureCuento1.png"), 0, 525, 150, 500),
				new TextureRegion(new Texture(
						"imagenes2/cuento/TextureCuento1.png"), 205, 525, 150,
						500), this, Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/pag1/take1.wav")),
						Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/pag1/take2.wav")),
						Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/pag1/take3.wav"))));

		//página 2
		paginas.add(new Pagina(1, "A", new Image("hoja2", new TextureRegion(
				new Texture("imagenes2/cuento/TextureCuento1.png"), 440, 0,
				360, 530)), new TextureRegion(new Texture(
				"imagenes2/cuento/TextureCuento1.png"), 490, 575, 150, 365),
				new TextureRegion(new Texture(
						"imagenes2/cuento/TextureCuento1.png"), 635, 575, 150,
						365), this, Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/pag2/take1.wav")),
						Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/pag2/take2.wav")),
						Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/pag2/take3.wav"))));
		

		//página 3
		paginas.add(new Pagina(2, "A", new Image("hoja3", new TextureRegion(
				new Texture("imagenes2/cuento/TextureCuento3.png"), 15, 20,
				365, 540)), new TextureRegion(new Texture(
				"imagenes2/cuento/TextureCuento3.png"), 40, 580, 150, 365),
				new TextureRegion(new Texture(
						"imagenes2/cuento/TextureCuento3.png"), 220, 580, 150,
						365), this, Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/pag3/take1.wav")),
						Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/pag3/take2.wav")),
						Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/pag3/take3.wav"))));

		//página 4
		paginas.add(new Pagina(3, "A", new Image("hoja4", new TextureRegion(
				new Texture("imagenes2/cuento/TextureCuento3.png"), 440, 15,
				365, 540)), new TextureRegion(new Texture(
				"imagenes2/cuento/TextureCuento3.png"), 465, 575, 150, 365),
				new TextureRegion(new Texture(
						"imagenes2/cuento/TextureCuento3.png"), 365, 575, 150,
						365), this, Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/pag4/take1.wav")),
						Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/pag4/take2.wav")),
						Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/pag4/take3.wav"))));

		//página 5
		paginas.add(new Pagina(4, "B", new Image("hoja5", new TextureRegion(
				new Texture("imagenes2/cuento/TextureCuento3.png"), 0, 0,
				735, 525)), new TextureRegion(new Texture(
				"imagenes2/cuento/TextureCuento3.png"), 0, 0, 0, 0),
				new TextureRegion(new Texture(
						"imagenes2/cuento/TextureCuento3.png"), 0, 0, 0,
						0), this, Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/pag5/take1.wav")),
						Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/pag5/take2.wav")),
						Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takescuentacuentos/pag5/take3.wav"))));


		//se inicializa la página primera
		paginaActual = paginas.get(0);
	}

	private void setButtons() {
		//creo el boton a abrir cuento (portada) y lo coloco
		abrirCuento = new Button("abrirCuento", new TextureRegion(new Texture(
				"imagenes2/cuento/cerrado.png"), 0, 0, 1024, 600));
		this.escena.addActor(abrirCuento);
		abrirCuento.clickListener = new ClickListener() {

			public void clicked(Button arg0) {
				escena.removeActor(abrirCuento);
				escena.addActor(fondoCuento);
				dibujaPagina();
			}
		};
		
		// Boton atras
		BAtras = new Button("salir",new TextureRegion(new Texture("imagenes2/Menu/atras sin pulsar.png")),new TextureRegion(new Texture("imagenes2/Menu/atras pulsado.png")));
		BAtras.x = this.escena.width() - BAtras.width;
		BAtras.y = this.escena.height() - BAtras.height -20;
		this.escena.addActor(BAtras);
		BAtras.clickListener=new ClickListener(){
			public void clicked(Button b){
				ScreenManager.getScreenManager().setCurrentScreen("menu");
			}
		};
	}

	// meto la pagina nueva
	public void dibujaPagina() {
		this.escena.addActor(paginaActual.getOpcA());
		this.escena.addActor(paginaActual.getOpcB());
		this.escena.addActor(paginaActual.getHoja());
	}

	// elimina una pagina, se supone que se borra de la memoria al salir de la
	// escena
	public void eliminaPagina() {
		this.escena.removeActor(paginaActual.getOpcA());
		this.escena.removeActor(paginaActual.getOpcB());
		this.escena.removeActor(paginaActual.getHoja());
	}

	// pasa pagina hasta que llega a la última
	public void siguientePagina() {
		if (paginas.size() - 1 > paginaActual.getNumPPag()) {
			/*TODO: meter sonido según la página en la que 			estemos*/
			paginaActual = paginas.get(paginaActual.getNumPPag() + 1);
			eliminaPagina();
			dibujaPagina();
		} else {
			
			GameGlobals.cuentoFinished=true;
			ScreenManager.getScreenManager().setCurrentScreen("menu");
		}
	}
}
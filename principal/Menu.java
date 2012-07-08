package principal;


import juegos.Juego;
import juegos.Cuento.CuentoClasico;
import juegos.emocionesPintadas.EmocionesPintadas;
import juegos.mezcla.MezclaColores;
import juegos.modificalo.SeleccionCuadro;
import juegos.museo.Museo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;
import com.badlogic.gdx.scenes.scene2d.actors.Label;


public class Menu extends Screen {

	Button BCuento;
	Button BPintar;
	Button BMezcla;
	Button BModifica;
	Button BMuseo;
	//Button BSalir;
	Image fondo;
	
	// Nueces
	Image contador;
	Label Lnueces;
	private BitmapFont font;
	
	private long ultimavez=0;
	private long ardillatime=30000;
	private boolean reproducir = true;
	private int i = 0;
	private int j = 0;
	Music takeR;
	
	@Override
	public void Initialize(){
		super.Initialize();
		fondo = new Image("fondo", new TextureRegion(new Texture("imagenes2/Menu/fondoMenu.png"), 0, 0, 1024, 600));
		this.escena.addActor(fondo);
		ultimavez=System.currentTimeMillis();
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
		takeR = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesdelinicio/Take R.wav"));
		setButtons();
		// Imagen del contador
		contador = new Image("contador", new TextureRegion(new Texture("imagenes2/Menu/contador.png")));
		this.escena.addActor(contador);
		contador.x = this.escena.width() - contador.width;
		contador.y = this.escena.height() - contador.height;
		font = new BitmapFont(Gdx.files.internal("fuentes/fuente.fnt"), false);
		Lnueces = new Label("nueces", font);
		Lnueces.setText(Integer.toString(GameGlobals.nueces));
		Lnueces.x = contador.x+20;
		Lnueces.y = contador.y+20;
		this.escena.addActor(Lnueces);
	}
	
	private void setButtons(){

		if(GameGlobals.cuentoFinished){
		BCuento = new Button("bcuento",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 24, 0, 213-24, 185), new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 36, 370, 231-36, 559-370));
		}else{
			BCuento = new Button("bcuento",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 36, 187, 224-36, 369-187), new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 31, 567, 226-31, 757-567));
			
		}BCuento.x=37;
		BCuento.y=184;
		this.escena.addActor(BCuento);
		BCuento.clickListener=new ClickListener(){
			public void clicked(Button b){
				JuegoCuento();
			}
		};
		
		/*if(GameGlobals.emocionesFinished){
			BPintar= new Button("bpintar",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 226, 10, 437-226, 180-10), new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 235, 379, 438-235, 549-379));
		}else{
			BPintar= new Button("bpintar",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 232, 192, 442-232, 363-192), new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 228, 569, 430-228, 738-569));
			
		}BPintar.x=649;
		BPintar.y=149;
		this.escena.addActor(BPintar);
		BPintar.clickListener=new ClickListener(){
			public void clicked(Button b){
				JuegoPintar();
			}
		};*/
		
		if(GameGlobals.mezclaFinished){
			BMezcla=new Button("bmezcla",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 459, 1, 628-459, 199-1), new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 460, 400, 623-460, 600-400));
		}else{
			BMezcla=new Button("bmezcla",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 456, 198, 630-456, 400-198),new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 455, 602, 623-455, 802-602));
			
		}
		BMezcla.x=358;
		BMezcla.y=397;
		this.escena.addActor(BMezcla);
		BMezcla.clickListener=new ClickListener(){
			public void clicked(Button b){
				JuegoMezcla();
			}
		};
		if(GameGlobals.ModificaFinished){
			BModifica=new Button("bmodifica",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 634, 11, 871-634, 284-11),new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 636, 566, 868-636, 837-566));
		}else{
			BModifica=new Button("bmodifica",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 644, 286, 880-644, 557-286),new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 207, 751, 443-207, 1020-751));
			
		}
		BModifica.x=307;
		BModifica.y=-9;
		this.escena.addActor(BModifica);
		BModifica.clickListener=new ClickListener(){
			public void clicked(Button b){
				SeleccionCuadro();
			}
		};
		
		if(GameGlobals.MuseoFinished){
		BMuseo=new Button("bmuseo",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 872, 8, 1007-872, 231-8),new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 880, 481, 1015-880, 706-481));
		}else{
			BMuseo=new Button("bmuseo",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 880, 230, 1012-880, 454-230),new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 876, 736, 1015-876, 960-736));
				
		}
		
		BMuseo.x=780;
		BMuseo.y=373;
		this.escena.addActor(BMuseo);
		BMuseo.clickListener=new ClickListener(){
			public void clicked(Button b){
				JuegoMuseo();
			}
		};
		
		/*BSalir = new Button("salir",new TextureRegion(new Texture("imagenes2/Menu/atras sin pulsar.png")),new TextureRegion(new Texture("imagenes2/Menu/atras pulsado.png")));
		BSalir.x = 0;
		BSalir.y = 0;
		this.escena.addActor(BSalir);
		BSalir.clickListener=new ClickListener(){
			public void clicked(Button b){
				Salir();
			}
		};*/
		
	}
	
	private void Salir(){
		Game.salir();
	}
	private void JuegoCuento(){
		inicializaJuego("cuentoClasico", new CuentoClasico());
	}
	/*private void JuegoPintar(){
		inicializaJuego("emocionesPintadas", new EmocionesPintadas());
	}*/
	private void JuegoMezcla(){
		inicializaJuego("mezclaColores", new MezclaColores());
	}
	private void SeleccionCuadro(){
		inicializaJuego("selecccionCuadro", new SeleccionCuadro());
	}
	private void JuegoMuseo(){
		inicializaJuego("museo", new Museo());
	}
    public void Update () {
    	if(System.currentTimeMillis() - ultimavez >= ardillatime){
    		if(reproducir){
    			takeR.play();
    			reproducir = false;
    			
    		}

    		// mientras la ardilla hable se reproduce la animacion
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
    		
    		// Cuando deja de hablar se para la animacion y se guarda el momento en el que esto sucede
    		if(!takeR.isPlaying()){
    			ultimavez = System.currentTimeMillis();
    			reproducir = true;
    			// La ardilla se deja = k al principio
    			GameGlobals.A[0].x = GameGlobals.posXardilla;
    			GameGlobals.A[0].y = GameGlobals.posYardilla;
    			// La 2 y la 3 aparecen inicialmente invisibles
    			GameGlobals.A[1].x = this.escena.width();
    			GameGlobals.A[1].y = this.escena.height();
    			GameGlobals.A[2].x = this.escena.width();
    			GameGlobals.A[2].y = this.escena.height();
    		}
    	}
    	super.Update();
    }
    @Override
    public boolean keyDown(int arg0) {
    	if(arg0== Input.Keys.BACK){
    		System.exit(0);
    	}
		return false;
	}
    private void inicializaJuego (String name, Juego j) {
    	ScreenManager.getScreenManager().addScreen(name, j);
    	ScreenManager.getScreenManager().setCurrentScreen(name);
    }

}

package principal;


import juegos.Juego;
import juegos.Cuento.CuentoClasico;
import juegos.emocionesPintadas.EmocionesPintadas;
import juegos.mezcla.MezclaColores;
import juegos.modificalo.SeleccionCuadro;
import juegos.museo.Museo;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;


public class Menu extends Screen {

	Button BCuento;
	Button BPintar;
	Button BMezcla;
	Button BModifica;
	Button BMuseo;
	//Button BSalir;
	Image fondo;
	
	@Override
	public void Initialize(){
		super.Initialize();
		fondo = new Image("fondo", new TextureRegion(new Texture("imagenes2/Menu/fondoMenu.png"), 0, 0, 1024, 600));
		this.escena.addActor(fondo);
		setButtons();
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

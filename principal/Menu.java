package principal;


import juegos.Juego;
import juegos.Cuento.CuentoClasico;
import juegos.emocionesPintadas.EmocionesPintadas;
import juegos.mezcla.MezclaColores;
import juegos.modificalo.Modificalo;
import juegos.modificalo.SeleccionCuadro;
import juegos.museo.Museo;

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
	Image fondo;
	@Override
	public void Initialize(){
		super.Initialize();
		fondo = new Image("fondo", new TextureRegion(new Texture("imagenes2/Menu/fondoMenu.png"), 0, 0, 1024, 600));
    	this.escena.addActor(fondo);
		setButtons();
	}
	
	private void setButtons(){

		
		BCuento = new Button("bcuento",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 24, 0, 213-24, 185));
		BCuento.x=37;
		BCuento.y=184;
		this.escena.addActor(BCuento);
		BCuento.clickListener=new ClickListener(){
			public void clicked(Button b){
				JuegoCuento();
			}
		};
		BPintar= new Button("bpintar",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 226, 10, 437-226, 180-10));
		BPintar.x=649;
		BPintar.y=149;
		this.escena.addActor(BPintar);
		BPintar.clickListener=new ClickListener(){
			public void clicked(Button b){
				JuegoPintar();
			}
		};
		BMezcla=new Button("bmezcla",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 459, 1, 628-459, 199-1));
		BMezcla.x=358;
		BMezcla.y=397;
		this.escena.addActor(BMezcla);
		BMezcla.clickListener=new ClickListener(){
			public void clicked(Button b){
				JuegoMezcla();
			}
		};
		BModifica=new Button("bmodifica",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 634, 11, 871-634, 284-11));
		BModifica.x=307;
		BModifica.y=-9;
		this.escena.addActor(BModifica);
		BModifica.clickListener=new ClickListener(){
			public void clicked(Button b){
				SeleccionCuadro();
			}
		};
		
		BMuseo=new Button("bmuseo",new TextureRegion(new Texture("imagenes2/Menu/TexturesBotonesMenu.png"), 872, 8, 1007-872, 231-8));
		BMuseo.x=780;
		BMuseo.y=373;
		this.escena.addActor(BMuseo);
		BMuseo.clickListener=new ClickListener(){
			public void clicked(Button b){
				JuegoMuseo();
			}
		};
		
	}
	
	private void Salir(){
		Game.salir();
	}
	private void JuegoCuento(){
		inicializaJuego(new CuentoClasico());
	}
	private void JuegoPintar(){
		inicializaJuego(new EmocionesPintadas());
	}
	private void JuegoMezcla(){
		inicializaJuego(new MezclaColores());
	}
	private void SeleccionCuadro(){
		inicializaJuego(new SeleccionCuadro());
	}
	private void JuegoMuseo(){
		inicializaJuego(new Museo());
	}
    public void Update () {
    	super.Update();
    }

    private void inicializaJuego (Juego j) {
    	ScreenManager.getScreenManager().addScreen("juego", j);
    	ScreenManager.getScreenManager().setCurrentScreen("juego");
    }

}


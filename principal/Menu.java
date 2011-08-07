package principal;


import juegos.Juego;
import juegos.Modificalo;
import juegos.Cuento.CuentoClasico;
import juegos.emocionesPintadas.EmocionesPintadas;
import juegos.mezcla.MezclaColores;
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
		fondo = new Image("fondo", new TextureRegion(new Texture("imagenes2/fondoMenu.png"), 0, 0, 1024, 600));
    	this.escena.addActor(fondo);
		setButtons();
	}
	
	private void setButtons(){

		BCuento = new Button("bcuento",new TextureRegion(new Texture("imagenes2/botonescolor/botonescolor.png"), 0, 0, 200, 200));
		BCuento.x=30;
		BCuento.y=175;
		this.escena.addActor(BCuento);
		BCuento.clickListener=new ClickListener(){
			public void clicked(Button b){
				JuegoCuento();
			}
		};
		BPintar= new Button("bpintar",new TextureRegion(new Texture("imagenes2/botonescolor/botonescolor.png"), 200, 0, 230, 185));
		BPintar.x=640;
		BPintar.y=140;
		this.escena.addActor(BPintar);
		BPintar.clickListener=new ClickListener(){
			public void clicked(Button b){
				JuegoPintar();
			}
		};
		BMezcla=new Button("bmezcla",new TextureRegion(new Texture("imagenes2/botonescolor/botonescolor.png"), 430, 0, 185, 200));
		BMezcla.x=349;
		BMezcla.y=391;
		this.escena.addActor(BMezcla);
		BMezcla.clickListener=new ClickListener(){
			public void clicked(Button b){
				JuegoMezcla();
			}
		};
		BModifica=new Button("bmodifica",new TextureRegion(new Texture("imagenes2/botonescolor/botonescolor.png"), 615, 0, 240, 280));
		BModifica.x=307;
		BModifica.y=-5;
		this.escena.addActor(BModifica);
		BModifica.clickListener=new ClickListener(){
			public void clicked(Button b){
				JuegoModifica();
			}
		};
		
		BMuseo=new Button("bmuseo",new TextureRegion(new Texture("imagenes2/botonescolor/botonescolor.png"), 855, 0, 135, 230));
		BMuseo.x=780;
		BMuseo.y=370;
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
	private void JuegoModifica(){
		inicializaJuego(new Modificalo());
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


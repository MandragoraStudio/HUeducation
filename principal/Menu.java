package principal;

import juegos.EmocionesPintadas;
import juegos.Juego;
import juegos.MezclaColores;
import juegos.Modificalo;
import juegos.Cuento.CuentoClasico;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;


public class Menu extends Screen {

	Button salir;
	Button BCuento;
	Button BPintar;
	Button BMezcla;
	Button BModifica;
	@Override
	public void Initialize(){
		super.Initialize();
		setButtons();
	}
	
	private void setButtons(){
		salir = new Button("salir",new Texture("imagenes/salir.png"));
		this.escena.addActor(salir);
		salir.clickListener=new ClickListener(){

			public void clicked(Button arg0) {
				Salir();
			}
			
		};
		BCuento = new Button("bcuento",new Texture("imagenes/cuento.png"));
		BCuento.y=300;
		this.escena.addActor(BCuento);
		BCuento.clickListener=new ClickListener(){
			public void clicked(Button b){
				JuegoCuento();
			}
		};
		BPintar= new Button("bpintar",new Texture("imagenes/pintar.png"));
		BPintar.x=250;
		BPintar.y=300;
		this.escena.addActor(BPintar);
		BPintar.clickListener=new ClickListener(){
			public void clicked(Button b){
				JuegoPintar();
			}
		};
		BMezcla=new Button("bmezcla",new Texture("imagenes/mezcla.png"));
		BMezcla.x=500;
		BMezcla.y=300;
		this.escena.addActor(BMezcla);
		BMezcla.clickListener=new ClickListener(){
			public void clicked(Button b){
				JuegoMezcla();
			}
		};
		BModifica=new Button("bmodifica",new Texture("imagenes/modificalo.png"));
		BModifica.x=400;
		BModifica.y=100;
		this.escena.addActor(BModifica);
		BModifica.clickListener=new ClickListener(){
			public void clicked(Button b){
				JuegoModifica();
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
	
 
    public void Update () {
    	super.Update();
    }

    private void inicializaJuego (Juego j) {
    	ScreenManager.getScreenManager().addScreen("juego", j);
    	ScreenManager.getScreenManager().setCurrentScreen("juego");
    }

}


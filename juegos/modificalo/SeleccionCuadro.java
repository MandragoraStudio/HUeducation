package juegos.modificalo;

import principal.ScreenManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;

import juegos.Juego;

public class SeleccionCuadro extends Juego{
	
	Button p1;
	Button p2;
	
	@Override
	public void Load(){
		p1 = new Button("btn1",new Texture("imagenes/modificalo/gio.png"));
		p1.clickListener=new ClickListener(){
			public void clicked(Button arg0) {	
				inicializaJuego(new Modificalo(1));
			}
		};
		p2 = new Button("btn2",new Texture("imagenes/modificalo/mano.jpg"));
		p2.clickListener=new ClickListener(){
			public void clicked(Button arg0) {	
				inicializaJuego(new Modificalo(2));
			}
		};		
	}
	 
	public SeleccionCuadro () {
	   	super();
	}
		 
	public void Update () {
		super.Update(); 
	}
		   
	@Override
	public void Initialize(){
		super.Initialize();
		
		p1.x = 0;
		p1.y = 140;
		
		p2.x = 300;
		p2.y = 140;
		
		this.escena.addActor(p1);
		this.escena.addActor(p2);
	}
	
	 private void inicializaJuego (Juego j) {
	    	ScreenManager.getScreenManager().addScreen("juego", j);
	    	ScreenManager.getScreenManager().setCurrentScreen("juego");
	    }

}

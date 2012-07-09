package juegos.modificalo;

import principal.ScreenManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Image;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;

import juegos.Juego;

public class SeleccionCuadro extends Juego{
	
	Image fondo;
	Button p1;
	Button p2;
	
	@Override
	public void Load(){
		fondo = new Image("fondo",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro3.png"),0,0,1024,600));
		p1 = new Button("btn1",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),0,0,318,484));
		p1.clickListener=new ClickListener(){
			public void clicked(Button arg0) {	
				inicializaJuego(new Modificalo(1));
			}
		};
		p2 = new Button("btn2",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),318,0,318,484));
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
		
		p1.x = 150;
		p1.y = 60;
		
		p2.x = 550;
		p2.y = 60;
		this.escena.addActor(fondo);
		this.escena.addActor(p1);
		this.escena.addActor(p2);
	}
	
	 private void inicializaJuego (Juego j) {
	    	ScreenManager.getScreenManager().addScreen("juego", j);
	    	ScreenManager.getScreenManager().setCurrentScreen("juego");
	    }

}

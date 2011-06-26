package principal;

import juegos.Juego;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Button;


public class Menu extends Screen {


	@Override
	public void Initialize(){
		super.Initialize();
		Button b = new Button("Salir",new Texture("imagenes/salir.png"));
		this.escena.addActor(b);
	}
	
 
    public void Update () {
    	
    }

    private void inicializaJuego (Juego j) {
    	
    }

}


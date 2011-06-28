package principal;

import juegos.Juego;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;


public class Menu extends Screen {

	Button salir;
	@Override
	public void Initialize(){
		super.Initialize();
		salir = new Button("salir",new Texture("imagenes/salir.png"));
		this.escena.addActor(salir);
		salir.clickListener=new ClickListener(){

			public void clicked(Button arg0) {
				salir.x+=10;
			}
			
		};
		salir.touchable=true;
	}
	
 
    public void Update () {
    	super.Update();
    }

    private void inicializaJuego (Juego j) {
    	
    }

}


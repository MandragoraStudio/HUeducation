package principal;

import juegos.Juego;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Button;


public class Menu extends Screen {

	Button salir;
	@Override
	public void Initialize(){
		super.Initialize();
		salir = new Button("salir",new Texture("imagenes/salir.png"));
		this.escena.addActor(salir);
	}
	
 
    public void Update () {
    	salir.rotation+=0.001;
    	salir.touchable=true;
    	salir.originY+=0.01;
    	
    	if(salir.pressed){
    		System.out.print("salir pulsado");
    	}
    }

    private void inicializaJuego (Juego j) {
    	
    }

}


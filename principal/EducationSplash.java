package principal;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class EducationSplash extends Screen {
	
	private boolean terminado = false;

	private long tiempoini=0;
	private long tiempoEspera=3000;

	@Override
	public void Update(){
		terminado=true;
		
		if(terminado){
			if(System.currentTimeMillis()-tiempoini>tiempoEspera)
			ScreenManager.getScreenManager().setCurrentScreen("menu");
		}
	}
	
	@Override
	public void Initialize(){
		super.Initialize();
		Image i = new Image("img",new Texture("imagenes/esplash.png"));
		this.escena.addActor(i);
		tiempoini=System.currentTimeMillis();
	}
	
	
}

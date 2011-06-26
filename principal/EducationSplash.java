package principal;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class EducationSplash extends Screen {
	
	
	
	public EducationSplash(){
		
	}
	
	
	
	@Override
	public void Initialize(){
		super.Initialize();
		Image i = new Image("imagen",new Texture("imagenes/esplash.png"));
		this.escena.addActor(i);
	}
	
	
}

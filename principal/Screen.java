package principal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.17114D1B-93AA-7CCB-937E-8E4669A116D4]
// </editor-fold> 
public abstract class Screen {
	
	public Stage escena;
     
    public Screen () {
    	
    }

     
    public void Draw (SpriteBatch spriteBatch) {
    	escena.draw();
    }

    
    public void Update () {
    	
    }
    
    public void Load () {
    	
    }
    
    public void Initialize () {
    	escena = new Stage(GameGlobals.ScreenWidth,GameGlobals.ScreenHeight,true);
    	
    }
    
    public void Dispose(){
    	escena.dispose();
    }
    
    public void Unload(){
    	
    }


}


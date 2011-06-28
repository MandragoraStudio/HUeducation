package principal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.17114D1B-93AA-7CCB-937E-8E4669A116D4]
// </editor-fold> 
public abstract class Screen {
	
	public Stage escena;

     
    public void Draw (SpriteBatch spriteBatch) {
    	escena.draw();
    }

    
    public void Update () {
    	escena.act(Gdx.graphics.getDeltaTime());
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
    
    
 public boolean touchDown (int x, int y, int pointer, int button) {
        escena.touchDown(x, y, pointer, button);
        return false;
}

 public boolean touchUp (int x, int y, int pointer, int button) {
	 escena.touchUp(x, y, pointer, button);
        return false;
}

 public boolean touchDragged (int x, int y, int pointer) {     
	 escena.touchDragged(x, y, pointer);
        return false;
}

 public boolean touchMoved (int x, int y) {
	 escena.touchMoved(x, y);
        return false;
}

}


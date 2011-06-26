package principal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.17114D1B-93AA-7CCB-937E-8E4669A116D4]
// </editor-fold> 
public abstract class Screen {
	
	public Stage escena;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.55119AF5-4E3C-81D9-1A09-972A553DBF56]
    // </editor-fold> 
    public Screen () {
    	escena = new Stage(GameGlobals.ScreenWidth,GameGlobals.ScreenHeight,true);
    	
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A7D2FB09-206C-828C-47B2-07590DAE4C81]
    // </editor-fold> 
    public void Draw (SpriteBatch spriteBatch) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2CEB3E76-734E-393E-9786-EEC8F9D2EC92]
    // </editor-fold> 
    public void Update () {
    }
    
    public void Load () {
    }
    
    public void Initialize () {
    }


}


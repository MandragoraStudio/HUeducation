package juegos;

import com.badlogic.gdx.Input;

import principal.Screen;
import principal.ScreenManager;


public abstract class Juego extends Screen {


    public Juego () {
    	super();
    }


    public void Update () {
    	super.Update();
    }
    
    @Override
    public boolean keyUp(int arg0) {
    	if(arg0== Input.Keys.ESCAPE){
    		ScreenManager.getScreenManager().setCurrentScreen("menu");
    	}
		return false;
	}

}


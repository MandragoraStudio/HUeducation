package principal;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage; 
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.568A4CC0-355A-9165-A132-94106670DFCC]
// </editor-fold> 
public class Game implements ApplicationListener {


    private ScreenManager screenManager;
    private SpriteBatch spriteBatch;

    public void create () {
    	this.screenManager=ScreenManager.getScreenManager;

    	screenManager.addScreen("mcs",new MandragoraSplash());
    	screenManager.setCurrentScreen("mcs");
    	this.spriteBatch=new SpriteBatch();
    	
	}

	
    public void dispose () {
		// TODO Auto-generated method stub

	}

	
    public void pause () {
		// TODO Auto-generated method stub

	}
 
    public void render () {
		//Gdx.gl.glClearColor(0, 1, 0, 1);
	    //Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);   
	    //Gdx.graphics.getGL10().glEnable(GL10.GL_TEXTURE_2D);
	    this.spriteBatch.begin();
    	ScreenManager.getScreenManager.currentScreen.Draw(this.spriteBatch);
    	ScreenManager.getScreenManager.currentScreen.Update();
    	this.spriteBatch.end();
	}


    public void resize (int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

    public void resume () {


    }

}

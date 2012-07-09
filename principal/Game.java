package principal;

import java.io.OutputStream;
import java.io.PrintWriter;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.568A4CC0-355A-9165-A132-94106670DFCC]
// </editor-fold> 
public class Game implements ApplicationListener, InputProcessor {

	private ScreenManager screenManager;
	private SpriteBatch spriteBatch;

	public void create() {
		this.screenManager = ScreenManager.getScreenManager();

		screenManager.addScreen("mcs", new MandragoraSplash());
		screenManager.setCurrentScreen("mcs");
		this.spriteBatch = new SpriteBatch();
		Gdx.input.setInputProcessor(this);
		Gdx.input.setCatchBackKey(true);

	}

	public void dispose() {
		//Guardar
		FileHandle f = Gdx.files.external("campamentomandrilla/save/data.txt");
		OutputStream os=f.write(false);
		PrintWriter pw = new PrintWriter(os);
		
		String[] nums = new String[7];
		nums[0]=String.valueOf(GameGlobals.cuentoFinished);
		nums[1]=String.valueOf(GameGlobals.emocionesFinished);
		nums[2]=String.valueOf(GameGlobals.mezclaFinished);
		nums[3]=String.valueOf(GameGlobals.MuseoFinished);
		nums[4]=String.valueOf(GameGlobals.ModificaFinished);
		nums[5]=String.valueOf(GameGlobals.nueces);
		nums[6]=String.valueOf(GameGlobals.JuegoFinished);
		
		pw.write(nums[0]+","+nums[1]+","+nums[2]+","+nums[3]+","+nums[4]+","+nums[5]+","+nums[6]);
		pw.close();

	}

	public void pause() {
		// TODO Auto-generated method stub

	}

	public void render() {
		// Gdx.gl.glClearColor(0, 1, 0, 1);
		// Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		// Gdx.graphics.getGL10().glEnable(GL10.GL_TEXTURE_2D);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ScreenManager.getScreenManager().currentScreen.Draw(this.spriteBatch);
		ScreenManager.getScreenManager().currentScreen.Update();
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		ScreenManager.getScreenManager().currentScreen.touchDown(x, y, pointer, button);
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		ScreenManager.getScreenManager().currentScreen.touchUp(x, y, pointer, button);
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		ScreenManager.getScreenManager().currentScreen.touchDragged(x, y, pointer);
		return false;
	}

	@Override
	public boolean touchMoved(int x, int y) {
		ScreenManager.getScreenManager().currentScreen.touchMoved(x, y);
		return false;
	}

	public static void salir() {
		// Cosas que quieras hacer antes de salir

		// fin u.u
		System.exit(0);

	}

	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	public void resume() {

	}

	@Override
	public boolean keyDown(int arg0) {
		ScreenManager.getScreenManager().currentScreen.keyDown(arg0);
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		ScreenManager.getScreenManager().currentScreen.keyTyped(arg0);
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		ScreenManager.getScreenManager().currentScreen.keyUp(arg0);
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}

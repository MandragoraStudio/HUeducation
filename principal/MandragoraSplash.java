package principal;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class MandragoraSplash extends Screen {

	public boolean iniciado = false;
	CargaInicio c;
	//private Calendar calendario;
	private long tiempoini=0;
	private long tiempoaux=0;
	private long fin=3000;

	@Override
	public void Initialize(){
		super.Initialize();

		Image i = new Image("imagen", new TextureRegion(new Texture("imagenes2/splash/mandragora1024.png"), 0, 0, 1024, 600));
		//calendario = Calendar.getInstance();
		this.escena.addActor(i);
		
		tiempoini=System.currentTimeMillis();
	}

	@Override
	public void Update() {
		// en la primera ejecucion iniciamos el hilo de carga del menu
		/*if (!iniciado) {
			c = new CargaInicio();
			c.start();
			iniciado = true;
		}*/
		// aqui el update de la pantalla
		tiempoaux = System.currentTimeMillis();
		// finalmente pasamos a la pantalla EducationSplash
		if (/*c.terminado &&*/ fin<=tiempoaux-tiempoini) {
			ScreenManager.getScreenManager().setCurrentScreen("creditos");
		}
	}
	
	@Override
	public void Dispose(){
		escena.removeActor(escena.findActor("imagen"));
		super.Dispose();
	}

}

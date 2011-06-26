package principal;

import java.util.Calendar;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class MandragoraSplash extends Screen {

	private boolean iniciado = false;
	CargaInicio c;
	private Calendar calendario;
	private long tiempoini=0;
	private long tiempoaux=0;
	private long aux=0;
	private long fin=5000;

	@Override
	public void Initialize(){
		super.Initialize();

		Image i = new Image("imagen", new Texture("imagenes/mandragora800.png"));
		calendario = Calendar.getInstance();
		this.escena.addActor(i);
		
		tiempoini=System.currentTimeMillis();
	}

	@Override
	public void Update() {
		// en la primera ejecucion iniciamos el hilo de carga del menu
		if (!iniciado) {
			c = new CargaInicio();
			c.start();
			iniciado = true;
		}
		// aqui el update de la pantalla
		tiempoaux = System.currentTimeMillis();
		aux=tiempoaux-tiempoini;
		// finalmente pasamos a la pantalla EducationSplash
		if (c.terminado && fin<=aux) {
			ScreenManager.getScreenManager().setCurrentScreen("esplash");
		}
	}

}

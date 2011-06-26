package principal;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class MandragoraSplash extends Screen {

	public boolean iniciado = false;
	CargaInicio c;

	@Override
	public void Initialize() {

		Image i = new Image("imagen", new Texture("imagenes/mandragora800.png"));

		this.escena.addActor(i);
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

		// finalmente pasamos a la pantalla EducationSplash
		if (c.terminado) {
			ScreenManager.getScreenManager().setCurrentScreen("esplash");
		}
	}

}

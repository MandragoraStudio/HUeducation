package juegos.museo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import juegos.Juego;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.MoveTo;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class Museo extends Juego {

	private Image fondo;
	private Button izquierda;
	private Button derecha;
	private int numPinacoteca = 1;
	private Group GPinacotecas;
	private Map<String, Pinacoteca2> pinacotecas = new HashMap<String, Pinacoteca2>();

	public Museo() {
		super();

	}

	@Override
	public void Load() {

		GPinacotecas = new Group("Pinacotecas");
	}

	@Override
	public void Initialize() {
		super.Initialize();
		fondo = new Image("fondo", new TextureRegion(new Texture(
				"imagenes2/museo/TexturesMuseo.png"), 0, 0, 1024, 600));
		this.escena.addActor(fondo);
		this.escena.addActor(GPinacotecas);
		this.GPinacotecas.addActor(this.añadirPinacoteca("pinacoteca1"));

		this.añadirPinacoteca("pinacoteca2");

		this.setButtons();
	}

	private void setButtons() {
		derecha = new Button("derecha", new TextureRegion(new Texture(
				"imagenes2/museo/TexturesMuseo.png"), 0, 600, 101, 110));
		derecha.x = 1024 - 10 - this.derecha.width;
		derecha.y = 270;
		this.escena.addActor(derecha);
		derecha.clickListener = new ClickListener() {

			public void clicked(Button arg0) {
				if (numPinacoteca + 1 <= pinacotecas.size()) {
					pinacotecas.get("pinacoteca" + (numPinacoteca + 1)).x = 1000;
					GPinacotecas.addActor(pinacotecas.get("pinacoteca"
							+ (numPinacoteca + 1)));
					quitaPinacoteca("pinacoteca" + numPinacoteca, true);
					numPinacoteca++;
					pinacotecas.get("pinacoteca" + (numPinacoteca)).action(
							MoveTo.$(0, 0, 2));
				}
			}
		};

		izquierda = new Button("izquierda", new TextureRegion(new Texture(
				"imagenes2/museo/TexturesMuseo.png"), 101, 600, 98, 110));
		izquierda.x = 10;
		izquierda.y = 270;
		this.escena.addActor(izquierda);
		izquierda.clickListener = new ClickListener() {

			public void clicked(Button arg0) {
				if (numPinacoteca - 1 > 0) {
					pinacotecas.get("pinacoteca" + (numPinacoteca - 1)).x = -1000;
					GPinacotecas.addActor(pinacotecas.get("pinacoteca"
							+ (numPinacoteca - 1)));
					quitaPinacoteca("pinacoteca" + numPinacoteca, false);
					numPinacoteca--;
					pinacotecas.get("pinacoteca" + (numPinacoteca)).action(
							MoveTo.$(0, 0, 2));
				}
			}
		};
	}

	public Pinacoteca2 añadirPinacoteca(String cad) {

		Pinacoteca2 p = new Pinacoteca2(cad);
		this.pinacotecas.put(cad, p);
		this.pinacotecas.get(cad).Initialize();
		p.x = 0;
		p.y = 0;
		return p;
	}

	public void quitaPinacoteca(String cad, boolean izq) {

		if (izq == true) {
			this.pinacotecas.get(cad).action(MoveTo.$(-1000, 0, 2));
		} else {
			this.pinacotecas.get(cad).action(MoveTo.$(1000, 0, 2));
		}
	}

	public Map<String, Pinacoteca2> getPinacotecas() {

		return this.pinacotecas;
	}

	public void Update() {
		super.Update();

		Iterator it = this.pinacotecas.entrySet().iterator();
		while (it.hasNext()) {

			Map.Entry<String, Pinacoteca2> p = (Map.Entry<String, Pinacoteca2>) it.next();
			if (p.getValue().x == -1000) {
				p.getValue().reestablecerPinacoteca();
				this.GPinacotecas.removeActor(p.getValue());
			}else if (p.getValue().x == 1000) {
				p.getValue().reestablecerPinacoteca();
				this.GPinacotecas.removeActor(p.getValue());
			}
		}

	}

}

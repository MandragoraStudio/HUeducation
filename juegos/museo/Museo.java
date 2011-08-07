package juegos.museo;

import java.util.HashMap;
import java.util.Map;

import juegos.Juego;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class Museo extends Juego {

	private Image fondo;
	private Button izquierda;
	private Button derecha;
	private Map<String, Pinacoteca2> pinacotecas = new HashMap<String, Pinacoteca2>();

	public Museo() {
		super();

	}

	@Override
	public void Load() {

		
	}

	@Override
	public void Initialize() {
		super.Initialize();
		fondo = new Image("fondo", new TextureRegion(new Texture(
				"imagenes/museo/TexturesMuseo.png"), 0, 0, 1024, 600));
		this.escena.addActor(fondo);
		this.pinacotecas.put("pinacoteca1", new Pinacoteca2(this.escena));
		this.pinacotecas.get("pinacoteca1").Initialize();
		this.setButtons();
	}

	private void setButtons() {
		derecha = new Button("derecha", new TextureRegion(new Texture(
				"imagenes/museo/TexturesMuseo.png"), 0, 600, 101, 110));
		derecha.x = 1024-10-this.derecha.width;
		derecha.y = 270;
		this.escena.addActor(derecha);
		derecha.clickListener = new ClickListener() {

			public void clicked(Button arg0) {

			}
		};

		izquierda = new Button("izquierda", new TextureRegion(new Texture(
				"imagenes/museo/TexturesMuseo.png"), 101, 600, 98, 110));
		izquierda.x = 10;
		izquierda.y = 270;
		this.escena.addActor(izquierda);
		izquierda.clickListener = new ClickListener() {

			public void clicked(Button arg0) {

			}
		};
	}

	public void añadirPinacoteca(String cad, Pinacoteca2 pinacoteca) {

		this.pinacotecas.put(cad, pinacoteca);
	}

	public void quitaPinacoteca(String cad) {

		this.pinacotecas.remove(cad);
	}
	
	public Map <String, Pinacoteca2> getPinacotecas(){
		
		return this.pinacotecas;
	}
}

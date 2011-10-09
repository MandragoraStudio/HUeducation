package juegos.Cuento;

import java.util.LinkedList;
import java.util.List;

import juegos.Juego;
import principal.GameGlobals;
import principal.ScreenManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class CuentoClasico extends Juego {

	private Button abrirCuento; //bot�n portada
	//Sistema de control de p�ginas similar al del control de Screens
	public static List<Pagina> paginas;
	public static Pagina paginaActual;

	private Image fondo;
	private Image fondoCuento;

	public CuentoClasico() {
		this.paginas = new LinkedList();
	}

	@Override
	public void Initialize() {
		super.Initialize();
		fondo = new Image("fondoCuento",new TextureRegion(new Texture("imagenes2/cuento/fondoCuento.png"), 
				0, 0, 1024, 600));
		this.escena.addActor(this.fondo);
		setButtons();
	}

	@Override
	public void Load() {
		//fondo del cuento
		this.fondoCuento=new Image("fondoCuento",new TextureRegion(new Texture("imagenes2/cuento/Cuento.png"), 
				0, 0, 960, 600));
		//aqui van todas las p�ginas del cuento.
		paginas.add(new Pagina(0, "A", new Image("hoja1", new TextureRegion(
				new Texture("imagenes2/cuento/TextureCuento1.png"), 0, 0, 340,
				500)), new TextureRegion(new Texture(
				"imagenes2/cuento/TextureCuento1.png"), 0, 520, 170, 500),
				new TextureRegion(new Texture(
						"imagenes2/cuento/TextureCuento1.png"), 170, 520, 170,
						500), this));
		paginas.add(new Pagina(1, "B", new Image("hoja2", new TextureRegion(
				new Texture("imagenes2/cuento/TextureCuento1.png"), 340, 0,
				340, 500)), new TextureRegion(new Texture(
				"imagenes2/cuento/TextureCuento1.png"), 0, 520, 170, 500),
				new TextureRegion(new Texture(
						"imagenes2/cuento/TextureCuento1.png"), 170, 520, 170,
						500), this));
		paginas.add(new Pagina(2, "B", new Image("hoja3", new TextureRegion(
				new Texture("imagenes2/cuento/TextureCuento1.png"), 680, 0,
				340, 500)), new TextureRegion(new Texture(
				"imagenes2/cuento/TextureCuento1.png"), 0, 520, 170, 500),
				new TextureRegion(new Texture(
						"imagenes2/cuento/TextureCuento1.png"), 170, 520, 170,
						500), this));
		//se inicializa la p�gina primera
		paginaActual = paginas.get(0);
	}

	private void setButtons() {
		//creo el boton a abrir cuento (portada) y lo coloco
		abrirCuento = new Button("abrirCuento", new TextureRegion(new Texture(
				"imagenes2/cuento/cerrado.png"), 0, 0, 1024, 600));
		this.escena.addActor(abrirCuento);
		abrirCuento.clickListener = new ClickListener() {

			public void clicked(Button arg0) {
				escena.removeActor(abrirCuento);
				escena.addActor(fondoCuento);
				dibujaPagina();
			}
		};
	}

	// meto la pagina nueva
	public void dibujaPagina() {
		this.escena.addActor(paginaActual.getOpcA());
		this.escena.addActor(paginaActual.getOpcB());
		this.escena.addActor(paginaActual.getHoja());
	}

	// elimina una pagina, se supone que se borra de la memoria al salir de la
	// escena
	public void eliminaPagina() {
		this.escena.removeActor(paginaActual.getOpcA());
		this.escena.removeActor(paginaActual.getOpcB());
		this.escena.removeActor(paginaActual.getHoja());
	}

	// pasa pagina hasta que llega a la �ltima
	public void siguientePagina() {
		if (paginas.size() - 1 > paginaActual.getNumPPag()) {
			paginaActual = paginas.get(paginaActual.getNumPPag() + 1);
			eliminaPagina();
			dibujaPagina();
		} else {
			
			GameGlobals.cuentoFinished=true;
			ScreenManager.getScreenManager().setCurrentScreen("menu");
		}
	}
}
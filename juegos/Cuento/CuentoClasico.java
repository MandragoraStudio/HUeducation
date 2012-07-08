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

	private Button abrirCuento; //botón portada
	//Sistema de control de páginas similar al del control de Screens
	public static List<Pagina> paginas;
	public static Pagina paginaActual;

	private Image fondo;
	private Image fondoCuento;
	private Button BAtras;

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
		//aqui van todas las páginas del cuento.

		//página 1
		paginas.add(new Pagina(0, "B", new Image("hoja1", new TextureRegion(
				new Texture("imagenes2/cuento/TextureCuento1.png"), 0, 0, 360,
				530)), new TextureRegion(new Texture(
				"imagenes2/cuento/TextureCuento1.png"), 50, 575, 150, 365),
				new TextureRegion(new Texture(
						"imagenes2/cuento/TextureCuento1.png"), 205, 575, 150,
						365), this));

		//página 2
		paginas.add(new Pagina(1, "A", new Image("hoja2", new TextureRegion(
				new Texture("imagenes2/cuento/TextureCuento1.png"), 440, 0,
				360, 530)), new TextureRegion(new Texture(
				"imagenes2/cuento/TextureCuento1.png"), 490, 575, 150, 365),
				new TextureRegion(new Texture(
						"imagenes2/cuento/TextureCuento1.png"), 635, 575, 150,
						365), this));
		

		//página 3
		paginas.add(new Pagina(2, "A", new Image("hoja3", new TextureRegion(
				new Texture("imagenes2/cuento/TextureCuento3.png"), 15, 20,
				365, 540)), new TextureRegion(new Texture(
				"imagenes2/cuento/TextureCuento3.png"), 40, 580, 150, 365),
				new TextureRegion(new Texture(
						"imagenes2/cuento/TextureCuento3.png"), 220, 580, 150,
						365), this));

		//página 4
		paginas.add(new Pagina(3, "A", new Image("hoja4", new TextureRegion(
				new Texture("imagenes2/cuento/TextureCuento3.png"), 440, 15,
				365, 540)), new TextureRegion(new Texture(
				"imagenes2/cuento/TextureCuento3.png"), 465, 575, 150, 365),
				new TextureRegion(new Texture(
						"imagenes2/cuento/TextureCuento3.png"), 365, 575, 150,
						365), this));

		//página 5
		paginas.add(new Pagina(4, "B", new Image("hoja5", new TextureRegion(
				new Texture("imagenes2/cuento/TextureCuento3.png"), 0, 0,
				735, 525)), new TextureRegion(new Texture(
				"imagenes2/cuento/TextureCuento3.png"), 0, 0, 0, 0),
				new TextureRegion(new Texture(
						"imagenes2/cuento/TextureCuento3.png"), 0, 0, 0,
						0), this));


		//se inicializa la página primera
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
		
		// Boton atras
		BAtras = new Button("salir",new TextureRegion(new Texture("imagenes2/Menu/atras sin pulsar.png")),new TextureRegion(new Texture("imagenes2/Menu/atras pulsado.png")));
		BAtras.x = this.escena.width() - BAtras.width;
		BAtras.y = this.escena.height() - BAtras.height -20;
		this.escena.addActor(BAtras);
		BAtras.clickListener=new ClickListener(){
			public void clicked(Button b){
				ScreenManager.getScreenManager().setCurrentScreen("menu");
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

	// pasa pagina hasta que llega a la última
	public void siguientePagina() {
		if (paginas.size() - 1 > paginaActual.getNumPPag()) {
			/*TODO: meter sonido según la página en la que 			estemos*/
			paginaActual = paginas.get(paginaActual.getNumPPag() + 1);
			eliminaPagina();
			dibujaPagina();
		} else {
			
			GameGlobals.cuentoFinished=true;
			ScreenManager.getScreenManager().setCurrentScreen("menu");
		}
	}
}
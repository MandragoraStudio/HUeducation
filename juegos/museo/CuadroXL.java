package juegos.museo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class CuadroXL extends Button {

	private Image fondo;
	private Image pintura;
	
	private boolean inicializado;
	
	public CuadroXL(){
		super("cuadro",new TextureRegion(new Texture("imagenes2/museo/TexturesMuseo2.png"), 0, 0, 814, 549));
		
	}
	
	public void Initialize(){
		this.fondo = new Image ("fondoCuadro", new TextureRegion(new Texture("imagenes2/museo/TexturesMuseo.png"), 0, 0, 814, 549));
		this.pintura = new Image ("pintura", new TextureRegion(new Texture("imagenes2/museo/TexturesMuseo.png"), 40, 29, 776-40, 510-29));
		this.x=103;
		this.y=30;
		inicializado=false;
	}
	
	public void setPintura(TextureRegion pintura){
		
		this.pintura.region=pintura;
		inicializado=true;
	}

	public boolean isInicializado() {
		return inicializado;
	}

	public void setInicializado(boolean inicializado) {
		this.inicializado = inicializado;
	}

	public Image getFondo() {
		return fondo;
	}

	public void setFondo(Image fondo) {
		this.fondo = fondo;
	}

	public Image getPintura() {
		return pintura;
	}

	public void setPintura(Image pintura) {
		this.pintura = pintura;
	}
	
	
}

package juegos.museo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class Cuadro extends Button {

	private Image fondo;
	
	private Image pintura;
	
	public Cuadro(){
		super("cuadro",new TextureRegion(new Texture("imagenes/museo/TexturesMuseo.png"), 199, 600, 385, 305));
		
	}
	
	public void Initialize(){
		this.fondo = new Image ("fondoCuadro", new TextureRegion(new Texture("imagenes/museo/TexturesMuseo.png"), 199, 600, 385, 305));
		this.pintura = new Image ("pintura", new TextureRegion(new Texture("imagenes/museo/TexturesMuseo.png"), 214, 613, 555-214, 868-613));
		
	}
	
	public void setPintura(TextureRegion pintura){
		
		this.pintura.region=pintura;
	}
}

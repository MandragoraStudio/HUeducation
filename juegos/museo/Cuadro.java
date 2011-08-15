package juegos.museo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class Cuadro extends Button {

	private Image fondoP;
	private Image pinturaP;
	
	private Image fondoG;
	private Image pinturaG;
	
	public Cuadro(){
		super("cuadro",new TextureRegion(new Texture("imagenes2/museo/TexturesMuseo.png"), 199, 600, 385, 305));
		
	}
	
	public void Initialize(){
		this.fondoP = new Image ("fondoCuadro", new TextureRegion(new Texture("imagenes2/museo/TexturesMuseo.png"), 199, 600, 385, 305));
		this.pinturaP = new Image ("pintura", new TextureRegion(new Texture("imagenes2/museo/TexturesMuseo.png"), 214, 613, 555-214, 868-613));
		
	}
	
	public void setPintura(TextureRegion pintura){
		
		this.pinturaP.region=pintura;
	}
}

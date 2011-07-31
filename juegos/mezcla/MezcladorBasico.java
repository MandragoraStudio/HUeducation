package juegos.mezcla;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class MezcladorBasico extends Group{
	
	Texture Color1;
	Texture Color2;
	
	public MezcladorBasico(){
		super("mezclador");
		Color1 = MezcladorBasico.getColoredTexture(100, 200, 1, 1, 1, 1);
		this.addActor(new Image("color1",Color1));
		
		
	}
	
	public static Texture getColoredTexture(int width, int height,float r, float g, float b, float a) {
		Texture dev = new Texture(width, height, Format.RGBA8888);
		Pixmap p = new Pixmap(width, height, Format.RGBA8888);
		p.setColor(r, g, b, a);
		p.fill();
		try {
			dev.draw(p, 0, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dev;
	}
	
}

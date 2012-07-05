package juegos.mezcla;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class DrawableImage extends Image {

	public Pixmap pincel = new Pixmap(10,10,Format.RGBA8888);
	Texture textura;

	public DrawableImage(String name, Texture text){
		super(name,text);
		textura=text;
		init();
	}
	/*public DrawableImage(String name, TextureRegion region) {
		super(name, region);
		init();
	}*/
	
	public void init(){
		this.touchable=true;
	}
	
	@Override
	public boolean touchDragged(float X,float  Y,int  pointer){
		if(!(X>0&&X<textura.getWidth()&&Y>0&&Y<textura.getHeight())){
			return false;
		}
		textura.draw(pincel,(int) X-5,textura.getHeight()-((int) Y)-5);
		
		return true;
	}
	
	public void guardarCuadro(){
		Date date = Calendar.getInstance().getTime();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd.hhmmss");
		  String nombre = sdf.format(date);
		FileHandle f = Gdx.files.external("/campamentomandrilla/cuadros/"+nombre+".png");
		textura.
	}

}

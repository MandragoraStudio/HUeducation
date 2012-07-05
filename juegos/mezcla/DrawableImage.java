package juegos.mezcla;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
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

	Pixmap pm;
	Texture textura;

	public DrawableImage(String name, Texture text){
		super(name,text);
		textura=text;
		pm=new Pixmap(textura.getWidth(),textura.getHeight(),textura.getFormat());
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
		pm.drawPixmap(pincel,(int) X-5,textura.getHeight()-((int) Y)-5,0,0,pincel.getWidth(),pincel.getHeight());
		textura.draw(pm,0,0);
		//guardarCuadro();			//pasar texturas a archivos, un mito
		return true;
	}
	
	public void guardarCuadro(){
		Date date = Calendar.getInstance().getTime();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd.hhmmss");
		  String nombre = sdf.format(date);
		FileHandle f = Gdx.files.external("campamentomandrilla/cuadros/"+nombre+".png");
		f.parent().mkdirs();
		OutputStream os = f.write(true);
		try {
			
			ByteBuffer bb = pm.getPixels();
			byte[] data =bb.array();
			os.write(data);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

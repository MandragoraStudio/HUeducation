package juegos.mezcla;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;

import principal.GameGlobals;

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
		pm=new Pixmap(textura.getWidth(),textura.getHeight(),Format.RGBA8888);
		pm.setColor(1,1,1,1);
		pm.fill();
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
		os.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		/*
		try {
			
			ByteBuffer bb = pm.getPixels();
			byte[] data =bb.array();
			os.write(data);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		// el siguiente codigo NO es compatible con Android, quizas
		try {
		    // retrieve image
		    BufferedImage bi = new BufferedImage(pm.getWidth(),pm.getHeight(),BufferedImage.TYPE_INT_ARGB);
		    for(int i =0;i<pm.getWidth();i++){
		    	for(int j =0;j<pm.getHeight();j++){
		    		if(pm.getPixel(i, j)!=0xffffffff){
		    			int prueba =pm.getPixel(i, j);
		    			prueba++;
		    			prueba--;
		    		}
		    		int A = pm.getPixel(i,j)&0x000000ff;
		    		A=A*0x1000000;
		    		int resultado = pm.getPixel(i,j)>>8;
		    		resultado =resultado&0x00ffffff;
		    		resultado+=A;
		    		bi.setRGB(i, j, resultado);
		    		
		    	}
		    }
		    
		    File outputfile = new File(FileSystemView.getFileSystemView().getHomeDirectory().getParent()+"\\campamentomandrilla\\cuadros\\"+nombre+".png");
		    ImageIO.write(bi, "png", outputfile);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		GameGlobals.nueces++;
	}

}

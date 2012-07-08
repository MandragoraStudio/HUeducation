package principal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actors.Button;

public class Arrastrable extends Button {
	Group Padre;
	float Yinicial;
	float Xinicial;
	boolean visible;
	boolean colocado;
	Pixmap grafico;

	public Arrastrable(String name, TextureRegion texture,Group padre) {
		super(name, texture);
		//if (padre == null)throw new IllegalArgumentException("El padre no pude ser null");
		this.Padre=padre;
		// TODO Auto-generated constructor stub
	}
	public Arrastrable(String name, String src,int x,int y, int width, int height) {
		super(name, new TextureRegion(new Texture(src),x,y,width,height));
		Pixmap temp = new Pixmap(Gdx.files.internal(src));
		grafico = new Pixmap(width,height,Format.RGBA8888);
		grafico.drawPixmap(temp, 0, 0, x, y, width, height);
	}
	
	public Arrastrable(String name, Texture texture) {
		super(name, texture);
		// TODO Auto-generated constructor stub
	}
	
	public Arrastrable(String name, TextureRegion texture) {
		super(name, texture);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean touchDown(float x, float y, int pointer) {
		// TODO Auto-generated method stub
		Yinicial=y;
		Xinicial=x;
		return super.touchDown(x, y, pointer);
	}

	@Override
	protected boolean touchDragged(float x, float y, int pointer) {
		// TODO Auto-generated method stub
		if (Padre != null) {
			if(this.pressed){
				Padre.x=Padre.x+(x-Xinicial);
				Padre.y=Padre.y+(y-Yinicial);
			}
		} else {
			if(this.pressed){
				this.x = this.x+(x-Xinicial);
				this.y = this.y+(y-Yinicial);
			}
		}
		return super.touchDragged(x, y, pointer);
	}

	@Override
	protected boolean touchUp(float x, float y, int pointer) {
		// TODO Auto-generated method stub
		return super.touchUp(x, y, pointer);
	}
	
	public void addToPixmap(Pixmap destino){
		//destino.drawPixmap(pixmap, x, y, srcx, srcy, srcWidth, srcHeight)
		destino.drawPixmap(this.grafico, ((int)x-300),destino.getHeight()-((int) y-80+grafico.getHeight()), 0, 0, grafico.getWidth(), grafico.getHeight());
	}

	
}

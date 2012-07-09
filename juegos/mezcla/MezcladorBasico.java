package juegos.mezcla;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.MoveTo;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class MezcladorBasico extends Group {

	
	Paleta paleta;
	Texture Fondo = MezcladorBasico.getColoredTexture(1024, 600, 0.2f, 0.2f,
			0.2f, 0.5f);
	//Image Color1;
	//Image Color2;
	Texture ColorObjetivo;
	Button imagenObjetivo;
	Image mesa = new Image("mesa",new Texture("imagenes2/mezcla/mesa.png"));
	Image mancha1 = new Image("mesa",new Sprite(new Texture("imagenes2/mezcla/mancha.png")));
	Image mancha2 = new Image("mesa",new Sprite(new Texture("imagenes2/mezcla/mancha.png")));
	int colorcorrecto;
	ClickListener comprobador = new ClickListener(){
		public void clicked(Button button) {
			if(compruebaColor(Integer.parseInt(button.name.substring(1)))){
				action(MoveTo.$(-600,-600,2));
				paleta.colorAcertado();
			}else{
				paleta.colorFallido();
			}
		}
		
	};

	Button i1 = new Button("i1", MezcladorBasico.getColoredTexture(100, 100,
			(float) Math.random(), (float) Math.random(),
			(float) Math.random(), 1));
	Button i2 = new Button("i2", MezcladorBasico.getColoredTexture(100, 100,
			(float) Math.random(), (float) Math.random(),
			(float) Math.random(), 1));
	Button i3 = new Button("i3", MezcladorBasico.getColoredTexture(100, 100,
			(float) Math.random(), (float) Math.random(),
			(float) Math.random(), 1));
	Button i4 = new Button("i4", MezcladorBasico.getColoredTexture(100, 100,
			(float) Math.random(), (float) Math.random(),
			(float) Math.random(), 1));
	Button i5 = new Button("i5", MezcladorBasico.getColoredTexture(100, 100,
			(float) Math.random(), (float) Math.random(),
			(float) Math.random(), 1));
	Button i6 = new Button("i6", MezcladorBasico.getColoredTexture(100, 100,
			(float) Math.random(), (float) Math.random(),
			(float) Math.random(), 1));

	
	public MezcladorBasico(Paleta padre) {
		super("mezclador");
		paleta = padre;
		i1.clickListener=comprobador;
		i2.clickListener=comprobador;
		i3.clickListener=comprobador;
		i4.clickListener=comprobador;
		i5.clickListener=comprobador;
		i6.clickListener=comprobador;
		
		this.addActor(new Image("fondo", Fondo));
		this.addActor(mesa);
		//Color1 = new Image("color1", MezcladorBasico.getColoredTexture(120,
		//		250, 1, 1, 0, 1));
		//this.addActor(Color1);
		this.addActor(mancha1);
		//Color2 = new Image("color2", MezcladorBasico.getColoredTexture(120,
		//		250, 1, 0, 1, 1));
		//this.addActor(Color2);
		this.addActor(mancha2);
		//this.findActor("color1").x = 350;
		//this.findActor("color1").y = 200;
		//this.findActor("color2").x = 600;
		//this.findActor("color2").y = 200;
		//mancha1.x=this.findActor("color1").x;
		//mancha1.y=this.findActor("color1").y;
		//mancha2.x=this.findActor("color2").x;
		//mancha2.y=this.findActor("color2").y;
		mancha1.x=110;
		mancha1.y=200;
		mancha2.x=360;
		mancha2.y=200;
		mesa.x=50;
		mesa.y=50;
		this.addActor(i1);
		this.addActor(i2);
		this.addActor(i3);
		this.addActor(i4);
		this.addActor(i5);
		this.addActor(i6);

		i1.x = 600;
		i2.x = 600;
		i3.x = 600;
		i4.x = 720;
		i5.x = 720;
		i6.x = 720;

		i1.y = 450;
		i4.y = 450;
		i2.y = 300;
		i5.y = 300;
		i3.y = 150;
		i6.y = 150;

	}
	
	public boolean compruebaColor(int i){
		if(i==colorcorrecto){
			return true;
		}else{
			return false;
		}
	}

	public void setColor1(float r, float g, float b, float a) {
		mancha1.region = new TextureRegion(MezcladorBasico.getColoredTexture(
				100, 200, r, g, b, a));
		//((Sprite)mancha1.region).setColor(r, g, b, a);
		
	}

	public void setColor2(float r, float g, float b, float a) {
		mancha2.region = new TextureRegion(MezcladorBasico.getColoredTexture(
				100, 200, r, g, b, a));
		//((Sprite)mancha2.region).setColor(r, g, b, a);
		
	}

	public void setColorObjetivo(float r, float g, float b, float a) {
		ColorObjetivo = MezcladorBasico.getColoredTexture(100, 100, r, g, b, a);
		//Button cambio = null;
		int i = (int) (Math.random() * 6);
		i++;
		this.colorcorrecto=i;
		try {
			imagenObjetivo=((Button) this.findActor("i" + i));
			imagenObjetivo.unpressedRegion = new TextureRegion(
					MezcladorBasico.getColoredTexture(100, 100, r, g, b, a));
			imagenObjetivo.pressedRegion = new TextureRegion(
					MezcladorBasico.getColoredTexture(100, 100, r, g, b, a));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Texture getColoredTexture(int width, int height, float r,
			float g, float b, float a) {
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

	@Override
	protected void act(float delta) {
		super.act(delta);
	}
	
	public void aleatorizaColores(){
		Texture aux1 = MezcladorBasico.getColoredTexture(100, 100,
				(float) Math.random(), (float) Math.random(),
				(float) Math.random(), 1);
		i1.pressedRegion =new TextureRegion(aux1);
		i1.unpressedRegion=new TextureRegion(aux1);
		Texture aux2 = MezcladorBasico.getColoredTexture(100, 100,
				(float) Math.random(), (float) Math.random(),
				(float) Math.random(), 1);
		i2.pressedRegion =new TextureRegion(aux2);
		i2.unpressedRegion=new TextureRegion(aux2);
		Texture aux3 = MezcladorBasico.getColoredTexture(100, 100,
				(float) Math.random(), (float) Math.random(),
				(float) Math.random(), 1);
		i3.pressedRegion =new TextureRegion(aux3);
		i3.unpressedRegion=new TextureRegion(aux3);
		Texture aux4 = MezcladorBasico.getColoredTexture(100, 100,
				(float) Math.random(), (float) Math.random(),
				(float) Math.random(), 1);
		i4.pressedRegion =new TextureRegion(aux4);
		i4.unpressedRegion=new TextureRegion(aux4);
		Texture aux5 = MezcladorBasico.getColoredTexture(100, 100,
				(float) Math.random(), (float) Math.random(),
				(float) Math.random(), 1);
		i5.pressedRegion =new TextureRegion(aux5);
		i5.unpressedRegion=new TextureRegion(aux5);
		Texture aux6 = MezcladorBasico.getColoredTexture(100, 100,
				(float) Math.random(), (float) Math.random(),
				(float) Math.random(), 1);
		i6.pressedRegion =new TextureRegion(aux6);
		i6.unpressedRegion=new TextureRegion(aux6);
	}

}

package juegos.mezcla;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class MezcladorBasico extends Group {

	Texture Fondo = MezcladorBasico.getColoredTexture(1024, 600, 0.2f, 0.2f,
			0.2f, 0.5f);
	Image Color1;
	Image Color2;
	Texture ColorObjetivo;
	Image imagenObjetivo;

	Image i1 = new Image("i1", MezcladorBasico.getColoredTexture(100, 100,
			(float) Math.random(), (float) Math.random(),
			(float) Math.random(), 1));
	Image i2 = new Image("i2", MezcladorBasico.getColoredTexture(100, 100,
			(float) Math.random(), (float) Math.random(),
			(float) Math.random(), 1));
	Image i3 = new Image("i3", MezcladorBasico.getColoredTexture(100, 100,
			(float) Math.random(), (float) Math.random(),
			(float) Math.random(), 1));
	Image i4 = new Image("i4", MezcladorBasico.getColoredTexture(100, 100,
			(float) Math.random(), (float) Math.random(),
			(float) Math.random(), 1));
	Image i5 = new Image("i5", MezcladorBasico.getColoredTexture(100, 100,
			(float) Math.random(), (float) Math.random(),
			(float) Math.random(), 1));
	Image i6 = new Image("i6", MezcladorBasico.getColoredTexture(100, 100,
			(float) Math.random(), (float) Math.random(),
			(float) Math.random(), 1));

	public MezcladorBasico() {
		super("mezclador");

		this.addActor(new Image("fondo", Fondo));
		Color1 = new Image("color1", MezcladorBasico.getColoredTexture(100,
				200, 1, 1, 0, 1));
		this.addActor(Color1);
		Color2 = new Image("color2", MezcladorBasico.getColoredTexture(100,
				200, 1, 0, 1, 1));
		this.addActor(Color2);
		this.findActor("color1").x = 350;
		this.findActor("color1").y = 200;
		this.findActor("color2").x = 600;
		this.findActor("color2").y = 200;

		this.addActor(i1);
		this.addActor(i2);
		this.addActor(i3);
		this.addActor(i4);
		this.addActor(i5);
		this.addActor(i6);

		i1.x = 800;
		i2.x = 800;
		i3.x = 800;
		i4.x = 920;
		i5.x = 920;
		i6.x = 920;

		i1.y = 450;
		i4.y = 450;
		i2.y = 300;
		i5.y = 300;
		i3.y = 150;
		i6.y = 150;

	}

	public void setColor1(float r, float g, float b, float a) {
		Color1.region = new TextureRegion(MezcladorBasico.getColoredTexture(
				100, 200, r, g, b, a));
	}

	public void setColor2(float r, float g, float b, float a) {
		Color2.region = new TextureRegion(MezcladorBasico.getColoredTexture(
				100, 200, r, g, b, a));
	}

	public void setColorObjetivo(float r, float g, float b, float a) {
		ColorObjetivo = MezcladorBasico.getColoredTexture(100, 100, r, g, b, a);
		Image cambio = null;
		int i = (int) (Math.random() * 6);
		i++;
		try {
			imagenObjetivo=((Image) this.findActor("i" + i));
			imagenObjetivo.region = new TextureRegion(
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

}

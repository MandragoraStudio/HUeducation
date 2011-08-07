package juegos.mezcla;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.MoveBy;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

//Esta clase debe extender de la clase Grupo de Actores, e incluir todos los subactores necesarios para crear la paleta. Soy un genio
public class Paleta extends Group {
	
	
	
	Image Fondo = new Image("fondo", new Texture(
			"imagenes/mezcla/fondopaleta.png"));

	Button colorCyan = new Button("CCyan", Paleta.getColoredTexture(0, 0, 1, 1));
	Button colorMagenta = new Button("CMagenta", Paleta.getColoredTexture(1, 0,
			0, 1));
	Button colorAmarillo = new Button("CAmarillo", Paleta.getColoredTexture(1,
			1, 0, 1));

	Button colorRojo = new Button("CRojo");
	Button colorVerde = new Button("CVerde");
	Button colorMorado = new Button("CMorado");

	Button colorP1 = new Button("CP1");
	Button colorP2 = new Button("CP2");
	Button colorP3 = new Button("CP3");
	Button colorP4 = new Button("CP4");
	Button colorP5 = new Button("CP5");
	Button colorP6 = new Button("CP6");
	
	Button sacaMezclador = new Button("sacaMezclador",new TextureRegion(new Texture("imagenes/mezcla/pruebaboton.png"),20,20,20,20),new TextureRegion(new Texture("imagenes/mezcla/pruebaboton.png")));
	
	MezcladorBasico mezcladorBasico = new MezcladorBasico();
	
	ClickListener evento = new ClickListener(){

		@Override
		public void clicked(Button boton) {
			float r = 1;
			float g = 1;
			float b = 1;
			if(boton.name.equals("CCyan")){
				r=0;
				g=0;
			}else if(boton.name.equals("CMagenta")){
				g=0;
				b=0;
			}else if(boton.name.equals("CAmarillo")){
				b=0;
			}
			MezclaColores.cambiarColorPincel(r, g, b);
		}
		
	};

	public static Texture getColoredTexture(float r, float g, float b, float a) {
		Texture dev = new Texture(50, 50, Format.RGBA8888);
		Pixmap p = new Pixmap(50, 50, Format.RGBA8888);
		p.setColor(r, g, b, a);
		p.fill();
		try {
			dev.draw(p, 0, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dev;
	}

	public Paleta(String name) {
		super(name);
		this.addActor(Fondo);
		this.addActor(colorCyan);
		colorCyan.x = 20;
		colorCyan.y = 300;
		colorCyan.clickListener=evento;
		this.addActor(colorMagenta);
		colorMagenta.x = 130;
		colorMagenta.y = 300;
		colorMagenta.clickListener=evento;
		this.addActor(colorAmarillo);
		colorAmarillo.x = 250;
		colorAmarillo.y = 300;
		colorAmarillo.clickListener=evento;
		this.addActor(colorRojo);
		colorRojo.clickListener=evento;
		this.addActor(colorVerde);
		colorVerde.clickListener=evento;
		this.addActor(colorMorado);
		colorMorado.clickListener=evento;
		this.addActor(colorP1);
		colorP1.clickListener=evento;
		this.addActor(colorP2);
		colorP2.clickListener=evento;
		this.addActor(colorP3);
		colorP3.clickListener=evento;
		this.addActor(colorP4);
		colorP4.clickListener=evento;
		this.addActor(colorP5);
		colorP5.clickListener=evento;
		this.addActor(colorP6);
		colorP6.clickListener=evento;
		this.addActor(sacaMezclador);
		sacaMezclador.height=100;
		sacaMezclador.width=100;
		sacaMezclador.clickListener=new ClickListener(){
			@Override
			public void clicked(Button boton) {
				sacaMezclador.action(new MoverA(200,500));
			}
			
		};
		this.addActor(mezcladorBasico);
		mezcladorBasico.x=-100;
		//mezcladorBasico.y=600;
		this.touchable = true;
	}

}

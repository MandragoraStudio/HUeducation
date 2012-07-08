package juegos.mezcla;

import principal.GameGlobals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.MoveTo;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

//Esta clase debe extender de la clase Grupo de Actores, e incluir todos los subactores necesarios para crear la paleta. Soy un genio
public class Paleta extends Group {
	
	
	public static Button debugVariable;
	
	public int coloresDisponibles = 0;
	public int MAXcolores = 3;		// Cambialo antonio
	
	// Musica reproducida cuando se consigue un nuevo color
	private Music genial = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesdeacciones/genial.wav"));
	// Sonido reproducido cuando se tienen todos los colores
	private Music take6 = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesmezcladecolor/Take 6.wav"));
	
	Image Fondo = new Image("fondo", new Texture(
			"imagenes2/mezcla/Paleta.png"));

	Button colorCyan = new Button("CCyan", Paleta.getColoredTexture(0, 1, 1, 1));
	Button colorMagenta = new Button("CMagenta", Paleta.getColoredTexture(1, 0,
			1, 1));
	Button colorAmarillo = new Button("CAmarillo", Paleta.getColoredTexture(1,
			1, 0, 1));
	Button colorBlanco = new Button("CBlanco", Paleta.getColoredTexture(1,
			1, 1, 1));
	Button colorNegro = new Button("CNegro", Paleta.getColoredTexture(0,
			0, 0, 1));

	Button colorRojo = new Button("CRojo");
	Button colorVerde = new Button("CVerde");
	Button colorAzul = new Button("CAzul");

	Button colorP1 = new Button("CP1");
	Button colorP2 = new Button("CP2");
	Button colorP3 = new Button("CP3");
	Button colorP4 = new Button("CP4");
	Button colorP5 = new Button("CP5");
	Button colorP6 = new Button("CP6");
	
	
	Button bGuardar = new Button("Guardar", new TextureRegion(new Texture("imagenes2/mezcla/guardar1.png")),new TextureRegion(new Texture("imagenes2/mezcla/guardar2.png")));
	
	int[][] colores = new int[3][3];
	
	Button sacaMezclador = new Button("sacaMezclador",new TextureRegion(new Texture("imagenes/mezcla/pruebaboton.png"),20,20,20,20),new TextureRegion(new Texture("imagenes/mezcla/pruebaboton.png")));
	
	MezcladorBasico mezcladorBasico; 
	
	ClickListener evento = new ClickListener(){

		@Override
		public void clicked(Button boton) {
			float r = 1;
			float g = 1;
			float b = 1;
			if(boton.name.equals("CCyan")){
				r=0;
			}else if(boton.name.equals("CMagenta")){
				g=0;
			}else if(boton.name.equals("CAmarillo")){
				b=0;
			}else if(boton.name.equals("CVerde")){
				r=0;
				b=0;
			}else if(boton.name.equals("CRojo")){
				g=0;
				b=0;
			}else if(boton.name.equals("CAzul")){
				r=0;
				g=0;
			}else if(boton.name.equals("CNegro")){
				r=0;
				g=0;
				b=0;
			}
			MezclaColores.cambiarColorPincel(r, g, b);
		}
		
	};

	public static Texture getColoredTexture(float r, float g, float b, float a) {
		Texture dev = new Texture(66, 66, Format.RGBA8888);
		Pixmap p = new Pixmap(66, 66, Format.RGBA8888);
		p.setColor(r, g, b, a);
		p.fillCircle(33, 33, 33);
		//p.fill();
		try {
			dev.draw(p, 0, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dev;
	}

	public Paleta(String name) {
		super(name);
		mezcladorBasico = new MezcladorBasico(this);
		this.addActor(colorCyan);
		colorCyan.x = 192;
		colorCyan.y = 433;
		colorCyan.clickListener=evento;
		this.addActor(colorMagenta);
		colorMagenta.x = 108;
		colorMagenta.y = 421;
		colorMagenta.clickListener=evento;
		this.addActor(colorAmarillo);
		colorAmarillo.x = 272;
		colorAmarillo.y = 393;
		colorAmarillo.clickListener=evento;
		this.addActor(colorRojo);
		bGuardar.x=00;
		bGuardar.y=00;
		this.addActor(colorBlanco);
		colorBlanco.x = 325;
		colorBlanco.y = 100;
		colorBlanco.clickListener=evento;
		this.addActor(colorNegro);
		colorNegro.x = 287;
		colorNegro.y = 34;
		colorNegro.clickListener=evento;
		bGuardar.clickListener=new ClickListener(){

			@Override
			public void clicked(Button arg0) {
				MezclaColores.lienzo.guardarCuadro();
				
			}
			
		};
		this.addActor(bGuardar);

		
		this.addActor(Fondo);
		Fondo.touchable=false;
		/*
		colorRojo.clickListener=evento;
		this.addActor(colorVerde);
		colorVerde.clickListener=evento;
		this.addActor(colorAzul);
		colorAzul.clickListener=evento;
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
		*/
		this.addActor(sacaMezclador);
		sacaMezclador.height=100;
		sacaMezclador.width=100;
		sacaMezclador.x=190;
		sacaMezclador.y=100;
		sacaMezclador.clickListener=new ClickListener(){
			@Override
			public void clicked(Button boton) {
				mezcladorBasico.aleatorizaColores();
				eligeColores();
				mezcladorBasico.setColor1(colores[0][0], colores[0][1], colores[0][2], 1);
				mezcladorBasico.setColor2(colores[1][0], colores[1][1],colores[1][2], 1);
				mezcladorBasico.setColorObjetivo(colores[2][0], colores[2][1],colores[2][2], 1);
				mezcladorBasico.action(MoveTo.$(-600, 0, 2));
				//mezcladorBasico.x=-600;
				//mezcladorBasico.y=0;
			}
			
		};
		this.addActor(mezcladorBasico);
		mezcladorBasico.x=-600;
		mezcladorBasico.y=-this.y-1024;
		this.touchable = true;
	}
	public void eligeColores(){
		switch(coloresDisponibles){
		case 0:
			colores[0][0]=0;
			colores[0][1]=1;
			colores[0][2]=1;
			colores[1][0]=1;
			colores[1][1]=1;
			colores[1][2]=0;
			colores[2][0]=0;
			colores[2][1]=1;
			colores[2][2]=0;
			break;
		case 1:
			colores[0][0]=1;
			colores[0][1]=0;
			colores[0][2]=1;
			colores[1][0]=1;
			colores[1][1]=1;
			colores[1][2]=0;
			colores[2][0]=1;
			colores[2][1]=0;
			colores[2][2]=0;
			break;
		case 2:
			colores[0][0]=1;
			colores[0][1]=0;
			colores[0][2]=1;
			colores[1][0]=0;
			colores[1][1]=1;
			colores[1][2]=1;
			colores[2][0]=0;
			colores[2][1]=0;
			colores[2][2]=1;
			break;
		
		}
	}
	public void colorAcertado(){
		switch(coloresDisponibles){
		case 0:
			colorVerde=new Button("CVerde", Paleta.getColoredTexture(0,
					1, 0, 1));
			colorVerde.x=42;
			colorVerde.y=360;
			colorVerde.clickListener=evento;
			this.addActorBefore(Fondo,colorVerde);
			break;
		case 1:
			colorRojo=new Button("CRojo", Paleta.getColoredTexture(1,
					0, 0, 1));
			colorRojo.x=126;
			colorRojo.y=351;
			colorRojo.clickListener=evento;
			this.addActorBefore(Fondo,colorRojo);
			break;
		case 2:
			colorAzul=new Button("CAzul", Paleta.getColoredTexture(0,
					0, 1, 1));
			colorAzul.x=206;
			colorAzul.y=360;
			colorAzul.clickListener=evento;
			this.addActorBefore(Fondo,colorAzul);
			break;
		default:
			coloresDisponibles--;
			break;
		}
		coloresDisponibles++;
		if(coloresDisponibles == MAXcolores){
			take6.play();
			GameGlobals.nueces++;
		}else{
			genial.play();
		}
	}
	
	@Override
	public void act(float delta){
		super.act(delta);
		debugVariable=this.colorNegro;
		debugVariable.x=287;
		debugVariable.y=34;
	}
	
	/*@Override
	public boolean touchUp(float a,float b, int c){
		return false;
	}
	@Override
	public boolean touchDown(float a,float b, int c){
		return false;
	}*/

}

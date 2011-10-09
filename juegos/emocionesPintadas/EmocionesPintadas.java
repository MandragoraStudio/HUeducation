package juegos.emocionesPintadas;

import java.util.HashMap;
import java.util.Map;

import principal.GameGlobals;
import principal.ScreenManager;

import juegos.Juego;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;


public class EmocionesPintadas extends Juego {
	
	Map<String,String> cuadros = new HashMap<String,String>();
	int cuadroActual=0;
	Image fondo;
	Image caballete;
	Image cuadro;
	Button triste;
	Button alegre;
	Button asco;
	Button enfadado;
	Button miedo;
	Button sorpresa;
	String codigoActual;
	
	public EmocionesPintadas(){
		super();
	}
	
	@Override
	public void Update(){
		super.Update();
		
	}
	
	@Override
	public void Load(){
		cuadros.put("cuadro1", "a");
		cuadros.put("cuadro2", "w");
		int numbotones =6;
		
		fondo =new Image("fondo",new TextureRegion(new Texture("imagenes2/emociones/emociones1.png"),0,102,1024,600));
		caballete =new Image("fondo",new TextureRegion(new Texture("imagenes2/emociones/emociones2.png"),0,0,1024,600));
		triste = new Button("t",new TextureRegion(new Texture("imagenes2/emociones/emociones1.png"),0,0,102,102));
		alegre = new Button("a",new TextureRegion(new Texture("imagenes2/emociones/emociones1.png"),507,0,102,102));
		asco = new Button("w",new TextureRegion(new Texture("imagenes2/emociones/emociones1.png"),103,0,100,102));
		enfadado = new Button("e",new TextureRegion(new Texture("imagenes2/emociones/emociones1.png"),204,0,101,102));
		miedo = new Button("m",new TextureRegion(new Texture("imagenes2/emociones/emociones1.png"),305,0,101,102));
		sorpresa = new Button("s",new TextureRegion(new Texture("imagenes2/emociones/emociones1.png"),406,0,101,102));
		colocarBoton(asco,1,numbotones);
		colocarBoton(miedo,2,numbotones);
		colocarBoton(sorpresa,3,numbotones);
		colocarBoton(alegre,4,numbotones);
		colocarBoton(enfadado,5,numbotones);
		colocarBoton(triste,6,numbotones);
		triste.clickListener= new ClickListener(){
			public void clicked(Button b){
				resultado(evaluarRespuesta(codigoActual,b.name));
			}
		};
		alegre.clickListener= new ClickListener(){
			public void clicked(Button b){
				resultado(evaluarRespuesta(codigoActual,b.name));
			}
		};
		asco.clickListener= new ClickListener(){
			public void clicked(Button b){
				resultado(evaluarRespuesta(codigoActual,b.name));
			}
		};
		miedo.clickListener= new ClickListener(){
			public void clicked(Button b){
				resultado(evaluarRespuesta(codigoActual,b.name));
			}
		};
		enfadado.clickListener= new ClickListener(){
			public void clicked(Button b){
				resultado(evaluarRespuesta(codigoActual,b.name));
			}
		};
		sorpresa.clickListener= new ClickListener(){
			public void clicked(Button b){
				resultado(evaluarRespuesta(codigoActual,b.name));
			}
		};
		
	}	
	//TODO hay que hacer el unload!!!
	
	public void colocarBoton(Button b,int actual, int max){
		max=max+1;
		b.y=0;
		b.x=((1024.0f/max)*actual)-(b.width/2);
	}
	
	@Override
	public void Initialize(){
		super.Initialize();
		this.escena.addActor(fondo);
		loadImagen((String)cuadros.keySet().toArray()[this.cuadroActual]);
		this.escena.addActor(caballete);
		this.escena.addActor(asco);
		this.escena.addActor(miedo);
		this.escena.addActor(sorpresa);
		this.escena.addActor(enfadado);
		this.escena.addActor(triste);
		this.escena.addActor(alegre);
	
	}
	public void loadImagen(String nombre){
		cuadro=new Image("cuadro",new TextureRegion(new Texture("imagenes2/emociones/"+nombre+".png"),0,0,764,468));
		cuadro.x=125;
		cuadro.y=106;
		this.escena.addActor(cuadro);
		codigoActual= this.cuadros.get(nombre);
	}
	public boolean evaluarRespuesta(String codigoImagen, String codigoBoton){
		return codigoImagen.equals(codigoBoton);
	}
	public void resultado(boolean correcto){
		if(correcto){
			if(this.cuadroActual+1<this.cuadros.size()){
				this.cuadroActual++;
				this.escena.removeActor(this.cuadro);
				loadImagen((String)cuadros.keySet().toArray()[this.cuadroActual]);
			}else{
				GameGlobals.emocionesFinished=true;
				ScreenManager.getScreenManager().setCurrentScreen("menu");
			}
		}else{
			
		}
	}
}


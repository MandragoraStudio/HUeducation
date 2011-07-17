package juegos.emocionesPintadas;

import java.util.HashMap;
import java.util.Map;

import juegos.Juego;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;


public class EmocionesPintadas extends Juego {
	
	Map<String,String> cuadros = new HashMap<String,String>();
	Image fondo;
	Image cuadro;
	Button triste;
	Button alegre;
	String codigoActual;
	
	public EmocionesPintadas(){
		super();
		cuadros.put("prueba", "a");
	}
	
	@Override
	public void Update(){
		super.Update();
		
	}
	
	@Override
	public void Load(){
		int numbotones =2;
		
		fondo =new Image("fondo",new Texture("imagenes/emociones/fondo.png"));
		triste = new Button("t",new Texture("imagenes/emociones/botones/alegre.png"));
		alegre = new Button("a",new Texture("imagenes/emociones/botones/triste.png"));
		colocarBoton(alegre,1,numbotones);
		colocarBoton(triste,2,numbotones);
		triste.clickListener= new ClickListener(){
			public void clicked(Button b){
				resultado(evaluarRespuesta(codigoActual,b.name));
			}
		};
		alegre.clickListener= new ClickListener(){
			public void clicked(Button b){
				evaluarRespuesta(codigoActual,b.name);
			}
		};
		
	}	
	//TODO hay que hacer el unload!!!
	
	public void colocarBoton(Button b,int actual, int max){
		max=max+1;
		b.y=20;
		b.x=((800.0f/max)*actual)-(b.width/2);
	}
	
	@Override
	public void Initialize(){
		super.Initialize();
		this.escena.addActor(fondo);
		int num = (int)Math.floor(Math.random()*cuadros.size());
		loadImagen((String)cuadros.keySet().toArray()[num]);
		this.escena.addActor(triste);
		this.escena.addActor(alegre);
	
	}
	public void loadImagen(String nombre){
		cuadro=new Image("cuadro",new Texture("imagenes/emociones/"+nombre+".png"));
		cuadro.height=400;
		cuadro.width=600;
		cuadro.x=100;
		cuadro.y=100;
		this.escena.addActor(cuadro);
		codigoActual= cuadros.get(nombre);
	}
	public boolean evaluarRespuesta(String codigoImagen, String codigoBoton){
		return codigoImagen.contains(codigoBoton);
	}
	public void resultado(boolean correcto){
		if(correcto){
			
		}else{
			
		}
	}
}


package juegos.Cuento;

import java.util.List;

import juegos.Juego;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

 
public class CuentoClasico extends Juego {

	private Button abrirCuento;
	private List <Pagina> paginas;
	/*private Button opcionA;
	private Button opcionB;
	private Image cuentoAbierto;*/
	
	private Image fondo;
	
    public CuentoClasico () {
    	
    }
    
    public void Initialize(){
    	super.Initialize();
    	setButtons();
    	fondo = new Image("fondo", new Texture("imagenes/mandragora800.png"));
    	//cuentoAbierto=new Image("cuentoAbierto", new Texture("imagenes/cuento/cuento2.png"));
    }
    
    public void load(){
    	//paginas.add(new Pagina());
    } 

    private void setButtons(){
	abrirCuento = new Button("abrirCuento", new Texture("imagenes/cuento/cuento1.png"));
	abrirCuento.x=400;
	abrirCuento.y=25;
	this.escena.addActor(abrirCuento);
	abrirCuento.clickListener=new ClickListener(){
	
		public void clicked(Button arg0) {
			AbreCuento();
		}};
		
		
		/*opcionA = new Button ("opcionA", new Texture("imagenes/opcionA.png"));
		opcionA.x=400;
		opcionA.y=0;
		opcionA.clickListener=new ClickListener(){
			
			
			public void clicked(Button arg0) {
				Game.salir();
			}};
			
		
		opcionB = new Button ("opcionB", new Texture("imagenes/opcionB.png"));
		opcionB.x=opcionA.x+180;
		opcionB.y=opcionA.y;
		opcionB.clickListener=new ClickListener(){
			
			public void clicked(Button arg0) {
				Game.salir();
		}
		};*/
		}
    public void AbreCuento(){
    	
    	/*this.escena.removeActor(abrirCuento);
    	this.cuentoAbierto.x=0;
    	this.cuentoAbierto.y=0;
    	this.escena.addActor(cuentoAbierto);
    	this.escena.addActor(opcionA);
    	this.escena.addActor(opcionB);*/
    	
    }
    }
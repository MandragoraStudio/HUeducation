package juegos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

 
public class CuentoClasico extends Juego {

	private Button abrirCuento;
	private Button opcionA;
	private Button opcionB;
	private Image cuentoAbierto;
	
    public CuentoClasico () {
    	
    }
    
    public void Initialize(){
    	super.Initialize();
    	setButtons();
    	cuentoAbierto=new Image("imagenes/cuento2.png");
    }
    
    public void load(){
    	
    } 

    private void setButtons(){
	abrirCuento = new Button("abrirCuento", new Texture("imagenes/cuento1.png"));
	abrirCuento.x=0;
	abrirCuento.y=0;
	this.escena.addActor(abrirCuento);
	abrirCuento.clickListener=new ClickListener(){
	
		public void clicked(Button arg0) {
			AbreCuento();
		}};
		
		
		opcionA = new Button ("opcionA", new Texture("imagenes/opcionA.png"));
		opcionA.x=400;
		opcionA.y=0;
		opcionA.clickListener=new ClickListener(){
			
			
			public void clicked(Button arg0) {
				;
			}};
			
		
		opcionB = new Button ("opcionB", new Texture("imagenes/opcionB.png"));
		opcionB.x=opcionA.x+180;
		opcionB.y=opcionA.y;
		opcionB.clickListener=new ClickListener(){
			
			public void clicked(Button arg0) {
		}
		};
		}
    public void AbreCuento(){
    	
    	this.escena.removeActor(abrirCuento);
    	this.cuentoAbierto.x=0;
    	this.cuentoAbierto.y=0;
    	this.escena.addActor(cuentoAbierto);
    	this.escena.addActor(opcionA);
    	this.escena.addActor(opcionB);
    	
    }
    }
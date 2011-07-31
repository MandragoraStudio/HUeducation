  package juegos.Cuento;

import java.util.LinkedList;
import java.util.List;

import principal.ScreenManager;

import juegos.Juego;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

 
public class CuentoClasico extends Juego {

	private Button abrirCuento;
	public static List <Pagina> paginas;
	public static Pagina paginaActual;
	/*private Button opcionA;
	private Button opcionB;
	private Image cuentoAbierto;*/
	
	private Image fondo;
	
    public CuentoClasico () {
    	this.paginas = new LinkedList();
    	load();
    }
    
    public void Initialize(){
    	super.Initialize();
    	fondo = new Image("fondo", new Texture("imagenes/mandragora1024.png"));
    	this.escena.addActor(fondo);
    	setButtons();
    	//cuentoAbierto=new Image("cuentoAbierto", new Texture("imagenes/cuento/cuento2.png"));
    }
    
    public void load(){
    	paginas.add(new Pagina(0, "A", new Image("hoja1", new Texture("imagenes/cuento/pagina1.png")), 
    			new Texture("imagenes/cuento/opcionA.png"), new Texture("imagenes/cuento/opcionB.png"), this));
    	paginas.add(new Pagina(1, "B", new Image("hoja2", new Texture("imagenes/cuento/pagina2.png")), 
    			new Texture("imagenes/cuento/opcionA.png"), new Texture("imagenes/cuento/opcionB.png"), this));
    	paginas.add(new Pagina(2, "B", new Image("hoja3", new Texture("imagenes/cuento/pagina3.png")), 
    			new Texture("imagenes/cuento/opcionA.png"), new Texture("imagenes/cuento/opcionB.png"), this));
    	
    	paginaActual = paginas.get(0);
    } 

    private void setButtons(){
	abrirCuento = new Button("abrirCuento", new Texture("imagenes/cuento/cuento1.png"));
	abrirCuento.x=400;
	abrirCuento.y=25;
	this.escena.addActor(abrirCuento);
	abrirCuento.clickListener=new ClickListener(){
	
		public void clicked(Button arg0) {
			escena.removeActor(abrirCuento);
			escena.removeActor(fondo);
			dibujaPagina();
		}};
    }
    
    public void dibujaPagina(){
    	this.escena.addActor(paginaActual.getOpcA());
    	this.escena.addActor(paginaActual.getOpcB());
    	this.escena.addActor(paginaActual.getHoja());
    }
    public void eliminaPagina(){
    	this.escena.removeActor(paginaActual.getOpcA());
    	this.escena.removeActor(paginaActual.getOpcB());
    	this.escena.removeActor(paginaActual.getHoja());
    }
    public void siguientePagina(){
    	if(paginas.size()-1>paginaActual.getNumPPag()){
    		paginaActual=paginas.get(paginaActual.getNumPPag()+1);
    		eliminaPagina();
    		dibujaPagina();    	
    	}else{
    		ScreenManager.getScreenManager().setCurrentScreen("menu");
    	}
    }   
    }
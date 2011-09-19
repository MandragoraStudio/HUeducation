  package juegos.Cuento;

import java.util.LinkedList;
import java.util.List;

import juegos.Juego;
import principal.ScreenManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
    }
    
    @Override
    public void Initialize(){
    	super.Initialize();
    	fondo = new Image("fondo", new TextureRegion(new Texture("imagenes2/splash/mandragora1024.png"), 0,0,1024,600));
    	this.escena.addActor(fondo);
    	setButtons();
    	//cuentoAbierto=new Image("cuentoAbierto", new Texture("imagenes/cuento/cuento2.png"));
    }
    @Override
    public void Load(){
    	paginas.add(new Pagina(0, "A", new Image("hoja1", new TextureRegion(new Texture("imagenes2/cuento/TextureCuento1.png"),0,0,340,500)), 
    			new TextureRegion(new Texture("imagenes2/cuento/TextureCuento1.png"),0,520,170,500), new TextureRegion(new Texture("imagenes2/cuento/TextureCuento1.png"),170,520,170,500), this));
    	paginas.add(new Pagina(1, "B", new Image("hoja2", new TextureRegion(new Texture("imagenes2/cuento/TextureCuento1.png"),340,0,340,500)), 
    			new TextureRegion(new Texture("imagenes2/cuento/TextureCuento1.png"),0,520,170,500), new TextureRegion(new Texture("imagenes2/cuento/TextureCuento1.png"),170,520,170,500), this));
    	paginas.add(new Pagina(2, "B", new Image("hoja3", new TextureRegion(new Texture("imagenes2/cuento/TextureCuento1.png"),680,0,340,500)), 
    			new TextureRegion(new Texture("imagenes2/cuento/TextureCuento1.png"),0,520,170,500), new TextureRegion(new Texture("imagenes2/cuento/TextureCuento1.png"),170,520,170,500), this));
    	
    	paginaActual = paginas.get(0);
    } 

    private void setButtons(){
	abrirCuento = new Button("abrirCuento", new TextureRegion(new Texture("imagenes2/cuento/TextureCuento2.png"),0,0,360,540));
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
package juegos;

import principal.Arrastable;
import principal.GameGlobals;
import principal.ScreenManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.MoveBy;
import com.badlogic.gdx.scenes.scene2d.actions.MoveTo;
import com.badlogic.gdx.scenes.scene2d.actions.Sequence;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;
import com.badlogic.gdx.scenes.scene2d.actors.Label;

public class Modificalo extends Juego {
	Label chivato;
	
	Image cuadro;
	//Botones ocultos.
	Group menu_modif;
	//Group modif_pelucas;
	Group modif_gafas;
	//Group modif_bigotes;
	
	//Botones principales
	Button salir;
	Button siguiente;
	
	//Botones modificadores cuadro.
	Button pelucas;
	Button gafas;
	Button bigotes;
	
	//Esto debe ser un array
	
	Arrastable gafa1;
	Arrastable gafa2;
	Arrastable gafa3;
	
	Boolean pelus_visi = false;
	Boolean gafas_visi = false;
	Boolean bigos_visi = false;
	
	int pX;
	int pY;
	int i = 0;
	
   
   @Override
	public void Load(){
	    cuadro = new Image("cuadro",new Texture("imagenes/gio.png"));
	    menu_modif = new Group("menu_modif");
	    modif_gafas = new Group("modif_gafas");
	   
    	salir = new Button("sa",new Texture("imagenes/salir.png"));
    	siguiente = new Button("si",new Texture("imagenes/pintar.png"));
    	
    	pelucas = new Button("btn_pelu",new Texture("imagenes/peluca.png"));
    	gafas = new Button("btn_gafa",new Texture("imagenes/gafas.png"));
    	bigotes = new Button("btn_bigo",new Texture("imagenes/bigote.png"));
    	
    	gafa1 = new Arrastable("gafa1",new Texture("imagenes/gafas/gafa1.png"));
    	gafa2 = new Arrastable("gafa2",new Texture("imagenes/gafas/gafa2.png"));
    	gafa3 = new Arrastable("gafa3",new Texture("imagenes/gafas/gafa3.png"));
    	
    	chivato = new Label("c",new BitmapFont(),"chivato");
    	
    	gafas.clickListener=new ClickListener(){

			public void clicked(Button arg0) {
				
				if (gafas_visi == false) {
					modif_gafas.action(MoveTo.$(0,0,1));
					gafas_visi = true;
				} else {
					modif_gafas.action(MoveTo.$(-150,0,1));
					gafas_visi = false;
				}
			}
			
		};
		
		salir.clickListener=new ClickListener(){

			public void clicked(Button arg0) {
				ScreenManager.getScreenManager().setCurrentScreen("menu");
			}
			
		};
    }
    
   public Modificalo () {
   	super();
   }
 
   public void Update () {
   	super.Update(); 
   }
   
	@Override
	public void Initialize(){
		
		super.Initialize();
		
		chivato.x = 0;
		chivato.y = 590;
		
		cuadro.x = 250;
		cuadro.y = 140;
		salir.x = 0;
		salir.y = 0;
		pelucas.x = 240;
		pelucas.y = 0;
		gafas.x = 355;
		gafas.y = 0;
		bigotes.x = 470;
		bigotes.y = 0;
		
		gafa1.y = 450;
		gafa2.y = 340;
		gafa3.y = 230;
		
		
		siguiente.x = 600;
		siguiente.y = 0;
		
		modif_gafas.addActor(gafa1);
		modif_gafas.addActor(gafa2);
		modif_gafas.addActor(gafa3);
		
		modif_gafas.x = -150;
		
		menu_modif.addActor(pelucas);
		menu_modif.addActor(gafas);
		menu_modif.addActor(bigotes);
		
		this.escena.addActor(chivato);
		this.escena.addActor(cuadro);
		this.escena.addActor(modif_gafas);
		this.escena.addActor(menu_modif);
		this.escena.addActor(salir);
		this.escena.addActor(siguiente);
		
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		//menu_modif.x++;
		return super.touchDragged(x, y, pointer);
		
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		chivato.setText("x = " + x + " y = " + (y - GameGlobals.ScreenHeight));
		if (gafa1.pressed) {
			if ((gafa1.x > 350 && gafa1.x < 450) && (gafa1.y > 420 && gafa1.y < 520)) {
				gafa1.action(MoveTo.$(350,450,1));
				if(modif_gafas.getActors().contains(gafa1)) {
					modif_gafas.
					modif_gafas.removeActor(gafa1);
					escena.addActor(gafa1);
					modif_gafas.focus(gafa2, 0);
	
				}
			} else if (gafa1.pressed) {
				gafa1.action(MoveTo.$(0,450,1));
				if(!modif_gafas.getActors().contains(gafa1)) {
					modif_gafas.addActor(gafa1);
					escena.removeActor(gafa1);
				}
			}
		}
		return super.touchUp(x, y, pointer, button);
	}
}



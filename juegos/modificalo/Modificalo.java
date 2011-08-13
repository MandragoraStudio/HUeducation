package juegos.modificalo;

import juegos.Juego;
import principal.Arrastable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.MoveTo;
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

	int pos_ini_1 = 450;
	int pos_ini_2 = 340;
	int pos_ini_3 = 230;
	
   
   @Override
	public void Load(){
	    cuadro = new Image("cuadro",new Texture("imagenes/modificalo/gio.png"));
	    menu_modif = new Group("menu_modif");
	    modif_gafas = new Group("modif_gafas");
	   
    	salir = new Button("sa",new Texture("imagenes/salir.png"));
    	siguiente = new Button("si",new Texture("imagenes/salir.png"));
    	
    	pelucas = new Button("btn_pelu",new Texture("imagenes/modificalo/peluca.png"));
    	gafas = new Button("btn_gafa",new Texture("imagenes/modificalo/gafas.png"));
    	bigotes = new Button("btn_bigo",new Texture("imagenes/modificalo/bigote.png"));
    	
    	gafa1 = new Arrastable("gafa1",new Texture("imagenes/modificalo/gafas/gafa1.png"));
    	gafa2 = new Arrastable("gafa2",new Texture("imagenes/modificalo/gafas/gafa2.png"));
    	gafa3 = new Arrastable("gafa3",new Texture("imagenes/modificalo/gafas/gafa3.png"));
    	
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
		
		gafa1.y = pos_ini_1;
		gafa2.y = pos_ini_2;
		gafa3.y = pos_ini_3;
		
		
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
		return super.touchDragged(x, y, pointer);
		
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		
		if (gafa1.pressed) {
			if ((gafa1.x > 350 && gafa1.x < 450) && (gafa1.y > 420 && gafa1.y < 520)) {
				gafa1.action(MoveTo.$(350,450,1));
				if(modif_gafas.getActors().contains(gafa1)) {
					recolocar("gafa");
					modif_gafas.removeActor(gafa1);
					escena.addActor(gafa1);
					gafa1.pressed=false;
					modif_gafas.focus(null, 0);
				}
			} else if (gafa1.pressed) {
				reubicarElemento(gafa1);
				if(!modif_gafas.getActors().contains(gafa1)) {
					modif_gafas.addActor(gafa1);
					escena.removeActor(gafa1);
				}
			}
		}
		
		if (gafa2.pressed) {
			if ((gafa2.x > 350 && gafa2.x < 450) && (gafa2.y > 420 && gafa2.y < 520)) {
				gafa2.action(MoveTo.$(350,450,1));
				if(modif_gafas.getActors().contains(gafa2)) {
					recolocar("gafa");
					modif_gafas.removeActor(gafa2);
					escena.addActor(gafa2);
					gafa2.pressed=false;
					modif_gafas.focus(null, 0);
				}
			} else if (gafa2.pressed) {
				reubicarElemento(gafa2);
				if(!modif_gafas.getActors().contains(gafa2)) {
					modif_gafas.addActor(gafa2);
					escena.removeActor(gafa2);
				}
			}
		}
		
		if (gafa3.pressed) {
			if ((gafa3.x > 350 && gafa3.x < 450) && (gafa3.y > 420 && gafa3.y < 520)) {
				gafa3.action(MoveTo.$(350,450,1));
				if(modif_gafas.getActors().contains(gafa3)) {
					recolocar("gafa");
					modif_gafas.removeActor(gafa3);
					escena.addActor(gafa3);
					gafa3.pressed=false;
					modif_gafas.focus(null, 0);
				}
			} else if (gafa3.pressed) {
				reubicarElemento(gafa3);
				if(!modif_gafas.getActors().contains(gafa3)) {
					modif_gafas.addActor(gafa3);
					escena.removeActor(gafa3);
				}
			}
		}
		
		return super.touchUp(x, y, pointer, button);
	}
	
	public void recolocar(String nombre) {
		String nombre_F;
		Actor actor;
		int i;
			for(i = 1; i <= 3; i++) {
			nombre_F =  nombre  + i;
			actor = escena.findActor(nombre_F);
			if(!modif_gafas.getActors().contains(actor)) {
				modif_gafas.addActor(actor);
				escena.removeActor(actor);
				reubicarElemento(actor);
			}
		}
	}
	
	public void reubicarElemento(Actor actor) {
		if (actor.equals(gafa1)) {
			gafa1.action(MoveTo.$(0,450,1));
		}
		if (actor.equals(gafa2)) {
			gafa2.action(MoveTo.$(0,340,1));
		}
		if (actor.equals(gafa3)) {
			gafa3.action(MoveTo.$(0,230,1));
		}
	}
}



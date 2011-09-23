package juegos.modificalo;

import juegos.Juego;
import principal.Arrastrable;

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
	//Group modif_gafas;
	Group modif_gafas;
	//Group modif_bigotes;
	Group modif_bigos;
	//Group modif_pelucas;
	Group modif_pelucas;
	//Group modif_collares;
	Group modif_collares;
	//Group modif_collares;
	Group modif_objetos;
	
	//Botones principales
	Button salir;
	
	//Botones modificadores cuadro.
	Button pelucas;
	Button gafas;
	Button bigotes;
	Button collares;
	Button objetos;
	
	Arrastrable gafa1;
	Arrastrable gafa2;
	Arrastrable gafa3;
	
	Arrastrable bigote1;
	Arrastrable bigote2;
	Arrastrable bigote3;
	
	Arrastrable peluca1;
	Arrastrable peluca2;
	Arrastrable peluca3;
	
	Arrastrable collar1;
	Arrastrable collar2;
	Arrastrable collar3;
	
	Arrastrable objeto1;
	Arrastrable objeto2;
	Arrastrable objeto3;
	
	Boolean gafas_visi = false;
	Boolean bigos_visi = false;
	Boolean pelus_visi = false;
	Boolean collar_visi = false;
	Boolean objetos_visi = false;

	int pos_ini_1 = 380;
	int pos_ini_2 = 180;
	int pos_ini_3 = 0;
	
	int num_cuadro;
	
	PCuadro pCuadro;
	
   
   @Override
	public void Load(){
	   	if (num_cuadro == 1) {
	   		cuadro = new Image("cuadro",new Texture("imagenes/modificalo/cuadro1.png"));
	   	}
		if (num_cuadro == 2) {
	   		cuadro = new Image("cuadro",new Texture("imagenes/modificalo/cuadro2.png"));
	   	}
		
   		pCuadro = new PCuadro(num_cuadro);
	    
	    menu_modif = new Group("menu_modif");
	    modif_gafas = new Group("modif_gafas");
	    modif_bigos = new Group("modif_bigos");
	    modif_pelucas = new Group("modif_pelucas");
	    modif_collares = new Group("modif_collares");
	    modif_objetos = new Group("modif_objetos");
	   
    	salir = new Button("sa",new Texture("imagenes/salir.png"));
    	
    	pelucas = new Button("btn_pelu",new Texture("imagenes/modificalo/peluca.png"));
    	gafas = new Button("btn_gafa",new Texture("imagenes/modificalo/gafas.png"));
    	bigotes = new Button("btn_bigo",new Texture("imagenes/modificalo/bigote.png"));
    	collares = new Button("btn_collar",new Texture("imagenes/modificalo/collar.jpg"));
    	objetos = new Button("btn_objto",new Texture("imagenes/modificalo/objeto.jpg"));
    	
    	gafa1 = new Arrastrable("gafa1",new Texture("imagenes/modificalo/gafas/gafa1.png"));
    	gafa2 = new Arrastrable("gafa2",new Texture("imagenes/modificalo/gafas/gafa2.png"));
    	gafa3 = new Arrastrable("gafa3",new Texture("imagenes/modificalo/gafas/gafa3.png"));
    	
    	bigote1 = new Arrastrable("bigote1",new Texture("imagenes/modificalo/bigotes/bigote1.png"));
    	bigote2 = new Arrastrable("bigote2",new Texture("imagenes/modificalo/bigotes/bigote2.png"));
    	bigote3 = new Arrastrable("bigote3",new Texture("imagenes/modificalo/bigotes/bigote3.png"));
    	
    	peluca1 = new Arrastrable("peluca1",new Texture("imagenes/modificalo/pelucas/peluca1.png"));
    	peluca2 = new Arrastrable("peluca2",new Texture("imagenes/modificalo/pelucas/peluca2.png"));
    	peluca3 = new Arrastrable("peluca3",new Texture("imagenes/modificalo/pelucas/peluca3.png"));
    	
    	collar1 = new Arrastrable("collar1",new Texture("imagenes/modificalo/collares/collar1.png"));
    	collar2 = new Arrastrable("collar2",new Texture("imagenes/modificalo/collares/collar2.png"));
    	collar3 = new Arrastrable("collar3",new Texture("imagenes/modificalo/collares/collar3.png"));
    	
    	objeto1 = new Arrastrable("objeto1",new Texture("imagenes/modificalo/objetos/objeto1.png"));
    	objeto2 = new Arrastrable("objeto2",new Texture("imagenes/modificalo/objetos/objeto2.png"));
    	objeto3 = new Arrastrable("objeto3",new Texture("imagenes/modificalo/objetos/objeto3.png"));
    	
    	chivato = new Label("c",new BitmapFont(),"chivato");
    	
    	bigotes.clickListener=new ClickListener(){
			public void clicked(Button arg0) {	
				if (bigos_visi == false) {
					esconderGrupos("bigos");
					bigos_visi = true;
				} else {
					modif_bigos.action(MoveTo.$(-180,0,1));
					bigos_visi = false;
				}
			}
		};
		
		gafas.clickListener=new ClickListener(){
			public void clicked(Button arg0) {	
				if (gafas_visi == false) {
					esconderGrupos("gafas");
					gafas_visi = true;
				} else {
					modif_gafas.action(MoveTo.$(-180,0,1));
					gafas_visi = false;
				}
			}
		};
		
		pelucas.clickListener=new ClickListener(){
			public void clicked(Button arg0) {	
				if (pelus_visi == false) {
					esconderGrupos("pelucas");
					pelus_visi = true;
				} else {
					modif_pelucas.action(MoveTo.$(-180,0,1));
					pelus_visi = false;
				}
			}
		};
		
		collares.clickListener=new ClickListener(){
			public void clicked(Button arg0) {	
				if (collar_visi == false) {
					esconderGrupos("collares");
					collar_visi = true;
				} else {
					modif_collares.action(MoveTo.$(-180,0,1));
					collar_visi = false;
				}
			}
		};
		
		objetos.clickListener=new ClickListener(){
			public void clicked(Button arg0) {	
				if (objetos_visi == false) {
					esconderGrupos("objetos");
					objetos_visi = true;
				} else {
					modif_objetos.action(MoveTo.$(-180,0,1));
					objetos_visi = false;
				}
			}
		};
    }
   
   public void esconderGrupos(String nom) {
	   if (nom == "gafas") {
		   modif_gafas.action(MoveTo.$(0,0,1));
		   modif_bigos.action(MoveTo.$(-180,0,1));
		   modif_pelucas.action(MoveTo.$(-180,0,1));
		   modif_collares.action(MoveTo.$(-180,0,1));
		   modif_objetos.action(MoveTo.$(-180,0,1));
		   bigos_visi = false;
		   pelus_visi = false;
		   collar_visi = false;
		   objetos_visi = false;
	   }
	   if (nom == "bigos") {
		   modif_bigos.action(MoveTo.$(0,0,1));
		   modif_gafas.action(MoveTo.$(-180,0,1));
		   modif_pelucas.action(MoveTo.$(-180,0,1));
		   modif_collares.action(MoveTo.$(-180,0,1));
		   modif_objetos.action(MoveTo.$(-180,0,1));
		   gafas_visi = false;
		   pelus_visi = false;
		   collar_visi = false;
		   objetos_visi = false;
	   }
	   if (nom == "pelucas") {
		   modif_pelucas.action(MoveTo.$(0,0,1));
		   modif_gafas.action(MoveTo.$(-180,0,1));
		   modif_bigos.action(MoveTo.$(-180,0,1));
		   modif_collares.action(MoveTo.$(-180,0,1));
		   modif_objetos.action(MoveTo.$(-180,0,1));
		   gafas_visi = false;
		   bigos_visi = false;
		   collar_visi = false;
		   objetos_visi = false;
	   }
	   if (nom == "collares") {
		   modif_collares.action(MoveTo.$(0,0,1));
		   modif_gafas.action(MoveTo.$(-180,0,1));
		   modif_bigos.action(MoveTo.$(-180,0,1));
		   modif_pelucas.action(MoveTo.$(-180,0,1));
		   modif_objetos.action(MoveTo.$(-180,0,1));
		   gafas_visi = false;
		   bigos_visi = false;
		   objetos_visi = false;
		   pelus_visi = false;
	   }
	   if (nom == "objetos") {
		   modif_objetos.action(MoveTo.$(0,0,1));
		   modif_gafas.action(MoveTo.$(-180,0,1));
		   modif_bigos.action(MoveTo.$(-180,0,1));
		   modif_pelucas.action(MoveTo.$(-180,0,1));
		   modif_collares.action(MoveTo.$(-180,0,1));
		   gafas_visi = false;
		   bigos_visi = false;
		   pelus_visi = false;
		   collar_visi = false;
	   }
   }
    
   public Modificalo (int c) {
	   super();
	   this.num_cuadro = c;
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
		
		chivato.setText(num_cuadro + "");
		
		cuadro.x = 250;
		cuadro.y = 90;
		salir.x = 824;
		salir.y = 0;
		pelucas.x = 240;
		pelucas.y = 0;
		gafas.x = 355;
		gafas.y = 0;
		bigotes.x = 470;
		bigotes.y = 0;
		collares.x = 585;
		collares.y = 0;
		objetos.x = 700;
		objetos.y = 0;
		
		gafa1.y = pos_ini_1;
		gafa2.y = pos_ini_2;
		gafa3.y = pos_ini_3;
		
		bigote1.y = pos_ini_1;
		bigote2.y = pos_ini_2;
		bigote3.y = pos_ini_3;
		
		peluca1.y = pos_ini_1;
		peluca2.y = pos_ini_2;
		peluca3.y = pos_ini_3;
		
		collar1.y = pos_ini_1;
		collar2.y = pos_ini_2;
		collar3.y = pos_ini_3;
		
		objeto1.y = pos_ini_1;
		objeto2.y = pos_ini_2;
		objeto3.y = pos_ini_3;
		
		modif_gafas.addActor(gafa1);
		modif_gafas.addActor(gafa2);
		modif_gafas.addActor(gafa3);
		
		modif_bigos.addActor(bigote1);
		modif_bigos.addActor(bigote2);
		modif_bigos.addActor(bigote3);
		
		modif_pelucas.addActor(peluca1);
		modif_pelucas.addActor(peluca2);
		modif_pelucas.addActor(peluca3);
		
		modif_collares.addActor(collar1);
		modif_collares.addActor(collar2);
		modif_collares.addActor(collar3);
		
		modif_objetos.addActor(objeto1);
		modif_objetos.addActor(objeto2);
		modif_objetos.addActor(objeto3);
		
		modif_gafas.x = -180;
		modif_bigos.x = -180;
		modif_pelucas.x = -180;
		modif_collares.x = -180;
		modif_objetos.x = -180;
		
		menu_modif.addActor(pelucas);
		menu_modif.addActor(gafas);
		menu_modif.addActor(bigotes);
		menu_modif.addActor(collares);
		menu_modif.addActor(objetos);
		
		this.escena.addActor(cuadro);
		this.escena.addActor(modif_gafas);
		this.escena.addActor(modif_bigos);
		this.escena.addActor(modif_pelucas);
		this.escena.addActor(modif_collares);
		this.escena.addActor(modif_objetos);
		this.escena.addActor(menu_modif);
		this.escena.addActor(salir);
		
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		return super.touchDragged(x, y, pointer);
		
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		
		//GAFAS*****************************************************
		if (gafa1.pressed) {
			if ((gafa1.x > pCuadro.uGafa.mx1 && gafa1.x < pCuadro.uGafa.mx2) && (gafa1.y > pCuadro.uGafa.my1 && gafa1.y < pCuadro.uGafa.my2)) {
				gafa1.action(MoveTo.$(pCuadro.uGafa.xF,pCuadro.uGafa.yF,1));
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
			if ((gafa2.x > pCuadro.uGafa.mx1 && gafa2.x < pCuadro.uGafa.mx2) && (gafa2.y > pCuadro.uGafa.my1 && gafa2.y < pCuadro.uGafa.my2)) {
				gafa2.action(MoveTo.$(pCuadro.uGafa.xF,pCuadro.uGafa.yF,1));
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
			if ((gafa3.x > pCuadro.uGafa.mx1 && gafa3.x < pCuadro.uGafa.mx2) && (gafa3.y > pCuadro.uGafa.my1 && gafa3.y < pCuadro.uGafa.my2)) {
				gafa3.action(MoveTo.$(pCuadro.uGafa.xF,pCuadro.uGafa.yF,1));
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
		//GAFAS*****************************************************
		
		//BIGOTES***************************************************
		if (bigote1.pressed) {
			if ((bigote1.x > pCuadro.uBigote.mx1 && bigote1.x < pCuadro.uBigote.mx2) && (bigote1.y > pCuadro.uBigote.my1 && bigote1.y < pCuadro.uBigote.my2)) {
				bigote1.action(MoveTo.$(pCuadro.uBigote.xF,pCuadro.uBigote.yF,1));
				if(modif_bigos.getActors().contains(bigote1)) {
					recolocar("bigote");
					modif_bigos.removeActor(bigote1);
					escena.addActor(bigote1);
					bigote1.pressed=false;
					modif_bigos.focus(null, 0);
				}
			} else if (bigote1.pressed) {
				reubicarElemento(bigote1);
				if(!modif_bigos.getActors().contains(bigote1)) {
					modif_bigos.addActor(bigote1);
					escena.removeActor(bigote1);
				}
			}
		}
		
		if (bigote2.pressed) {
			if ((bigote2.x > pCuadro.uBigote.mx1 && bigote2.x < pCuadro.uBigote.mx2) && (bigote2.y > pCuadro.uBigote.my1 && bigote2.y < pCuadro.uBigote.my2)) {
				bigote2.action(MoveTo.$(pCuadro.uBigote.xF,pCuadro.uBigote.yF,1));
				if(modif_bigos.getActors().contains(bigote2)) {
					recolocar("bigote");
					modif_bigos.removeActor(bigote2);
					escena.addActor(bigote2);
					bigote2.pressed=false;
					modif_bigos.focus(null, 0);
				}
			} else if (bigote2.pressed) {
				reubicarElemento(bigote2);
				if(!modif_bigos.getActors().contains(bigote2)) {
					modif_bigos.addActor(bigote2);
					escena.removeActor(bigote2);
				}
			}
		}
		
		if (bigote3.pressed) {
			if ((bigote3.x > pCuadro.uBigote.mx1 && bigote3.x < pCuadro.uBigote.mx2) && (bigote3.y > pCuadro.uBigote.my1 && bigote3.y < pCuadro.uBigote.my2)) {
				bigote3.action(MoveTo.$(pCuadro.uBigote.xF,pCuadro.uBigote.yF,1));
				if(modif_bigos.getActors().contains(bigote3)) {
					recolocar("bigote");
					modif_bigos.removeActor(bigote3);
					escena.addActor(bigote3);
					bigote3.pressed=false;
					modif_bigos.focus(null, 0);
				}
			} else if (bigote3.pressed) {
				reubicarElemento(bigote3);
				if(!modif_bigos.getActors().contains(bigote3)) {
					modif_bigos.addActor(bigote3);
					escena.removeActor(bigote3);
				}
			}
		}
		//BIGOTES***************************************************
		
		
		//PELUCAS***************************************************
		if (peluca1.pressed) {
			if ((peluca1.x > pCuadro.uPeluca.mx1 && peluca1.x < pCuadro.uPeluca.mx2) && (peluca1.y > pCuadro.uPeluca.my1 && peluca1.y < pCuadro.uPeluca.my2)) {
				peluca1.action(MoveTo.$(pCuadro.uPeluca.xF,pCuadro.uPeluca.yF,1));
				if(modif_pelucas.getActors().contains(peluca1)) {
					recolocar("peluca");
					modif_pelucas.removeActor(peluca1);
					escena.addActor(peluca1);
					peluca1.pressed=false;
					modif_pelucas.focus(null, 0);
				}
			} else if (peluca1.pressed) {
				reubicarElemento(peluca1);
				if(!modif_pelucas.getActors().contains(peluca1)) {
					modif_pelucas.addActor(peluca1);
					escena.removeActor(peluca1);
				}
			}
		}
		
		if (peluca2.pressed) {
			if ((peluca2.x > pCuadro.uPeluca.mx1 && peluca2.x < pCuadro.uPeluca.mx2) && (peluca2.y > pCuadro.uPeluca.my1 && peluca2.y < pCuadro.uPeluca.my2)) {
				peluca2.action(MoveTo.$(pCuadro.uPeluca.xF,pCuadro.uPeluca.yF,1));
				if(modif_pelucas.getActors().contains(peluca2)) {
					recolocar("peluca");
					modif_pelucas.removeActor(peluca2);
					escena.addActor(peluca2);
					peluca2.pressed=false;
					modif_pelucas.focus(null, 0);
				}
			} else if (peluca2.pressed) {
				reubicarElemento(peluca2);
				if(!modif_pelucas.getActors().contains(peluca2)) {
					modif_pelucas.addActor(peluca2);
					escena.removeActor(peluca2);
				}
			}
		}
		
		if (peluca3.pressed) {
			if ((peluca3.x > pCuadro.uPeluca.mx1 && peluca3.x < pCuadro.uPeluca.mx2) && (peluca3.y > pCuadro.uPeluca.my1 && peluca3.y < pCuadro.uPeluca.my2)) {
				peluca3.action(MoveTo.$(pCuadro.uPeluca.xF,pCuadro.uPeluca.yF,1));
				if(modif_pelucas.getActors().contains(peluca3)) {
					recolocar("peluca");
					modif_pelucas.removeActor(peluca3);
					escena.addActor(peluca3);
					peluca3.pressed=false;
					modif_pelucas.focus(null, 0);
				}
			} else if (peluca3.pressed) {
				reubicarElemento(peluca3);
				if(!modif_pelucas.getActors().contains(peluca3)) {
					modif_pelucas.addActor(peluca3);
					escena.removeActor(peluca3);
				}
			}
		}
		//PELUCAS***************************************************
		
		//COLLARES**************************************************
		if (collar1.pressed) {
			if ((collar1.x > pCuadro.uCollar.mx1 && collar1.x < pCuadro.uCollar.mx2) && (collar1.y > pCuadro.uCollar.my1 && collar1.y < pCuadro.uCollar.my2)) {
				collar1.action(MoveTo.$(pCuadro.uCollar.xF,pCuadro.uCollar.yF,1));
				if(modif_collares.getActors().contains(collar1)) {
					recolocar("collar");
					modif_collares.removeActor(collar1);
					escena.addActor(collar1);
					collar1.pressed=false;
					modif_collares.focus(null, 0);
				}
			} else if (collar1.pressed) {
				reubicarElemento(collar1);
				if(!modif_collares.getActors().contains(collar1)) {
					modif_collares.addActor(collar1);
					escena.removeActor(collar1);
				}
			}
		}
		
		if (collar2.pressed) {
			if ((collar2.x > pCuadro.uCollar.mx1 && collar2.x < pCuadro.uCollar.mx2) && (collar2.y > pCuadro.uCollar.my1 && collar2.y < pCuadro.uCollar.my2)) {
				collar2.action(MoveTo.$(pCuadro.uCollar.xF,pCuadro.uCollar.yF,1));
				if(modif_collares.getActors().contains(collar2)) {
					recolocar("collar");
					modif_collares.removeActor(collar2);
					escena.addActor(collar2);
					collar2.pressed=false;
					modif_collares.focus(null, 0);
				}
			} else if (collar2.pressed) {
				reubicarElemento(collar2);
				if(!modif_collares.getActors().contains(collar2)) {
					modif_collares.addActor(collar2);
					escena.removeActor(collar2);
				}
			}
		}
		
		if (collar3.pressed) {
			if ((collar3.x > pCuadro.uCollar.mx1 && collar3.x < pCuadro.uCollar.mx2) && (collar3.y > pCuadro.uCollar.my1 && collar3.y < pCuadro.uCollar.my2)) {
				collar3.action(MoveTo.$(pCuadro.uCollar.xF,pCuadro.uCollar.yF,1));
				if(modif_collares.getActors().contains(collar3)) {
					recolocar("collar");
					modif_collares.removeActor(collar3);
					escena.addActor(collar3);
					collar3.pressed=false;
					modif_collares.focus(null, 0);
				}
			} else if (collar3.pressed) {
				reubicarElemento(collar3);
				if(!modif_collares.getActors().contains(collar3)) {
					modif_collares.addActor(collar3);
					escena.removeActor(collar3);
				}
			}
		}
		//COLLARES***************************************************
		
		//OBJETOS****************************************************
		if (objeto1.pressed) {
			if ((objeto1.x > pCuadro.uObjeto.mx1 && objeto1.x < pCuadro.uObjeto.mx2) && (objeto1.y > pCuadro.uObjeto.my1 && objeto1.y < pCuadro.uObjeto.my2)) {
				objeto1.action(MoveTo.$(pCuadro.uObjeto.xF,pCuadro.uObjeto.yF,1));
				if(modif_objetos.getActors().contains(objeto1)) {
					recolocar("objeto");
					modif_objetos.removeActor(objeto1);
					escena.addActor(objeto1);
					objeto1.pressed=false;
					modif_objetos.focus(null, 0);
				}
			} else if (objeto1.pressed) {
				reubicarElemento(objeto1);
				if(!modif_objetos.getActors().contains(objeto1)) {
					modif_objetos.addActor(objeto1);
					escena.removeActor(objeto1);
				}
			}
		}
		
		if (objeto2.pressed) {
			if ((objeto2.x > pCuadro.uObjeto.mx1 && objeto2.x < pCuadro.uObjeto.mx2) && (objeto2.y > pCuadro.uObjeto.my1 && objeto2.y < pCuadro.uObjeto.my2)) {
				objeto2.action(MoveTo.$(pCuadro.uObjeto.xF,pCuadro.uObjeto.yF,1));
				if(modif_objetos.getActors().contains(objeto2)) {
					recolocar("objeto");
					modif_objetos.removeActor(objeto2);
					escena.addActor(objeto2);
					objeto2.pressed=false;
					modif_objetos.focus(null, 0);
				}
			} else if (objeto2.pressed) {
				reubicarElemento(objeto2);
				if(!modif_objetos.getActors().contains(objeto2)) {
					modif_objetos.addActor(objeto2);
					escena.removeActor(objeto2);
				}
			}
		}
		
		if (objeto3.pressed) {
			if ((objeto3.x > pCuadro.uObjeto.mx1 && objeto3.x < pCuadro.uObjeto.mx2) && (objeto3.y > pCuadro.uObjeto.my1 && objeto3.y < pCuadro.uObjeto.my2)) {
				objeto3.action(MoveTo.$(pCuadro.uObjeto.xF,pCuadro.uObjeto.yF,1));
				if(modif_objetos.getActors().contains(objeto3)) {
					recolocar("objeto");
					modif_objetos.removeActor(objeto3);
					escena.addActor(objeto3);
					objeto3.pressed=false;
					modif_objetos.focus(null, 0);
				}
			} else if (objeto3.pressed) {
				reubicarElemento(objeto3);
				if(!modif_objetos.getActors().contains(objeto3)) {
					modif_objetos.addActor(objeto3);
					escena.removeActor(objeto3);
				}
			}
		}
		//OBJETOS***************************************************
		
		return super.touchUp(x, y, pointer, button);
	}
	
	
	//Busca los elemntos movidos para colocarlos en su posicion original.
	public void recolocar(String nombre) {
		String nombre_F;
		Actor actor;
		int i;
			for(i = 1; i <= 3; i++) {
			nombre_F =  nombre  + i;
			actor = escena.findActor(nombre_F);
			if (nombre == "gafa") {
				if(!modif_gafas.getActors().contains(actor)) {
					modif_gafas.addActor(actor);
					escena.removeActor(actor);
					reubicarElemento(actor);
				}
			}
			if (nombre == "bigote") {
				if (!modif_bigos.getActors().contains(actor)) {
					modif_bigos.addActor(actor);
					escena.removeActor(actor);
					reubicarElemento(actor);
				}
			}
			
			if (nombre == "peluca") {
				if (!modif_pelucas.getActors().contains(actor)) {
					modif_pelucas.addActor(actor);
					escena.removeActor(actor);
					reubicarElemento(actor);
				}
			}
			
			if (nombre == "collar") {
				if (!modif_collares.getActors().contains(actor)) {
					modif_collares.addActor(actor);
					escena.removeActor(actor);
					reubicarElemento(actor);
				}
			}
			
			if (nombre == "objeto") {
				if (!modif_objetos.getActors().contains(actor)) {
					modif_objetos.addActor(actor);
					escena.removeActor(actor);
					reubicarElemento(actor);
				}
			}
		}
	}
	
	//Recoloca los elementos en su posicion original.
	public void reubicarElemento(Actor actor) {
		
		//elementos gafas
		if (actor.equals(gafa1)) {
			gafa1.action(MoveTo.$(0,380,1));
		}
		if (actor.equals(gafa2)) {
			gafa2.action(MoveTo.$(0,180,1));
		}
		if (actor.equals(gafa3)) {
			gafa3.action(MoveTo.$(0,0,1));
		}
		
		//elementos bigotes.
		if (actor.equals(bigote1)) {
			bigote1.action(MoveTo.$(0,380,1));
		}
		if (actor.equals(bigote2)) {
			bigote2.action(MoveTo.$(0,180,1));
		}
		if (actor.equals(bigote3)) {
			bigote3.action(MoveTo.$(0,0,1));
		}
		
		//elementos pelucas.
		if (actor.equals(peluca1)) {
			peluca1.action(MoveTo.$(0,380,1));
		}
		if (actor.equals(peluca2)) {
			peluca2.action(MoveTo.$(0,180,1));
		}
		if (actor.equals(peluca3)) {
			peluca3.action(MoveTo.$(0,0,1));
		}

		//elementos collares.
		if (actor.equals(collar1)) {
			collar1.action(MoveTo.$(0,380,1));
		}
		if (actor.equals(collar2)) {
			collar2.action(MoveTo.$(0,180,1));
		}
		if (actor.equals(collar3)) {
			collar3.action(MoveTo.$(0,0,1));
		}
		
		//elementos objetos.
		if (actor.equals(objeto1)) {
			objeto1.action(MoveTo.$(0,380,1));
		}
		if (actor.equals(objeto2)) {
			objeto2.action(MoveTo.$(0,180,1));
		}
		if (actor.equals(objeto3)) {
			objeto3.action(MoveTo.$(0,0,1));
		}
		
		
	}
}



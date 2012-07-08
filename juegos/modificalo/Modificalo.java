package juegos.modificalo;

import juegos.Juego;
import principal.Arrastrable;
import principal.GameGlobals;
import principal.ScreenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.MoveTo;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;
import com.badlogic.gdx.scenes.scene2d.actors.Label;

public class Modificalo extends Juego {
	
	Image fondo;
	Image cuadro;
	Image sub_menu;
	Image panel;
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
	Button guardar;
	
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

	//Altura de los objetos arrastrables en su panel
	int pos_ini_1_p = 380;
	int pos_ini_2_p = 180;
	int pos_ini_3_p = 0;
	
	int pos_ini_1_b= 470;
	int pos_ini_2_b = 290;
	int pos_ini_3_b = 90;
	
	int pos_ini_1_c = 440;
	int pos_ini_2_c = 260;
	int pos_ini_3_c = 80;
	
	int pos_ini_1_g = 460;
	int pos_ini_2_g = 280;
	int pos_ini_3_g = 90;
	
	int pos_ini_1_o = 430;
	int pos_ini_2_o = 230;
	int pos_ini_3_o = 40;
	
	int num_cuadro;
	
	PCuadro pCuadro;
	
	private Button BAtras;
	
	// Ardilla
	private int i = 0;
	private int j = 0;

	private Music[] take = new Music[6];
	int indice = 0;
	int MAXtakes = 6;
	int Xardilla = GameGlobals.posXardilla;
	int Yardilla = GameGlobals.posYardilla;
	
	private long tiempoSalida = 700;
	private boolean saliendo = false;
	
	boolean reproducir = true;
	
	private Music genial;
	
	boolean ganaNuez = false;
	
	boolean gUsado = false;
	boolean cUsado = false;
	boolean oUsado = false;
    boolean pUsado = false;
    boolean bUsado = false;

   
   @Override
	public void Load(){
	   
	   
	   	if (num_cuadro == 1) {
	   		//texturas de los objetos para el cuadro uno y el cuadro
	   		cuadro = new Image("cuadro",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),0,0,318,484));
	   		
	   		gafa1 = new Arrastrable("gafa1",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),247,0,120,59));
	    	gafa2 = new Arrastrable("gafa2",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),247,61,120,59));
	    	gafa3 = new Arrastrable("gafa3",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),247,122,120,59));
	    	
	    	bigote1 = new Arrastrable("bigote1",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),174,0,69,36));
	    	bigote2 = new Arrastrable("bigote2",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),174,38,69,36));
	    	bigote3 = new Arrastrable("bigote3",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),174,76,69,36));
	    	
	    	peluca1 = new Arrastrable("peluca1",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),0,0,164,215));
	    	peluca2 = new Arrastrable("peluca2",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),0,215,164,215));
	    	peluca3 = new Arrastrable("peluca3",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),0,430,164,215));
	    	
	    	collar1 = new Arrastrable("collar1",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),384,5,110,91));
	    	collar2 = new Arrastrable("collar2",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),384,98,110,91));
	    	collar3 = new Arrastrable("collar3",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),384,193,110,91));
	    	
	    	objeto1 = new Arrastrable("objeto1",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),220,207,147,127));
	    	objeto2 = new Arrastrable("objeto2",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),220,342,147,127));
	    	objeto3 = new Arrastrable("objeto3",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),220,480,147,127));
	    	
	   	}
	   	
		if (num_cuadro == 2) {
			//texturas de los objetos para el cuadro dos y el cuadro
	   		cuadro = new Image("cuadro",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),318,0,318,484));
	   		
	   		gafa1 = new Arrastrable("gafa1",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),509,280,169,54));
	    	gafa2 = new Arrastrable("gafa2",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),681,280,169,54));
	    	gafa3 = new Arrastrable("gafa3",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),852,280,169,54));
	    	
	    	objeto1 = new Arrastrable("objeto1",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),511,334,171,196));
	    	objeto2 = new Arrastrable("objeto2",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),680,334,171,196));
	    	objeto3 = new Arrastrable("objeto3",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),852,334,171,196));

	    	peluca1 = new Arrastrable("peluca1",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),508,0,171,259));
	    	peluca2 = new Arrastrable("peluca2",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),681,0,171,259));
	    	peluca3 = new Arrastrable("peluca3",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),852,0,171,259));
	    	
	    	
	    	collar1 = new Arrastrable("collar1",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),0,840,118,97));
	    	collar2 = new Arrastrable("collar2",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),118,840,118,97));
	    	collar3 = new Arrastrable("collar3",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),236,840,118,97));
	    	
	    	bigote1 = new Arrastrable("bigote1",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),0,706,109,107));
	    	bigote2 = new Arrastrable("bigote2",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),109,706,109,107));
	    	bigote3 = new Arrastrable("bigote3",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro1.png"),218,706,109,107));
	    	
	    	pos_ini_1_p = 325;
	    	pos_ini_2_p = 170;
	    	pos_ini_3_p = 15;
	    	
	    	pos_ini_1_g = 460;
	    	pos_ini_2_g = 280;
	    	pos_ini_3_g = 90;
	    	
	    	pos_ini_1_o = 430;
	    	pos_ini_2_o = 230;
	    	pos_ini_3_o = 40;
	    	
	    	pos_ini_1_c = 440;
	    	pos_ini_2_c = 260;
	    	pos_ini_3_c = 80;
	    	
	    	pos_ini_1_b= 440;
	    	pos_ini_2_b = 250;
	    	pos_ini_3_b = 60;
	    	
	    	
	   	}
		
		//Fondo de juego
		fondo = new Image("fondo",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro3.png"),0,0,1024,600));
   		pCuadro = new PCuadro(num_cuadro);
   		
   		sub_menu = new Image("sub_menu",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),636,0,260,600));
   		panel = new Image("panel",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),10,486,308,295));
	    
	    menu_modif = new Group("menu_modif");
	    modif_gafas = new Group("modif_gafas");
	    modif_bigos = new Group("modif_bigos");
	    modif_pelucas = new Group("modif_pelucas");
	    modif_collares = new Group("modif_collares");
	    modif_objetos = new Group("modif_objetos");
	   
    	guardar = new Button("btn_guar",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),0,780,120,100),new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),120,785,120,100));
    	
    	pelucas = new Button("btn_pelu",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),648,616,104,150),new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),765,616,104,150));
    	gafas = new Button("btn_gafa",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),412,488,85,36),new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),408,524,89,40));
    	bigotes = new Button("btn_bigo",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),322,525,77,36),new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),319,485,80,38));
    	collares = new Button("btn_collar",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),328,562,56,36),new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),328,598,60,39));
    	objetos = new Button("btn_objto",new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),509,492,113,150),new TextureRegion(new Texture("imagenes2/modificalo/elemCuadro2.png"),525,645,108,150));
    	
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
    
   public Modificalo (int c) {
	   super();
	   this.num_cuadro = c;
   }
 
   public Modificalo () {
	   super();
   }

   
   public void Update () {
	// Animacion ardilla
	if(System.currentTimeMillis() - GameGlobals.ultimotiempo >= GameGlobals.changetime && !saliendo && Yardilla > -GameGlobals.A[0].height){
		GameGlobals.ultimotiempo = System.currentTimeMillis();
		i++;
		if(i >= GameGlobals.MAXimages){
			i = 0;
		}
		GameGlobals.A[i].x = Xardilla;
		GameGlobals.A[i].y = Yardilla;
		// El resto aparecen invisibles
		for(j = 0; j < i; j++){
			GameGlobals.A[j].x = this.escena.width();
			GameGlobals.A[j].y = this.escena.height();
		}
		for(j = i+1; j < GameGlobals.MAXimages; j++){
			GameGlobals.A[j].x = this.escena.width();
			GameGlobals.A[j].y = this.escena.height();
		}
	}
	
	// Animacion de la ardilla haciendose llendose
	if(saliendo){
		for(Image img: GameGlobals.A){
			img.y -= img.height/this.tiempoSalida;
			
			if(img.y <= -img.height){
				saliendo = false;
			}
		}
		Yardilla = (int) GameGlobals.A[0].y;
		Xardilla = (int) GameGlobals.A[0].x;
	}
	
	// Se van reproduciendo los takes (uno detras de otro)
	// Si se pulsa escape o en la pantalla (click) se salta el splash
	if(indice >= MAXtakes){
		// La ardilla se va
		saliendo = true;
	}else{
		if(reproducir == true){
			take[indice].play();
			reproducir = false;
		}
		
		if(!take[indice].isPlaying()){
			reproducir = true;
				indice++;
		}
	}
	if(Gdx.input.isTouched() || Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
		if(indice < MAXtakes){
			reproducir = false;
			take[indice].stop();
		}
		// La ardilla se va
		saliendo = true;
	}
   	super.Update(); 
   }
   
	@Override
	public void Initialize(){
		
		super.Initialize();
		
		panel.x = 690;
		panel.y = 200;
		
		fondo.x = 0;
		fondo.y = 0;
		
		cuadro.x = 300;
		cuadro.y = 80;
		
		guardar.x = 824;
		guardar.y = 0;
		
		//posicion de los botones activadores de los modificadores.
		pelucas.x = 720;
		pelucas.y = 330;
		bigotes.x = 720;
		bigotes.y = 240;
		collares.x = 810;
		collares.y = 240;
		gafas.x = 880;
		gafas.y = 240;
		
		objetos.x = 860;
		objetos.y = 330;
		
		gafa1.y = pos_ini_1_g;
		gafa2.y = pos_ini_2_g;
		gafa3.y = pos_ini_3_g;
		
		bigote1.y = pos_ini_1_b;
		bigote2.y = pos_ini_2_b;
		bigote3.y = pos_ini_3_b;
		
		peluca1.y = pos_ini_1_p;
		peluca2.y = pos_ini_2_p;
		peluca3.y = pos_ini_3_p;
		
		collar1.y = pos_ini_1_c;
		collar2.y = pos_ini_2_c;
		collar3.y = pos_ini_3_c;
		
		objeto1.y = pos_ini_1_o;
		objeto2.y = pos_ini_2_o;
		objeto3.y = pos_ini_3_o;

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
		
		sub_menu.x = 0;
		sub_menu.y = -5;
		
		menu_modif.addActor(pelucas);
		menu_modif.addActor(gafas);
		menu_modif.addActor(objetos);
			menu_modif.addActor(bigotes);
			menu_modif.addActor(collares);
	
		
		this.escena.addActor(fondo);
		this.escena.addActor(panel);
		this.escena.addActor(sub_menu);
		this.escena.addActor(cuadro);
		this.escena.addActor(modif_gafas);
		this.escena.addActor(modif_bigos);
		this.escena.addActor(modif_pelucas);
		this.escena.addActor(modif_collares);
		this.escena.addActor(modif_objetos);
		this.escena.addActor(menu_modif);
		this.escena.addActor(guardar);
		
		guardar.clickListener=new ClickListener(){
			public void clicked(Button b){
				if(!genial.isPlaying()){
					genial.play();
				}
			}
		};
		
		// Boton atras
		BAtras = new Button("salir",new TextureRegion(new Texture("imagenes2/Menu/atras sin pulsar.png")),new TextureRegion(new Texture("imagenes2/Menu/atras pulsado.png")));
		BAtras.x = 824-BAtras.width - 50;
		BAtras.y = 0;
		this.escena.addActor(BAtras);
		BAtras.clickListener=new ClickListener(){
			public void clicked(Button b){
				ScreenManager.getScreenManager().setCurrentScreen("menu");
			}
		};
		
		// Ardilla
		GameGlobals.ultimotiempo=System.currentTimeMillis();
		// Imagenes de las ardillas hablando
		GameGlobals.A[0].x = GameGlobals.posXardilla;
		GameGlobals.A[0].y = GameGlobals.posYardilla;
		// La 2 y la 3 aparecen inicialmente invisibles
		GameGlobals.A[1].x = this.escena.width();
		GameGlobals.A[1].y = this.escena.height();
		GameGlobals.A[2].x = this.escena.width();
		GameGlobals.A[2].y = this.escena.height();
		this.escena.addActor(GameGlobals.A[0]);
		this.escena.addActor(GameGlobals.A[1]);
		this.escena.addActor(GameGlobals.A[2]);
		// Sonidos de la ardilla hablando
		take[0] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesmodificalo/Take 1.wav"));
		take[1] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesmodificalo/Take 2.wav"));
		take[2] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesmodificalo/Take 3.wav"));
		take[3] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesmodificalo/Take 4.wav"));
		take[4] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesmodificalo/Take 5.wav"));
		take[5] = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesmodificalo/Take 6.wav"));
		genial = Gdx.audio.newMusic(Gdx.files.internal("sonido/vocesdemandrilla/takesdeacciones/genial.wav"));
				
		
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		return super.touchDragged(x, y, pointer);
		
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		
		//GAFAS*****************************************************
		if (gafa1.pressed) {
			//Pregunta si la gafa ha sido colocada en la zona valida del cuadro
			if ((gafa1.x > pCuadro.uGafa.mx1 && gafa1.x < pCuadro.uGafa.mx2) && (gafa1.y > pCuadro.uGafa.my1 && gafa1.y < pCuadro.uGafa.my2)) {
				//Coloca la gafa en su posicion en el cuadro
				gafa1.action(MoveTo.$(pCuadro.uGafa.xF,pCuadro.uGafa.yF,1));
				//Quita la gafa puesta de la lista de gafas sin usar
				if(modif_gafas.getActors().contains(gafa1)) {
					recolocar("gafa");
					modif_gafas.removeActor(gafa1);
					escena.addActor(gafa1);
					gafa1.pressed=false;
					modif_gafas.focus(null, 0);
				}
			//si no ha sido colocada en una zona valida la devuleve al su sitio
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
		
		if (escena.getActors().contains(gafa1) || escena.getActors().contains(gafa2) || escena.getActors().contains(gafa3)) {
			gUsado = true;
		} else {
			gUsado = false;
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
		
		if (escena.getActors().contains(bigote1) || escena.getActors().contains(bigote2) || escena.getActors().contains(bigote3)) {
			bUsado = true;
		} else {
			bUsado = false;
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
		if (escena.getActors().contains(peluca1) || escena.getActors().contains(peluca2) || escena.getActors().contains(peluca3)) {
			pUsado = true;
		} else {
			pUsado = false;
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
		
		if (escena.getActors().contains(collar1) || escena.getActors().contains(collar2) || escena.getActors().contains(collar3)) {
			cUsado = true;
		} else {
			cUsado = false;
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
		if (escena.getActors().contains(objeto1) || escena.getActors().contains(objeto2) || escena.getActors().contains(objeto3)) {
			oUsado = true;
		} else {
			oUsado = false;
		}
		
		if(gUsado && bUsado && pUsado&& cUsado&& oUsado) {
			genial.play();
			GameGlobals.nueces++;
			GameGlobals.ModificaFinished = true;
			ScreenManager.getScreenManager().setCurrentScreen("menu");  // Quitar
		} else {
			ganaNuez = false;
			//GameGlobals.nueces--;
		}
		
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
	
	public void esconderGrupos(String nom) {
		   if (nom == "gafas") {
			   if (num_cuadro == 2) {
			   modif_gafas.action(MoveTo.$(40,0,1));
			   } else {
				   modif_gafas.action(MoveTo.$(70,0,1));
			   }
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
			   modif_bigos.action(MoveTo.$(90,0,1));
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
			   modif_pelucas.action(MoveTo.$(50,0,1));
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
			   modif_collares.action(MoveTo.$(70,0,1));
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
			   modif_objetos.action(MoveTo.$(50,0,1));
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
	
	//Recoloca los elementos en su posicion original.
	//Cuando una vez puestos en el cuadro son cambiados por otro de mismo tipo
	public void reubicarElemento(Actor actor) {
		
		//elementos gafas
		if (actor.equals(gafa1)) {
			gafa1.action(MoveTo.$(0,pos_ini_1_g,1));
		}
		if (actor.equals(gafa2)) {
			gafa2.action(MoveTo.$(0,pos_ini_2_g,1));
		}
		if (actor.equals(gafa3)) {
			gafa3.action(MoveTo.$(0,pos_ini_3_g,1));
		}
		
		//elementos bigotes.
		if (actor.equals(bigote1)) {
			bigote1.action(MoveTo.$(0,pos_ini_1_b,1));
		}
		if (actor.equals(bigote2)) {
			bigote2.action(MoveTo.$(0,pos_ini_2_b,1));
		}
		if (actor.equals(bigote3)) {
			bigote3.action(MoveTo.$(0,pos_ini_3_b,1));
		}
		
		//elementos pelucas.
		if (actor.equals(peluca1)) {
			peluca1.action(MoveTo.$(0,pos_ini_1_p,1));
		}
		if (actor.equals(peluca2)) {
			peluca2.action(MoveTo.$(0,pos_ini_2_p,1));
		}
		if (actor.equals(peluca3)) {
			peluca3.action(MoveTo.$(0,pos_ini_3_p,1));
		}

		//elementos collares.
		if (actor.equals(collar1)) {
			collar1.action(MoveTo.$(0,pos_ini_1_c,1));
		}
		if (actor.equals(collar2)) {
			collar2.action(MoveTo.$(0,pos_ini_2_c,1));
		}
		if (actor.equals(collar3)) {
			collar3.action(MoveTo.$(0,pos_ini_3_c,1));
		}
		
		//elementos objetos.
		if (actor.equals(objeto1)) {
			objeto1.action(MoveTo.$(0,pos_ini_1_o,1));
		}
		if (actor.equals(objeto2)) {
			objeto2.action(MoveTo.$(0,pos_ini_2_o,1));
		}
		if (actor.equals(objeto3)) {
			objeto3.action(MoveTo.$(0,pos_ini_3_o,1));
		}
	}
}



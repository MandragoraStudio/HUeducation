package juegos.museo;

import java.util.ArrayList;

import principal.GameGlobals;
import juegos.Juego;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.MoveTo;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class Museo extends Juego {

	private Image fondo;
	private Button izquierda;
	private Button derecha;
	private TextureRegion marcoChico;
	private Button marcoGrande;
	private float factorDeReduccionX;
	private float factorDeReduccionY;
	private float cuadro1Pos = 120;
	private float cuadro2Pos = 530;
	
	private ArrayList<Cuadro> cuadros;

	public Museo() {
		super();

	}
	
	@Override
	public void Load() {
	}

	@Override
	public void Initialize() {
		super.Initialize();
		
		// Imagen de fondo
		fondo = new Image("fondo", new TextureRegion(new Texture(
		"imagenes2/museo/TexturesMuseo.png"), 0, 0, 1024, 600));
		this.escena.addActor(fondo);
		
		// Boton derecha
		derecha = new Button("derecha", new TextureRegion(new Texture(
		"imagenes2/museo/TexturesMuseo.png"), 0, 600, 101, 110));
		derecha.x = 1024 - 10 - this.derecha.width;
		derecha.y = 270;
		this.escena.addActor(derecha);
		derecha.clickListener = new ClickListener() {		
			public void clicked(Button arg0) {
				if(cuadros.size() != 0){
					if(cuadros.get(cuadros.size() - 1).getMarco().x != (cuadros.size()%2 == 0? cuadro2Pos:cuadro1Pos)){
						if(System.currentTimeMillis() - GameGlobals.pressTime >= 2000){
							for(Cuadro cuadro:cuadros){
								if(cuadro.isAmpliado()){
									cuadro.reducir();
								}
								cuadro.setXreducida(cuadro.getCuadro().x + 1024);
								cuadro.getCuadro().action(MoveTo.$(cuadro.getCuadro().x - 1024, cuadro.getCuadro().y, 2));
								cuadro.getMarco().action(MoveTo.$(cuadro.getMarco().x - 1024, cuadro.getMarco().y, 2));						
							}
							GameGlobals.pressTime = System.currentTimeMillis();
						}
					}
				}
			}
		};
		
		
		// Boton izquierda
		izquierda = new Button("izquierda", new TextureRegion(new Texture(
				"imagenes2/museo/TexturesMuseo.png"), 101, 600, 98, 110));
		izquierda.x = 10;
		izquierda.y = 270;
		this.escena.addActor(izquierda);
		izquierda.clickListener = new ClickListener() {		
			public void clicked(Button arg0) {
				if(cuadros.size() != 0){
					if(cuadros.get(0).getMarco().x != cuadro1Pos){
						if(System.currentTimeMillis() - GameGlobals.pressTime >= 2000){
							for(Cuadro cuadro:cuadros){
								if(cuadro.isAmpliado()){
									cuadro.reducir();
								}	
								cuadro.setXreducida(cuadro.getCuadro().x + 1024);
								cuadro.getCuadro().action(MoveTo.$(cuadro.getCuadro().x + 1024, cuadro.getCuadro().y, 2));
								cuadro.getMarco().action(MoveTo.$(cuadro.getMarco().x + 1024, cuadro.getMarco().y, 2));
							}
							GameGlobals.pressTime = System.currentTimeMillis();
						}
					}
				}
			}
		};
		
		// Marco de las imagenes grande
		marcoGrande = new Button("marcoGrande",new TextureRegion(new Texture("imagenes2/museo/TexturesMuseo2.png"), 0, 0, 803, 538));
		marcoGrande.x = 115;
		marcoGrande.y = 30;
		marcoGrande.touchable = false;
		
		// Marco de las imagenes chico
		marcoChico = new TextureRegion(new Texture("imagenes2/museo/TexturesMuseo.png"), 199, 600, 371, 285);
		// Factor de reduccion
		// Esta variable se usa para escalar los cuadros al mostrarlos pequeños
		factorDeReduccionX = marcoChico.getRegionWidth()/marcoGrande.width;
		factorDeReduccionY = marcoChico.getRegionHeight()/marcoGrande.height;
		
		// Se cargan los cuadros
		cuadros = new ArrayList<Cuadro>();
		this.cargarCuadros();	// Carga y posiciona los cuadros
		
		// Se añade a la escena el marco chico y el cuadro
		for(Cuadro cuadro:cuadros){
			
			this.escena.addActor(cuadro.getMarco());
			this.escena.addActor(cuadro.getCuadro());	
		}
	}

	public void Update() {
		super.Update();

	}
	
	public void cargarCuadros(){
		int i = 0;
		boolean finalizado = false;
		Button boton;
		
		while(!finalizado){
			try{
			boton = new Button("cuadro" + Integer.toString(i), 
					new TextureRegion(new Texture("imagenes2/museo/cuadro" + Integer.toString(i) + ".png"), 0, 0, 737, 484));
			
				cuadros.add(new Cuadro(boton, marcoChico,(i%2 == 0? this.cuadro1Pos: this.cuadro2Pos) + GameGlobals.ScreenWidth*(i/2), 170, this.factorDeReduccionX, this.factorDeReduccionY));
				i++;
			}catch(Exception e){
				finalizado = true;
			}
		}
		
		
	}
	
	public void mostrarMarcoGrande(){
		this.escena.addActor(marcoGrande);
	}
	
	public void ocultarMarcoGrande(){
		this.escena.removeActor(marcoGrande);
	}

	public Button getMarcoGrande() {
		return marcoGrande;
	}

	public void setMarcoGrande(Button marcoGrande) {
		this.marcoGrande = marcoGrande;
	}
	
	

}

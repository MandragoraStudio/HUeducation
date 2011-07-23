package juegos.emocionesPintadas;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actors.Button;

//Esta clase debe extender de la clase Grupo de Actores, e incluir todos los subactores necesarios para crear la paleta. Soy un genio
public class Paleta extends Group {
	
	Button colorCyan=new Button("CCyan");
	Button colorMagenta=new Button("CMagenta");
	Button colorAmarillo=new Button("CAmarillo");
	
	Button colorRojo=new Button("CRojo");
	Button colorVerde=new Button("CVerde");
	Button colorMorado=new Button("CMorado");
	
	Button colorP1=new Button("CP1");
	Button colorP2=new Button("CP2");
	Button colorP3=new Button("CP3");
	Button colorP4=new Button("CP4");
	Button colorP5=new Button("CP5");
	Button colorP6=new Button("CP6");
	
	
	public Paleta(String name){
		super(name);
		this.addActor(colorCyan);
		this.addActor(colorMagenta);
		this.addActor(colorAmarillo);
		this.addActor(colorRojo);
		this.addActor(colorVerde);
		this.addActor(colorMorado);
		this.addActor(colorP1);
		this.addActor(colorP2);
		this.addActor(colorP3);
		this.addActor(colorP4);
		this.addActor(colorP5);
		this.addActor(colorP6);
		this.touchable=true;
	}
	
}

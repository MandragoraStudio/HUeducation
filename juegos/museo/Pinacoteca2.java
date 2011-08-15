package juegos.museo;



import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;

public class Pinacoteca2 {

	private Cuadro cuadro1;
	private Cuadro cuadro2;
	private Stage escena;

	public Pinacoteca2(Stage escena) {
		this.escena = escena;
	}

	public void Initialize() {

		this.cuadro1 = new Cuadro();
		this.cuadro1.Initialize();
		this.cuadro2 = new Cuadro();
		this.cuadro2.Initialize();

		this.setButtons();
	}

	private void setButtons() {
		cuadro1.x = 120;
		cuadro1.y = 170;
		this.escena.addActor(cuadro1);
		cuadro1.clickListener = new ClickListener() {

			public void clicked(Button arg0) {
				borrarPinacoteca();
				
			}
		};

		cuadro2.x = 530;
		cuadro2.y = 170;
		this.escena.addActor(cuadro2);
		cuadro2.clickListener = new ClickListener() {

			public void clicked(Button arg0) {

			}
		};

	}
	public void borrarPinacoteca(){
		
		this.escena.removeActor(this.cuadro1);
		this.escena.removeActor(this.cuadro2);
	}
}

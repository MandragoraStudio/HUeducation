package juegos.museo;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;

public class Pinacoteca2 extends Group {

	private Cuadro cuadro1;
	private Cuadro cuadro2;

	private CuadroXL cuadro1XL;
	private CuadroXL cuadro2XL;

	public Pinacoteca2(String nombre) {
		super(nombre);
	}

	public void Initialize() {

		this.cuadro1 = new Cuadro();
		this.cuadro1.Initialize();

		this.cuadro2 = new Cuadro();
		this.cuadro2.Initialize();
		
		this.cuadro1XL = new CuadroXL();
		this.cuadro1XL.Initialize();

		this.cuadro2XL = new CuadroXL();
		this.cuadro2XL.Initialize();

		this.setButtons();
	}

	private void setButtons() {
		cuadro1.x = 120;
		cuadro1.y = 170;
		this.addActor(cuadro1);
		cuadro1.clickListener = new ClickListener() {

			public void clicked(Button arg0) {
				borrarPinacoteca();
				pintarCuadro1XL();
			}
		};

		cuadro2.x = 530;
		cuadro2.y = 170;
		this.addActor(cuadro2);
		cuadro2.clickListener = new ClickListener() {

			public void clicked(Button arg0) {
				borrarPinacoteca();
				pintarCuadro2XL();
			}
		};

	}

	public void borrarPinacoteca() {

		this.removeActor(this.cuadro1);
		this.removeActor(this.cuadro2);
		this.removeActor(this.cuadro1XL);
		this.removeActor(this.cuadro2XL);
	}

	public void pintarCuadro1XL() {

		this.addActor(this.cuadro1XL);
	}

	public void pintarCuadro2XL() {

		this.addActor(this.cuadro2XL);
	}
	
	public void reestablecerPinacoteca(){
		this.borrarPinacoteca();
		this.addActor(this.cuadro1);
		this.addActor(this.cuadro2);
	}

	public int añadirCuadro(Cuadro c) {
		int resul = 0;
		if (!this.cuadro1.isInicializado()) {
			this.cuadro1 = c;
		} else if (!this.cuadro2.isInicializado()) {
			this.cuadro2 = c;
			resul = 1;
		} else {
			resul = -1;
		}
		return resul;
	}
}

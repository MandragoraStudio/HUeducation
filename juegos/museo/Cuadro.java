package juegos.museo;

import principal.GameGlobals;
import principal.ScreenManager;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Image;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;

public class Cuadro {
	private Button cuadro;
	private Image marco;
	private float Xreducida;
	private float Yreducida;
	private boolean ampliado;
	private float factorDeReduccionX;
	private float factorDeReduccionY;
	
	// Construtor
	public Cuadro(Button cuadro, TextureRegion marcoChico, float x, float y, float factorDeReduccionX, float factorDeReduccionY){
		this.cuadro = cuadro;
		this.marco = new Image("cuadro", marcoChico);
		
		this.factorDeReduccionX = factorDeReduccionX;
		this.factorDeReduccionY = factorDeReduccionY;
		
		this.marco.x = x;
		this.marco.y = y;
		
		// El cuadro comienza escalado
		this.reducir();
		
		// Se coloca el cuadro dentro del marco chico
		cuadro.x = marco.x + (marco.width - cuadro.width)/2;
		cuadro.y = marco.y + (marco.height - cuadro.height)/2;
		
		this.Xreducida = cuadro.x;
		this.Yreducida = cuadro.y;
		
		ampliado = false;
		
		cuadro.clickListener = new ClickListener() {		
			public void clicked(Button arg0) {
				if(System.currentTimeMillis() - GameGlobals.pressTime >= 2000){
					if(ampliado){
						reducir();
						
					}else{
						ampliar();
					}
					GameGlobals.pressTime = System.currentTimeMillis();
				}
			}
		};
	}

	public Button getCuadro() {
		return cuadro;
	}

	public void setCuadro(Button cuadro) {
		this.cuadro = cuadro;
	}

	public Image getMarco() {
		return marco;
	}

	public void setMarco(Image marco) {
		this.marco = marco;
	}
	
	public void reducir(){
		ampliado = false;
		cuadro.x = this.Xreducida;
		cuadro.y = this.Yreducida;
		cuadro.scaleX = factorDeReduccionX;
		cuadro.scaleY = factorDeReduccionY;
		Museo m=(Museo)ScreenManager.getScreenManager().screens.get("museo");
		m.ocultarMarcoGrande();		
	}
	
	public void ampliar(){
		ampliado = true;
		cuadro.scaleX = 1;
		cuadro.scaleY = 1;
		this.Xreducida = cuadro.x;
		this.Yreducida = cuadro.y;
		// Centro el cuadro en el marco grande
		Museo m=(Museo)ScreenManager.getScreenManager().screens.get("museo");
		cuadro.x = m.getMarcoGrande().x + (m.getMarcoGrande().width - cuadro.width)/2;
		cuadro.y = m.getMarcoGrande().y + (m.getMarcoGrande().height - cuadro.height)/2;
		m.escena.removeActor(cuadro);
		m.escena.addActor(cuadro);
		m.mostrarMarcoGrande();
	}

	public float getXreducida() {
		return Xreducida;
	}

	public void setXreducida(float xreducida) {
		Xreducida = xreducida;
	}

	public float getYreducida() {
		return Yreducida;
	}

	public void setYreducida(float yreducida) {
		Yreducida = yreducida;
	}

	public boolean isAmpliado() {
		return ampliado;
	}

	public void setAmpliado(boolean ampliado) {
		this.ampliado = ampliado;
	}

	public float getFactorDeReduccionX() {
		return factorDeReduccionX;
	}

	public void setFactorDeReduccionX(float factorDeReduccionX) {
		this.factorDeReduccionX = factorDeReduccionX;
	}

	public float getFactorDeReduccionY() {
		return factorDeReduccionY;
	}

	public void setFactorDeReduccionY(float factorDeReduccionY) {
		this.factorDeReduccionY = factorDeReduccionY;
	}
	
	
}

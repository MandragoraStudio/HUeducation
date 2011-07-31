package juegos.mezcla;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MoverA extends Action{
	
	Actor target;
	float destinoX=0;
	float destinoY=0;
	float velocidad=10;
	
	public MoverA(int x, int y){
		destinoX=x;
		destinoY=y;
	}
	
	@Override
	public void act(float delta) {
		float diferenciaX=destinoX-target.x;
		float diferenciaY=destinoY-target.y;
		float ratio = diferenciaX/diferenciaY;
		float difX=ratio*delta*velocidad;
		float difY=(1/ratio)*delta*velocidad;
		if(difX>diferenciaX){
			difX=diferenciaX;
		}
		if(difY>diferenciaY){
			difY=diferenciaY;
		}
		target.x+=difX;
		target.y+=difY;
	}

	@Override
	public Action copy() {
		return null;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setTarget(Actor arg0) {
		target=arg0;
	}

}

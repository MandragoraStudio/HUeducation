package juegos.mezcla;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MoverA extends Action {

	Actor target;
	float destinoX = 0;
	float destinoY = 0;
	float velocidad = 10;

	public MoverA(int x, int y) {
		destinoX = x;
		destinoY = y;
	}

	public MoverA(int x, int y, float speed) {
		destinoX = x;
		destinoY = y;
		velocidad = speed;
	}

	@Override
	public void act(float delta) {
		float diferenciaX = destinoX - target.x;
		float diferenciaY = destinoY - target.y;
		float ratio=1;
		if (diferenciaY != 0) {
			ratio = Math.abs(diferenciaX / diferenciaY);
		}
		float difX = ratio * delta * velocidad;
		float difY = (1 / ratio) * delta * velocidad;
		if (Math.abs(difX) > Math.abs(diferenciaX)) {
			difX = diferenciaX;
		}
		if (Math.abs(difY) > Math.abs(diferenciaY)) {
			difY = diferenciaY;
		}
		target.x += difX;
		target.y += difY;
	}

	@Override
	public Action copy() {
		return null;
	}

	@Override
	public boolean isDone() {
		float diferenciaX = destinoX - target.x;
		float diferenciaY = destinoY - target.y;
		return (diferenciaX==0&&diferenciaY==0);
	}

	@Override
	public void setTarget(Actor arg0) {
		target = arg0;
	}

}

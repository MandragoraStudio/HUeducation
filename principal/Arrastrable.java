package principal;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actors.Button;

public class Arrastrable extends Button {
	Group Padre;
	float Yinicial;
	float Xinicial;
	boolean visible;
	boolean colocado;

	public Arrastrable(String name, Texture texture,Group padre) {
		super(name, texture);
		//if (padre == null)throw new IllegalArgumentException("El padre no pude ser null");
		this.Padre=padre;
		// TODO Auto-generated constructor stub
	}
	
	public Arrastrable(String name, Texture texture) {
		super(name, texture);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean touchDown(float x, float y, int pointer) {
		// TODO Auto-generated method stub
		Yinicial=y;
		Xinicial=x;
		return super.touchDown(x, y, pointer);
	}

	@Override
	protected boolean touchDragged(float x, float y, int pointer) {
		// TODO Auto-generated method stub
		if (Padre != null) {
			if(this.pressed){
				Padre.x=Padre.x+(x-Xinicial);
				Padre.y=Padre.y+(y-Yinicial);
			}
		} else {
			if(this.pressed){
				this.x = this.x+(x-Xinicial);
				this.y = this.y+(y-Yinicial);
			}
		}
		return super.touchDragged(x, y, pointer);
	}

	@Override
	protected boolean touchUp(float x, float y, int pointer) {
		// TODO Auto-generated method stub
		return super.touchUp(x, y, pointer);
	}

	
}

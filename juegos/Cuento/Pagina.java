package juegos.Cuento;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

public class Pagina {
	
	private int numPPag;
	private String opcCorrecta;
	private Button opcA;
	private Button opcB;
	private Image hoja;
	private CuentoClasico cuento;
	//meter lista de sonidos que tiene esta página
	public Music[] take = new Music[3];
	/*int indice = 0;
	int MAXtakes = 3;
	boolean reproducir = true;*/
	
	/*public Pagina(int numPPag, String opcCorrecta, Image hoja, TextureRegion opcA, TextureRegion opcB, CuentoClasico cuento, array de sonidos) {
		
		this.numPPag = numPPag;
		this.opcCorrecta = opcCorrecta;
		this.hoja= hoja;
		this.hoja.x=90;
		this.hoja.y=70;
		this.opcA=new Button("opcionA", opcA);
		this.opcB=new Button("opcionB", opcB);
		this.cuento = cuento;
		this.arraySonidos = arraySonidos;
		setButtons();
	}*/

	public Pagina(int numPPag, String opcCorrecta, Image hoja, TextureRegion opcA, TextureRegion opcB, CuentoClasico cuento, Music take1, Music take2, Music take3) {
		
		this.numPPag = numPPag;
		this.opcCorrecta = opcCorrecta;
		this.hoja= hoja;
		this.hoja.x=75;
		this.hoja.y=35;
		this.opcA=new Button("opcionA", opcA);
		this.opcB=new Button("opcionB", opcB);
		this.cuento = cuento;
		take[0] = take1;
		take[1] = take2;
		take[2] = take3;
		setButtons();
	}
	
	private void setButtons(){
		opcA.x=470;
		opcA.y=90;
		opcA.clickListener=new ClickListener(){
		
			public void clicked(Button arg0) {
				compruebaOpc("A");
			}};
			
			

			opcB.x=opcA.x+180;
			opcB.y=opcA.y;
			opcB.clickListener=new ClickListener(){
				
				public void clicked(Button arg0) {
					compruebaOpc("B");
			}
			};
			}
	
	private void compruebaOpc(String opc){
		if(opc.equals(this.opcCorrecta)){
			//TODO: poner sonido de que lo has exo bien
			cuento.bien.play();
			//pasar siguiente pagina
			this.cuento.siguientePagina();
		}else{
			//TODO: mensaje error SONIDO JUANMAAAAAAAAAAA
			cuento.mal.play();
			
		}
	}
	public int getNumPPag() {
		return numPPag;
	}

	public void setNumPPag(int numPPag) {
		this.numPPag = numPPag;
	}

	public String getOpcCorrecta() {
		return opcCorrecta;
	}

	public void setOpcCorrecta(String opcCorrecta) {
		this.opcCorrecta = opcCorrecta;
	}

	public Image getHoja() {
		return hoja;
	}

	public void setHoja(Image hoja) {
		this.hoja = hoja;
	}

	public Button getOpcA() {
		return opcA;
	}

	public void setOpcA(Button opcA) {
		this.opcA = opcA;
	}

	public Button getOpcB() {
		return opcB;
	}

	public void setOpcB(Button opcB) {
		this.opcB = opcB;
	}

}

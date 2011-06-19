package principal;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.568A4CC0-355A-9165-A132-94106670DFCC]
// </editor-fold> 
public class Game implements ApplicationListener {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.66FAB374-562A-9EE2-5007-7E9E1AC51AF2]
    // </editor-fold> 
    private ScreenManager screenManager;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.410DF344-875C-9125-C3DE-6DADA49612A3]
    // </editor-fold> 
    private Mesh mesh;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F51ADF82-611B-51BA-6356-81DF9613859A]
    // </editor-fold> 
    private Texture textura;

	@Override

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.24EC4C76-3889-5E99-7144-262B83DE26AE]
    // </editor-fold> 
    public void create () {
		mesh = new Mesh(false, 3, 3, new VertexAttribute(Usage.Position, 3,
				"a_position"), new VertexAttribute(Usage.ColorPacked, 4,
				"a_color"), new VertexAttribute(Usage.TextureCoordinates, 2,
				"a_texture"));
		mesh.setVertices(new float[] { -0.5f, -0.5f, 0,
				Color.toFloatBits(255, 0, 0, 255), 0, 1, 0.5f, -0.5f, 0,
				Color.toFloatBits(0, 255, 0, 255), 1, 1, 0, 0.5f, 0,
				Color.toFloatBits(0, 0, 255, 255), 0.5f, 0 });
		mesh.setIndices(new short[] { 0, 1, 2 });
		textura = new Texture(Gdx.files.internal("img/badlogic.jpg"));

	}

	@Override

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B4BA8155-6ED7-6A5D-BB22-8C8D7076EAB4]
    // </editor-fold> 
    public void dispose () {
		// TODO Auto-generated method stub

	}

	@Override

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5C675C93-F185-BA0B-7A55-C9844E609156]
    // </editor-fold> 
    public void pause () {
		// TODO Auto-generated method stub

	}

	@Override

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0393B500-FE87-25E8-0D31-E2B0632491C0]
    // </editor-fold> 
    public void render () {
		//Gdx.gl.glClearColor(0, 1, 0, 1);
	      Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);   
	      Gdx.graphics.getGL10().glEnable(GL10.GL_TEXTURE_2D);
	      textura.bind();
	      mesh.render(GL10.GL_TRIANGLES, 0, 3);   
	}

	@Override

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EF271B2F-373D-9565-C477-137AF3C54641]
    // </editor-fold> 
    public void resize (int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BD468638-C722-3CE4-5FB0-2D2636D71141]
    // </editor-fold> 
    public void resume () {


    }

}

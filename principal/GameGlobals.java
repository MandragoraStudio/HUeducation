package principal;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actors.Image;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.D038C4C4-5B6F-AA65-41BE-23DBB2436B1C]
// </editor-fold> 
public class GameGlobals {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E292EA6E-2B04-CBD3-6111-08E832C689F8]
    // </editor-fold> 
    public static int volumen;
    public static int ScreenWidth= 1024;
    public static int ScreenHeight=600;
    public static boolean cuentoFinished =false;
    public static boolean emocionesFinished =false;
    public static boolean mezclaFinished =false;
    public static boolean MuseoFinished =false;
    public static boolean ModificaFinished =false;
    public static boolean JuegoFinished = false;
    public static int nueces = 0;
    
	// Ardilla Hablando
	public static Image[] A = new Image[]{
	new Image("mandrilla1",new TextureRegion(new Texture("imagenes2/ardilla/hablando/mandrilla1.png"))),
	new Image("mandrilla2",new TextureRegion(new Texture("imagenes2/ardilla/hablando/mandrilla2.png"))),
	new Image("mandrilla3",new TextureRegion(new Texture("imagenes2/ardilla/hablando/mandrilla3.png")))};

	public static int MAXimages = 3;
	public static long changetime=200;
	public static long ultimotiempo=0;
	public static int posXardilla = 700;
	public static int posYardilla = 0;
    
    public static long pressTime = 0;
}


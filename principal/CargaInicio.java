package principal;

import java.io.OutputStream;
import java.io.PrintWriter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class CargaInicio extends Thread {
	public boolean terminado = false;
	
	public void run(){
		ScreenManager sm = ScreenManager.getScreenManager();
		
		//Carga el menu principal aqui
		sm.addScreen("esplash", new EducationSplash());
		sm.addScreen("menu",new Menu());
		
		
		//Carga de archivos guardados
		FileHandle f = Gdx.files.external("campamentomandrilla/save/data.txt");
		f.parent().mkdirs();
		if(f.exists()){
			String data = f.readString();
			String[] nums = data.split(",");
			GameGlobals.cuentoFinished =Boolean.valueOf(nums[0]);
			GameGlobals.emocionesFinished =Boolean.valueOf(nums[1]);
			GameGlobals.mezclaFinished =Boolean.valueOf(nums[2]);
			GameGlobals.MuseoFinished =Boolean.valueOf(nums[3]);
			GameGlobals.ModificaFinished =Boolean.valueOf(nums[4]);
			GameGlobals.nueces = Integer.valueOf(nums[5]);
			GameGlobals.JuegoFinished = Boolean.valueOf(nums[6]);
		}else{
			OutputStream os=f.write(false);
			PrintWriter pw = new PrintWriter(os);
			pw.write("false,false,false,false,false,0,false");
			pw.close();
		}
		
		//terminado
		terminado = true;
	}
}

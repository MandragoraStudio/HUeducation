package principal;

public class CargaInicio extends Thread {
	public boolean terminado = false;
	
	public void run(){
		ScreenManager sm = ScreenManager.getScreenManager;
		
		//Carga el menu principal aqui
		sm.addScreen("esplash", new EducationSplash());
		sm.addScreen("menu",new Menu());
		
		
		//terminado
		terminado = true;
	}
}
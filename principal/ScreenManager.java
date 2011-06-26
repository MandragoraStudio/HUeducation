package principal;

import java.util.Map;

public class ScreenManager {

	public static ScreenManager getScreenManager;
	public Screen currentScreen;
	public Map<String,Screen> screens;
	
	private ScreenManager(){
		
	}
	
	{
		getScreenManager = new ScreenManager();
		
	}

	public Screen getCurrentScreen() {
		return currentScreen;
	}

	public void setCurrentScreen(String screen) {
		screen = screen.toLowerCase();
		this.currentScreen = this.screens.get(screen);
		this.currentScreen.Initialize();
	}

	public Map<String, Screen> getScreens() {
		return screens;
	}

	public void setScreens(Map<String, Screen> screens) {
		this.screens = screens;
	}

	public void addScreen(String cad, Screen s){
		cad = cad.toLowerCase();
		this.screens.put(cad, s);
		s.Load();
	}
	
}

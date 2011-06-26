package principal;

import java.util.HashMap;
import java.util.Map;

public class ScreenManager {

	private static ScreenManager getScreenManager;
	public Screen currentScreen;
	public Map<String,Screen> screens;
	
	
	private ScreenManager(){
		screens = new HashMap<String, Screen>();
	}
	public static ScreenManager getScreenManager(){
		if(getScreenManager==null){
			getScreenManager=new ScreenManager();
		}
		return getScreenManager;
	}

	public Screen getCurrentScreen() {
		return currentScreen;
	}

	public void setCurrentScreen(String screen) {
		screen = screen.toLowerCase();
		if(currentScreen!=null)
			this.currentScreen.Dispose();
		this.currentScreen = this.screens.get(screen);
		this.currentScreen.Initialize();
	}
	
	public void unloadScreen(String screen){
		screen=screen.toLowerCase();
		screens.get(screen).Unload();
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

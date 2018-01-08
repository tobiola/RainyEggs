package com.obitola.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.obitola.game.RainyEggs;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = RainyEggs.WIDTH;
		config.height = RainyEggs.HEIGHT;
		config.title = RainyEggs.TITLE;
		new LwjglApplication(new RainyEggs(), config);
	}
}

package com.mygdx.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title="Quarto V0.10";
		config.backgroundFPS = MainGame.fps_0;
		config.width = MainGame.width_0;
		config.height = MainGame.height_0;
		config.resizable=false;
		config.addIcon("icon.png", Files.FileType.Internal);

		new LwjglApplication(new MainGame(), config);
	}
}

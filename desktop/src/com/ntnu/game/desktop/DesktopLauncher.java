package com.ntnu.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ntnu.game.HelicopterGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = HelicopterGame.SCREEN_WIDTH;
        config.height = HelicopterGame.SCREEN_HEIGHT;
        config.title = HelicopterGame.TITLE;
        new LwjglApplication(new HelicopterGame(), config);
    }
}

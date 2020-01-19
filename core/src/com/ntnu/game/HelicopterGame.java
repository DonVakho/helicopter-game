package com.ntnu.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ntnu.game.states.GameStateManager;
import com.ntnu.game.states.StartPageState;

public class HelicopterGame extends ApplicationAdapter {

    public static final int SCREEN_WIDTH = 350;

    public static final int SCREEN_HEIGHT = 600;

    public static final int HELICOPTER_WIDTH = 81;

    public static final float HELICOPTER_HEIGHT = 32.5f;

    public static final String TITLE = "Chop Chop";

    private GameStateManager gsm;

    private SpriteBatch batch;

    @Override
    public void create() {
        gsm = new GameStateManager();
        batch = new SpriteBatch();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        gsm.push(new StartPageState(gsm));
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }
}

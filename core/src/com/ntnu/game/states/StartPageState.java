package com.ntnu.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ntnu.game.HelicopterGame;

public class StartPageState extends State {

    private Texture playBtn;

    public StartPageState(final GameStateManager gsm) {
        super(gsm);
        playBtn = new Texture("playBtn.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(playBtn,
                (HelicopterGame.SCREEN_WIDTH / 2) - (playBtn.getWidth() / 2),
                (HelicopterGame.SCREEN_HEIGHT / 2) - (playBtn.getHeight() / 2));
        sb.end();
    }

    @Override
    public void dispose() {
        playBtn.dispose();
    }
}

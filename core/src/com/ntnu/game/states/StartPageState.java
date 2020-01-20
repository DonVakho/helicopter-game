package com.ntnu.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ntnu.game.HelicopterGame;

public class StartPageState extends State {

    private Stage stage;

    public StartPageState(final GameStateManager gsm) {
        super(gsm);
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Skin skin = new Skin(Gdx.files.internal("gdxSkins/comic/skin/comic-ui.json"));

        final int btnW = HelicopterGame.SCREEN_WIDTH / 2;
        final int btnH = btnW / 3;
        final int btnPosX = (HelicopterGame.SCREEN_WIDTH - btnW) / 2;
        final int btnPosY = (HelicopterGame.SCREEN_HEIGHT - btnH) / 2;

        Button playBtn = new TextButton("Play", skin);
        playBtn.setSize(btnW, btnH);
        playBtn.setPosition(btnPosX, btnPosY);
        playBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsm.set(new MenuState(gsm));
            }
        });

        stage.addActor(playBtn);
    }

    @Override
    public void update(float dt) {
    }

    @Override
    public void render(SpriteBatch sb) {
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {

    }
}

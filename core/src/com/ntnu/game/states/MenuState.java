package com.ntnu.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.ntnu.game.HelicopterGame;
import com.ntnu.game.states.play.PlayState_1;

public class MenuState extends State {

    private static final int BTN_W = HelicopterGame.SCREEN_WIDTH / 2;

    private static final int BTN_H = BTN_W / 3;

    private Stage stage;

    MenuState(final GameStateManager gsm) {
        super(gsm);
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Skin skin = new Skin(Gdx.files.internal("gdxSkins/comic/skin/comic-ui.json"));

        final int btnNum = 4;
        final int boundsNum = btnNum + 4;
        final int singleBound = (HelicopterGame.SCREEN_HEIGHT - BTN_H * btnNum) / boundsNum;
        final int doubleBound = singleBound * 2;
        final int btnSpace = BTN_H + singleBound;

        Button task4 = createTxtButton("Task 4", skin, doubleBound);
        task4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });
        Button task3 = createTxtButton("Task 3", skin, task4.getY() + btnSpace);
        task3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });
        Button task2 = createTxtButton("Task 2", skin, task3.getY() + btnSpace);
        task2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });
        Button task1 = createTxtButton("Task 1", skin, task2.getY() + btnSpace);
        task1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsm.set(new PlayState_1(gsm));
            }
        });

        stage.addActor(task1);
        stage.addActor(task2);
        stage.addActor(task3);
        stage.addActor(task4);
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

    private TextButton createTxtButton(String name, Skin skin, float y) {
        final int btnPosX = (HelicopterGame.SCREEN_WIDTH  - BTN_W) / 2;
        TextButton btn = new TextButton(name, skin);
        btn.setSize(BTN_W, BTN_H);
        btn.setPosition(btnPosX, y);
        return btn;
    }
}

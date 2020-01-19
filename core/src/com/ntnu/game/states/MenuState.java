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

    private static final int BTN_W = 170;

    private static final int BTN_H = 50;

    private static final int BTN_POS_X = HelicopterGame.SCREEN_WIDTH / 2 - BTN_W / 2;

    private Stage stage;

    MenuState(final GameStateManager gsm) {
        super(gsm);
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Skin skin = new Skin(Gdx.files.internal("gdxSkins/comic/skin/comic-ui.json"));

        Button task1 = createTxtButton("Task 1", skin, 200);
        task1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsm.set(new PlayState_1(gsm));
            }
        });
        Button task2 = createTxtButton("Task 2", skin, 200);
        task2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });
        Button task3 = createTxtButton("Task 3", skin, 200);
        task3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });
        Button task4 = createTxtButton("Task 4", skin, 200);
        task4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            }
        });
        stage.addActor(task1);
        stage.addActor(task2);
        stage.addActor(task3);
        stage.addActor(task4);
    }

    @Override
    protected void handleInput() {

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
        TextButton btn = new TextButton(name, skin);
        btn.setSize(BTN_W, BTN_H);
        btn.setPosition(BTN_POS_X, y);
        return btn;
    }
}

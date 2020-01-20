package com.ntnu.game.states.play;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ntnu.game.HelicopterGame;
import com.ntnu.game.sprites.Helicopter;
import com.ntnu.game.states.GameStateManager;
import com.ntnu.game.states.State;

public class PlayState_1 extends State {

    private Helicopter helicopter;

    public PlayState_1(final GameStateManager gsm) {
        super(gsm);
        helicopter = new Helicopter(50, 100);
    }

    @Override
    public void update(float dt) {
        helicopter.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(helicopter.getHelicopter(),
                helicopter.getPosition().x,
                helicopter.getPosition().y,
                HelicopterGame.HELICOPTER_WIDTH,
                HelicopterGame.HELICOPTER_HEIGHT);
        sb.end();
    }

    @Override
    public void dispose() {
        helicopter.dispose();
    }
}

package com.ntnu.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.ntnu.game.HelicopterGame;

import java.util.Random;

public class Helicopter {

    private static final int SPEED = 10;

    private int moveX;

    private int moveY;

    private Random rand;

    private Vector3 position;

    private Sprite helicopter;

    public Helicopter(int x, int y) {
        rand = new Random();
        position = new Vector3(x, y, 0);
        helicopter = new Sprite(new Texture("helicopters/heli_1.png"));
        helicopter.flip(true, false);
        moveX = getRandomSpeed(true);
        moveY = getRandomSpeed(true);
    }

    public void update() {
        if (position.x <= 0) {
            switchX();
        } else if (position.x >= (HelicopterGame.SCREEN_WIDTH - HelicopterGame.HELICOPTER_WIDTH)) {
            switchX();
        }
        if (position.y <= 0) {
            switchY();
        } else if (position.y >= (HelicopterGame.SCREEN_HEIGHT - HelicopterGame.HELICOPTER_HEIGHT)) {
            switchY();
        }
        position.add(moveX, moveY, 0);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Sprite getHelicopter() {
        return helicopter;
    }

    private void switchX() {
        moveX = -moveX;
        moveY = getRandomSpeed(false);
        helicopter.flip(true, false);
    }

    private void switchY() {
        moveY = -moveY;
    }

    private int getRandomSpeed(boolean nonZero) {
        int speed = rand.nextInt(SPEED) - SPEED / 2;
        if (nonZero && speed == 0) {
            getRandomSpeed(nonZero);
        }
        return speed;
    }

    public void dispose(){

    }
}

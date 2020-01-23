package com.ntnu.game.sprites

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.HelicopterGame

class Helicopter(var movement: Vector2 = Vector2(0f, 0f),
                 val position: Vector2 = Vector2(0f, 0f)) : IHelicopter {

    private var helicopter: AnimatedHelicopter = AnimatedHelicopter()

    private var oldX = if (movement.x > 0) 1f else -1f

    init {
        if (movement.x > 0) {
            helicopter.flip()
        }

    }

    override fun update(dt: Float) {
        helicopter.update(dt)
        position.add(movement)
        if (oldX * movement.x < 0) {
            helicopter.flip()
        }
        oldX = if (movement.x == 0f) oldX else movement.x

    }

    override fun switchX() {
        movement.x = -movement.x
    }

    override fun switchY() {
        movement.y = -movement.y
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        sb.draw(helicopter.getFrame(),
                position.x,
                position.y,
                HelicopterGame.HELICOPTER_WIDTH.toFloat(),
                HelicopterGame.HELICOPTER_HEIGHT)
        sb.end()
    }
}


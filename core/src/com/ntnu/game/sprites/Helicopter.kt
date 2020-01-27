package com.ntnu.game.sprites

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.states.BaseState

class Helicopter(var movement: Vector2 = Vector2(0f, 0f),
                 var position: Vector2 = Vector2(0f, 0f)) : IHelicopter {

    private var helicopterSprite: AnimatedHelicopter = AnimatedHelicopter()

    private var oldX = if (movement.x > 0) 1f else -1f

    init {
        if (movement.x > 0) {
            helicopterSprite.flip()
        }

    }

    override fun update(dt: Float) {
        helicopterSprite.update(dt)
        if (oldX * movement.x < 0) {
            helicopterSprite.flip()
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
        sb.draw(helicopterSprite.getFrame(),
                position.x,
                position.y,
                BaseState.HELICOPTER_WIDTH,
                BaseState.HELICOPTER_HEIGHT)
        sb.end()
    }
}


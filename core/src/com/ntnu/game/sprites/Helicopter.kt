package com.ntnu.game.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.HelicopterGame

class Helicopter(var movement: Vector2 = Vector2(0f, 0f),
                 var position: Vector2 = Vector2(0f, 0f)) : IHelicopter {

    var helicopter: Sprite = Sprite(Texture("helicopters/heli_1.png"))

    init {
        helicopter.flip(movement.x > 0, false)
    }

    override fun update() {
        position.add(movement)
    }

    override fun switchX() {
        movement.x = -movement.x
        helicopter.flip(true, false)
    }

    override fun switchY() {
        movement.y = -movement.y
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        sb.draw(helicopter,
                position.x,
                position.y,
                HelicopterGame.HELICOPTER_WIDTH.toFloat(),
                HelicopterGame.HELICOPTER_HEIGHT)
        sb.end()

    }

    override fun dispose() {
    }
}


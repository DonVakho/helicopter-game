package com.ntnu.game.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2

class Helicopter(private var movementSpeed: Vector2 = Vector2(0f, 0f),
                 var position: Vector2 = Vector2(0f, 0f)) : IHelicopter {

    var helicopter: Sprite = Sprite(Texture("helicopters/heli_1.png"))

    init {
        helicopter.flip(movementSpeed.x > 0, false)
    }

    override fun update() {
        position.add(movementSpeed)
    }

    override fun switchX() {
        movementSpeed.x = -movementSpeed.x
        helicopter.flip(true, false)
    }

    override fun switchY() {
        movementSpeed.y = -movementSpeed.y
    }

}


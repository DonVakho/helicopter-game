package com.ntnu.game.sprites

import com.badlogic.gdx.graphics.g2d.SpriteBatch

interface IHelicopter {

    fun update(dt: Float)

    fun render(sb: SpriteBatch)

    fun switchX()

    fun switchY()
}

package com.ntnu.game.states.play

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.GameLogic
import com.ntnu.game.sprites.Helicopter
import com.ntnu.game.states.IState
import kotlin.random.Random

class PlayState3 : IState {

    private val logic: GameLogic = GameLogic()

    init {
        for (i in 1..5) {
            logic.addHeli(Helicopter(Vector2(Random.nextFloat()*10f, Random.nextFloat() * 10f)))
        }

    }

    override fun update(dt: Float) {
        logic.update(dt)
    }

    override fun render(sb: SpriteBatch) {
        logic.render(sb)
    }

    override fun dispose() {
    }
}
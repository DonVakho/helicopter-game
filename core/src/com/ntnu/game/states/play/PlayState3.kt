package com.ntnu.game.states.play

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.GameLogic
import com.ntnu.game.sprites.Helicopter
import com.ntnu.game.states.BaseState
import kotlin.random.Random

class PlayState3 : BaseState() {

    private val logic: GameLogic = GameLogic()

    init {
        for (i in 1..5) {
            logic.addHelicopter(Helicopter(Vector2(Random.nextFloat() * 10f + 5, Random.nextFloat() * 13f + 8),
                    Vector2(Random.nextFloat() * 100, Random.nextFloat() * 300)))
        }
        createBackButton()
    }

    override fun update(dt: Float) {
        logic.update(dt)
    }

    override fun render(sb: SpriteBatch) {
        super.render(sb)
        logic.render(sb)
    }

    override fun dispose() {
    }
}
package com.ntnu.game.states.play

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.GameLogic
import com.ntnu.game.sprites.Helicopter
import com.ntnu.game.states.BaseState
import com.ntnu.game.states.GameStateManager
import kotlin.random.Random

class PlayState1(gsm: GameStateManager) : BaseState(gsm) {

    private val helicopter: Helicopter = Helicopter(Vector2(Random.nextFloat() * 10f + 5, Random.nextFloat() * 13f + 8),
            Vector2(5f, 5f))

    private val logic: GameLogic = GameLogic()

    init {
        logic.addHeli(helicopter)
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

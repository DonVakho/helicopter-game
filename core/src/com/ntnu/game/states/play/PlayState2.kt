package com.ntnu.game.states.play

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.GameLogic
import com.ntnu.game.sprites.Helicopter
import com.ntnu.game.sprites.Controller
import com.ntnu.game.states.IState

class PlayState2: IState {

    private val helicopter: Helicopter = Helicopter(Vector2(2f, 3f), Vector2(5f, 5f))

    private val logic: GameLogic = GameLogic(Controller())

    init {
        logic.addHeli(helicopter)
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
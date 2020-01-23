package com.ntnu.game.states.play

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.GameLogic
import com.ntnu.game.sprites.Helicopter
import com.ntnu.game.states.IState

class PlayState3 : IState {

    private val helicopter1: Helicopter = Helicopter(Vector2(2f, 3f), Vector2(5f, 20f))

    private val helicopter2: Helicopter = Helicopter(Vector2(3f, -4f), Vector2(200f, 500f))

    private val helicopter3: Helicopter = Helicopter(Vector2(-4f, 2f), Vector2(150f, 5f))

    private val logic: GameLogic = GameLogic()

    init {
        logic.helicopters.add(helicopter1)
        logic.helicopters.add(helicopter2)
        logic.helicopters.add(helicopter3)
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
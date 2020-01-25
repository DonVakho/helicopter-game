package com.ntnu.game.states.play

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.ntnu.game.GameLogic
import com.ntnu.game.HelicopterGame
import com.ntnu.game.sprites.Helicopter
import com.ntnu.game.states.BaseState
import com.ntnu.game.states.GameStateManager
import com.ntnu.game.states.IState
import com.ntnu.game.states.MenuState

class PlayState1(gsm: GameStateManager) : BaseState(gsm) {

    private val helicopter: Helicopter = Helicopter(Vector2(-2f, 3f), Vector2(5f, 5f))

    private val logic: GameLogic = GameLogic()

    init {
        logic.helicopters.add(helicopter)
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

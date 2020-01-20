package com.ntnu.game.states.play

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.HelicopterGame
import com.ntnu.game.sprites.Helicopter
import com.ntnu.game.states.IState

class PlayState1 : IState {

    private val helicopter: Helicopter = Helicopter(Vector2(2f,3f), Vector2(5f, 5f))

    private val logic: GameLogic = GameLogic()

    init {
        logic.gameObjects.add(helicopter)
    }

    override fun update(dt: Float) {
        logic.update()
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        sb.draw(helicopter.helicopter,
                helicopter.position.x,
                helicopter.position.y,
                HelicopterGame.HELICOPTER_WIDTH.toFloat(),
                HelicopterGame.HELICOPTER_HEIGHT)
        sb.end()
    }

    override fun dispose() {
        helicopter.dispose()
    }
}

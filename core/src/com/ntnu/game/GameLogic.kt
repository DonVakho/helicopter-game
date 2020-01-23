package com.ntnu.game

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.ntnu.game.sprites.Helicopter
import com.ntnu.game.sprites.Controller


class GameLogic(private val controller: Controller? = null) {

    private val rightWall = HelicopterGame.SCREEN_WIDTH - HelicopterGame.HELICOPTER_WIDTH

    private val upperWall = HelicopterGame.SCREEN_HEIGHT - HelicopterGame.HELICOPTER_HEIGHT

    val helicopters = ArrayList<Helicopter>()

    fun update(dt: Float) {
        for(h: Helicopter in helicopters){
            wallCollision(h)
            h.update(dt)
        }
    }


    fun render(sb: SpriteBatch) {
        for (h: Helicopter in helicopters) {
            h.render(sb)
        }
        controller?.render()
    }

    private fun wallCollision(helicopter: Helicopter) {
        if (helicopter.position.x <= 0) {
            helicopter.switchX()
        } else if (helicopter.position.x >= rightWall) {
            helicopter.switchX()
        }
        if (helicopter.position.y <= 0) {
            helicopter.switchY()
        } else if (helicopter.position.y >= upperWall) {
            helicopter.switchY()
        }
        if (controller != null) {
            helicopter.movement = controller.getDelta()
        }
    }
}
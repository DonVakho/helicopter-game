package com.ntnu.game.states.play

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.ntnu.game.sprites.Helicopter
import com.ntnu.game.HelicopterGame



class GameLogic {

    private val rightWall = HelicopterGame.SCREEN_WIDTH - HelicopterGame.HELICOPTER_WIDTH

    private val upperWall = HelicopterGame.SCREEN_HEIGHT - HelicopterGame.HELICOPTER_HEIGHT

    val helicopters = ArrayList<Helicopter>()

    private val controller: Controller = Controller()

    fun update(){
        for(h: Helicopter in helicopters){
            if (h.position.x <= 0) {
                h.switchX()
            } else if (h.position.x >= rightWall) {
                h.switchX()
            }
            if (h.position.y <= 0) {
                h.switchY()
            } else if (h.position.y >= upperWall) {
                h.switchY()
            }
            h.movement = controller.delta
            h.update()
        }
    }

    fun render(sb: SpriteBatch){
        for(h: Helicopter in helicopters){
            h.render(sb)
        }
        controller.render()
    }
}
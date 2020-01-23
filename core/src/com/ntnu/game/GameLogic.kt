package com.ntnu.game

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.sprites.Helicopter
import com.ntnu.game.sprites.Controller


class GameLogic(private val controller: Controller? = null) {

    private val rightWall = HelicopterGame.SCREEN_WIDTH - HelicopterGame.HELICOPTER_WIDTH

    private val upperWall = HelicopterGame.SCREEN_HEIGHT - HelicopterGame.HELICOPTER_HEIGHT

    val helicopters = ArrayList<Helicopter>()

    fun update(dt: Float){
        for(h:Helicopter in helicopters){

            for(h2:Helicopter in helicopters) {
                if (h.position.x + HelicopterGame.HELICOPTER_WIDTH + h.movement.x > h2.position.x &&
                        h.position.x + h.movement.x < h2.position.x + HelicopterGame.HELICOPTER_WIDTH &&
                        h.position.y + HelicopterGame.HELICOPTER_HEIGHT > h2.position.y &&
                        h.position.y < h2.position.y + HelicopterGame.HELICOPTER_HEIGHT) {
                    h.switchX()
                    h2.switchX()
                }

                if (h.position.x + HelicopterGame.HELICOPTER_WIDTH > h2.position.x &&
                        h.position.x < h2.position.x + HelicopterGame.HELICOPTER_WIDTH &&
                        h.position.y + HelicopterGame.HELICOPTER_HEIGHT + h.movement.y > h2.position.y &&
                        h.position.y + h.movement.y < h2.position.y + HelicopterGame.HELICOPTER_HEIGHT) {
                    h.switchY()
                    h2.switchY()
                }
            }

            val predictedPos = Vector2(h.position.x + h.movement.x, h.position.y + h.movement.y)

            if(predictedPos.x < 0){
                predictedPos.x = Math.abs(predictedPos.x)
                h.switchX()
            }
            if(predictedPos.x > rightWall){
                predictedPos.x = rightWall - (predictedPos.x + HelicopterGame.HELICOPTER_WIDTH - HelicopterGame.SCREEN_WIDTH)
                h.switchX()
            }
            if(predictedPos.y < 0){
                predictedPos.y = Math.abs(predictedPos.y)
                h.switchY()
            }
            if(predictedPos.y > upperWall){
                predictedPos.y = upperWall - (predictedPos.y + HelicopterGame.HELICOPTER_HEIGHT - HelicopterGame.SCREEN_HEIGHT)
                h.switchY()
            }

            if (controller != null){
                h.movement = controller.getDelta()
                h.position = predictedPos
            }else{
                h.position.add(h.movement)
            }
            h.update(dt)
        }
    }

    fun render(sb: SpriteBatch) {
        for (h: Helicopter in helicopters) {
            h.render(sb)
        }
        controller?.render()
    }

    fun collideHelicopters(h1: Helicopter, h2: Helicopter){
        //
    }
}
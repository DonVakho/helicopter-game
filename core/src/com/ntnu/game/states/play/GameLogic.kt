package com.ntnu.game.states.play

import com.ntnu.game.sprites.Helicopter
import com.ntnu.game.HelicopterGame



class GameLogic {

    private val RIGHT_WALL = HelicopterGame.SCREEN_WIDTH - HelicopterGame.HELICOPTER_WIDTH

    private val UP_WALL = HelicopterGame.SCREEN_HEIGHT - HelicopterGame.HELICOPTER_HEIGHT

    private val SPEED = 12

    var gameObjects = ArrayList<Helicopter>()

    fun update(){
        for(o: Helicopter in gameObjects){
            if (o.position.x <= 0) {
                o.switchX()
            } else if (o.position.x >= RIGHT_WALL) {
                o.switchX()
            }
            if (o.position.y <= 0) {
                o.switchY()
            } else if (o.position.y >= UP_WALL) {
                o.switchY()
            }
            o.update()
        }
    }
}
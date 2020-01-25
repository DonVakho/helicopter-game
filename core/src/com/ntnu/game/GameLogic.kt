package com.ntnu.game

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.ntnu.game.sprites.Helicopter
import com.ntnu.game.sprites.Controller
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.Gdx




import kotlin.math.abs


class GameLogic(private val controller: Controller? = null) {

    private val rightWall = HelicopterGame.SCREEN_WIDTH - HelicopterGame.HELICOPTER_WIDTH

    private val upperWall = HelicopterGame.SCREEN_HEIGHT - HelicopterGame.HELICOPTER_HEIGHT

    private val helicopters = ArrayList<Helicopter>()

    private val labels = ArrayList<BitmapFont>()


    fun addHeli(h: Helicopter) {
        helicopters.add(h)
        val font = BitmapFont()
        font.color = Color.BLACK
        labels.add(font)
    }

    fun update(dt: Float) {
        for (h: Helicopter in helicopters) {

            for (h2: Helicopter in helicopters) {
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

            if (predictedPos.x < 0) {
                predictedPos.x = abs(predictedPos.x)
                h.switchX()
            }
            if (predictedPos.x > rightWall) {
                predictedPos.x = rightWall - (predictedPos.x + HelicopterGame.HELICOPTER_WIDTH - HelicopterGame.SCREEN_WIDTH)
                h.switchX()
            }
            if (predictedPos.y < 0) {
                predictedPos.y = abs(predictedPos.y)
                h.switchY()
            }
            if (predictedPos.y > upperWall) {
                predictedPos.y = upperWall - (predictedPos.y + HelicopterGame.HELICOPTER_HEIGHT - HelicopterGame.SCREEN_HEIGHT)
                h.switchY()
            }

            if (controller != null) {
                h.movement = controller.getDelta()
                h.position = predictedPos
            } else {
                h.position.add(h.movement)
            }
            h.update(dt)
        }
    }

    fun render(sb: SpriteBatch) {
        sb.begin()
        for (i in 0 until helicopters.size) {
            labels[i].draw(sb,
                    "${if(helicopters.size > 1) "${i+1})" else ""} x: ${helicopters[i].position.x.toInt()} y: ${helicopters[i].position.y.toInt()}",
                    5f, (HelicopterGame.SCREEN_HEIGHT -  i * 20f) - 20)
        }
        sb.end()
        for (h: Helicopter in helicopters) {
            h.render(sb)
        }
        controller?.render()
    }

}
package com.ntnu.game.sprites

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.utils.*
import com.ntnu.game.states.BaseState

class Controller(private val stage: Stage) {

    private var delta: Vector2 = Vector2(0f, 0f)

    init {

        Gdx.input.inputProcessor = stage

        val touchPadStyle = Touchpad.TouchpadStyle()
        val bgSprite = Sprite(Texture("controller/bg.png"))
        val knobSprite = Sprite(Texture("controller/knob.png"))

        knobSprite.setSize(calcKnobSize(), calcKnobSize())
        val bg = SpriteDrawable(bgSprite)
        val knob = SpriteDrawable(knobSprite)
        touchPadStyle.background = bg
        touchPadStyle.knob = knob

        val touchPad = Touchpad(10f, touchPadStyle)
        touchPad.setBounds(
                (BaseState.SCREEN_WIDTH - calcControllerSize()) / 2,
                20f,
                calcControllerSize(),
                calcControllerSize())
        touchPad.addListener(object : DragListener() {
            override fun drag(event: InputEvent?, x: Float, y: Float, pointer: Int) {
                super.drag(event, x, y, pointer)
                delta.x = touchPad.knobPercentX * 7
                delta.y = touchPad.knobPercentY * 7
            }
        })

         stage.addActor(touchPad)
    }

    fun render() {
        stage.act()
        stage.draw()
    }

    fun getDelta(): Vector2 {
        return delta
    }

    private fun calcKnobSize(): Float {
        val knobSize = BaseState.SCREEN_WIDTH / 11.5f
        return if (knobSize >= 30) knobSize else 30f
    }

    private fun calcControllerSize(): Float {
        val controllerSize = BaseState.SCREEN_WIDTH / 3.5f
        return if (controllerSize >= 100) controllerSize else 100f
    }
}
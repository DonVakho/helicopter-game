package com.ntnu.game.states.play

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.utils.*


class Controller {

    private val stage: Stage = Stage(ScreenViewport())

    var delta: Vector2 = Vector2(0f, 0f)

    init {
        Gdx.input.inputProcessor = stage
        val touchPadStyle = Touchpad.TouchpadStyle()
        val bgSprite = Sprite(Texture("controller/bg.png"))
        val knobSprite = Sprite(Texture("controller/knob.png"))
        val bg = SpriteDrawable(bgSprite)
        knobSprite.setSize(30f, 30f)
        val knob = SpriteDrawable(knobSprite)
        touchPadStyle.background = bg
        touchPadStyle.knob = knob

        val touchPad = Touchpad(10f, touchPadStyle)
        touchPad.setBounds(50f, 50f, 100f, 100f)
        touchPad.addListener(object : DragListener() {
            override fun drag(event: InputEvent?, x: Float, y: Float, pointer: Int) {
                super.drag(event, x, y, pointer)
                delta.x = touchPad.knobPercentX * 2
                delta.y = touchPad.knobPercentY * 2
            }
        })
        stage.addActor(touchPad)
    }

    fun render() {
        stage.act()
        stage.draw()
    }
}
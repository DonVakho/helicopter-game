package com.ntnu.game.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.ntnu.game.HelicopterGame
import com.ntnu.game.states.play.PlayState1
import com.ntnu.game.states.play.PlayState2
import com.ntnu.game.states.play.PlayState3

class MenuState internal constructor(gsm: GameStateManager) : BaseState(gsm) {

    init {
        val btnNum = 3
        val boundsNum = btnNum + 4
        val singleBound = (HelicopterGame.SCREEN_HEIGHT - BTN_H * btnNum) / boundsNum
        val doubleBound = singleBound * 2
        val btnSpace = BTN_H + singleBound


        val task3 = createTxtButton("Task 3", skin, doubleBound.toFloat())
        task3.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.push(PlayState3(gsm))
            }
        })
        val task2 = createTxtButton("Task 2", skin, task3.y + btnSpace)
        task2.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.push(PlayState2(gsm))
            }
        })
        val task1 = createTxtButton("Task 1", skin, task2.y + btnSpace)
        task1.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.push(PlayState1(gsm))
            }
        })

        stage.addActor(task1)
        stage.addActor(task2)
        stage.addActor(task3)
    }

    override fun render(sb: SpriteBatch) {
        super.render(sb)
    }

    override fun update(dt: Float) {}

    override fun dispose() {}


}

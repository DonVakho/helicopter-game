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

class MenuState internal constructor(gsm: GameStateManager) : IState {

    private val stage: Stage = Stage(ScreenViewport())

    init {
        Gdx.input.inputProcessor = stage

        val skin = Skin(Gdx.files.internal("gdxSkins/comic/skin/comic-ui.json"))

        val btnNum = 3
        val boundsNum = btnNum + 4
        val singleBound = (HelicopterGame.SCREEN_HEIGHT - BTN_H * btnNum) / boundsNum
        val doubleBound = singleBound * 2
        val btnSpace = BTN_H + singleBound


        val task3 = createTxtButton("Task 3", skin, doubleBound.toFloat())
        task3.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.set(PlayState3())
            }
        })
        val task2 = createTxtButton("Task 2", skin, task3.y + btnSpace)
        task2.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.set(PlayState2())
            }
        })
        val task1 = createTxtButton("Task 1", skin, task2.y + btnSpace)
        task1.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.set(PlayState1())
            }
        })

        stage.addActor(task1)
        stage.addActor(task2)
        stage.addActor(task3)
    }

    override fun render(sb: SpriteBatch) {
        stage.act()
        stage.draw()
    }

    override fun update(dt: Float) {}

    override fun dispose() {}

    private fun createTxtButton(name: String, skin: Skin, y: Float): TextButton {
        val btnPosX = (HelicopterGame.SCREEN_WIDTH - BTN_W) / 2
        val btn = TextButton(name, skin)
        btn.setSize(BTN_W.toFloat(), BTN_H.toFloat())
        btn.setPosition(btnPosX.toFloat(), y)
        return btn
    }

    companion object {

        private const val BTN_W = HelicopterGame.SCREEN_WIDTH / 2

        private const val BTN_H = BTN_W / 3
    }
}

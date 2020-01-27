package com.ntnu.game.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.viewport.ScreenViewport

abstract class BaseState(val gsm: GameStateManager) : IState {

    protected val stage: Stage = Stage(ScreenViewport())
    protected val skin = Skin(Gdx.files.internal("gdxSkins/comic/skin/comic-ui.json"))

    init {
        Gdx.input.inputProcessor = stage
    }

    protected fun createTxtButton(name: String, skin: Skin, y: Float): TextButton {
        val btnPosX = (SCREEN_WIDTH - BTN_W) / 2
        val btn = TextButton(name, skin)
        btn.setSize(BTN_W.toFloat(), BTN_H.toFloat())
        btn.setPosition(btnPosX.toFloat(), y)
        return btn
    }

    protected fun createBackButton(){
        val btnPosX = SCREEN_WIDTH - BACK_BTN_W
        val btn = TextButton("Back", skin)
        btn.setSize(BACK_BTN_W.toFloat(), BACK_BTN_H.toFloat())
        btn.setPosition(btnPosX.toFloat(), (SCREEN_HEIGHT- BACK_BTN_H).toFloat())

        btn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.set(StartPageState(gsm))
            }
        })
        stage.addActor(btn)
    }

    override fun render(sb: SpriteBatch) {
        stage.act()
        stage.draw()
    }

    companion object {

        val SCREEN_WIDTH = Gdx.graphics.width

        val SCREEN_HEIGHT = Gdx.graphics.height

        val HELICOPTER_WIDTH = SCREEN_WIDTH / 4.3209876f

        val HELICOPTER_HEIGHT = SCREEN_HEIGHT/19.4953846f

        private  val BTN_W = SCREEN_WIDTH / 2
        private  val BACK_BTN_W = SCREEN_WIDTH / 5

        internal  val BTN_H = BTN_W / 3
        internal  val BACK_BTN_H = BTN_W / 4
    }
}
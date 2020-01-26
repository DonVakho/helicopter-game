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

abstract class BaseState(val gsm: GameStateManager) : IState {

    protected val stage: Stage = Stage(ScreenViewport())
    protected val skin = Skin(Gdx.files.internal("gdxSkins/comic/skin/comic-ui.json"))

    init {
        Gdx.input.inputProcessor = stage
    }

    protected fun createTxtButton(name: String, skin: Skin, y: Float): TextButton {
        val btnPosX = (HelicopterGame.SCREEN_WIDTH - BTN_W) / 2
        val btn = TextButton(name, skin)
        btn.setSize(BTN_W.toFloat(), BTN_H.toFloat())
        btn.setPosition(btnPosX.toFloat(), y)
        return btn
    }

    protected fun createBackButton(){
        val btnPosX = HelicopterGame.SCREEN_WIDTH - BACK_BTN_W
        val btn = TextButton("Back", skin)
        btn.setSize(BACK_BTN_W.toFloat(), BACK_BTN_H.toFloat())
        btn.setPosition(btnPosX.toFloat(), (HelicopterGame.SCREEN_HEIGHT- BACK_BTN_H).toFloat())

        btn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.set(MenuState(gsm))
            }
        })
        stage.addActor(btn)
    }

    override fun render(sb: SpriteBatch) {
        stage.act()
        stage.draw()
    }

    companion object {

        private const val BTN_W = HelicopterGame.SCREEN_WIDTH / 2
        private const val BACK_BTN_W = HelicopterGame.SCREEN_WIDTH / 5

        internal const val BTN_H = BTN_W / 3
        internal const val BACK_BTN_H = BTN_W / 4
    }
}
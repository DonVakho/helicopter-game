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

class StartPageState(gsm: GameStateManager) : IState {

    private val stage: Stage = Stage(ScreenViewport())

    init {
        Gdx.input.inputProcessor = stage

        val skin = Skin(Gdx.files.internal("gdxSkins/comic/skin/comic-ui.json"))

        val btnW = HelicopterGame.SCREEN_WIDTH / 2
        val btnH = btnW / 3
        val btnPosX = (HelicopterGame.SCREEN_WIDTH - btnW) / 2
        val btnPosY = (HelicopterGame.SCREEN_HEIGHT - btnH) / 2

        val playBtn = TextButton("Play", skin)
        playBtn.setSize(btnW.toFloat(), btnH.toFloat())
        playBtn.setPosition(btnPosX.toFloat(), btnPosY.toFloat())
        playBtn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.set(MenuState(gsm))
            }
        })

        stage.addActor(playBtn)
    }

    override fun update(dt: Float) {}

    override fun render(sb: SpriteBatch) {
        stage.act()
        stage.draw()
    }

    override fun dispose() {

    }
}
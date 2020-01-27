package com.ntnu.game.states

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener

class StartPageState(gsm: GameStateManager) : BaseState(gsm) {

    init {
        val btnW = SCREEN_WIDTH / 2
        val btnH = btnW / 3
        val btnPosX = (SCREEN_WIDTH - btnW) / 2
        val btnPosY = (SCREEN_HEIGHT - btnH) / 2

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

    override fun render(sb: SpriteBatch) {
        stage.act()
        stage.draw()
    }

    override fun update(dt: Float) {}

    override fun dispose() {
    }
}

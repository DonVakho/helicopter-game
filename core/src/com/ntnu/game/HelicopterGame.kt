package com.ntnu.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.ntnu.game.states.GameStateManager
import com.ntnu.game.states.StartPageState

class HelicopterGame : ApplicationAdapter() {

    private val gsm: GameStateManager = GameStateManager()

    private var batch: SpriteBatch? = null

    override fun create() {
        batch = SpriteBatch()
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        gsm.push(StartPageState(gsm))
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        gsm.update(Gdx.graphics.deltaTime)
        gsm.render(batch!!)
    }

    override fun dispose() {
        super.dispose()
        batch?.dispose()
    }

}

package com.ntnu.game.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.ntnu.game.HelicopterGame

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        config.width = HelicopterGame.SCREEN_WIDTH
        config.height = HelicopterGame.SCREEN_HEIGHT
        config.title = HelicopterGame.TITLE
        LwjglApplication(HelicopterGame(), config)
    }
}

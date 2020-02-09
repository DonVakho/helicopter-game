package com.ntnu.game.states

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.ntnu.game.states.play.PlayState1
import com.ntnu.game.states.play.PlayState2
import com.ntnu.game.states.play.PlayState3

class MenuState internal constructor() : BaseState() {

    init {
        val btnNum = 3
        val boundsNum = btnNum + 4
        val singleBound = (SCREEN_HEIGHT - BTN_H * btnNum) / boundsNum
        val doubleBound = singleBound * 2
        val btnSpace = BTN_H + singleBound


        val task3 = createTxtButton("Task 3", skin, doubleBound.toFloat() + singleBound)
        task3.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                GameStateManager.set(PlayState3())
            }
        })
        val task2 = createTxtButton("Task 2", skin, task3.y + btnSpace)
        task2.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                GameStateManager.set(PlayState2())
            }
        })
        val task1 = createTxtButton("Task 1", skin, task2.y + btnSpace)
        task1.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                GameStateManager.set(PlayState1())
            }
        })

        stage.addActor(task1)
        stage.addActor(task2)
        stage.addActor(task3)
    }

    override fun update(dt: Float) {}

    override fun dispose() {}


}

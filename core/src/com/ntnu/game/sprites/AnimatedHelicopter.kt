package com.ntnu.game.sprites

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite


class AnimatedHelicopter {

    var frames: ArrayList<Sprite> = ArrayList()

    private val frameCount = 4

    private val maxFrameTime = 0.1f

    private var currentFrameTime = 0f

    private var frame = 0

    init{
        for(i in 1..4){
            frames.add(Sprite(Texture("helicopters/heli_${i}.png")))
        }
    }

    fun update(dt: Float) {
        currentFrameTime += dt
        if (currentFrameTime > maxFrameTime) {
            frame++
            currentFrameTime = 0f
        }
        if (frame >= frameCount)
            frame = 0

    }

    fun flip(){
       for(frame: Sprite in frames){
           frame.flip(true, false)
       }
    }

    fun getFrame(): Sprite {
        return frames[frame]
    }

}
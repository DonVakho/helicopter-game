package com.ntnu.game.sprites

interface IHelicopter {


    fun update()

    fun switchX()

    fun switchY()

    fun dispose() {}

//    private fun setRandomSpeed(nonZero: Boolean) {
//        val speedX = rand.nextInt(SPEED) - SPEED / 2
//        val speedY = rand.nextInt(SPEED) - SPEED / 2
//        if (nonZero && speedX == 0 && speedY == 0) {
//            setRandomSpeed(true)
//        }
//        movementSpeed.x = speedX.toFloat()
//        movementSpeed.y = speedY.toFloat()
//        if (movementSpeed.x > 0) {
//            helicopter.flip(true, false)
//        }
//    }



//    companion object {
//
//        private const val RIGHT_WALL = HelicopterGame.SCREEN_WIDTH - HelicopterGame.HELICOPTER_WIDTH
//
//        private const val UP_WALL = HelicopterGame.SCREEN_HEIGHT - HelicopterGame.HELICOPTER_HEIGHT
//
//        private const val SPEED = 12
//    }
}

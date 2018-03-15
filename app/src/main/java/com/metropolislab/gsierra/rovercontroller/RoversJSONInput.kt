package com.metropolislab.gsierra.rovercontroller

/**
 * Created by gsierra on 15/03/2018.
 */

internal class RoversJSONInput(x: Int, y: Int, posX: Int, posY: Int, dir: Char, move: String) {
    internal var topRightCorner:TopRightCorner = TopRightCorner(x,y)
    internal var roverPosition:RoverPosition = RoverPosition(posX,posY)
    lateinit var movements: Movements[]
            get() =
    init {

    }
    enum class Movements(val mov: Int) {
        R(1), L(-1), M(0)
    }

    enum class RoverDirection(val dir: Int) {
        N(0), W(1), S(2), E(3)
    }
}

package domain.entities

import domain.valueObjects.Move

interface Board {
    val size: Int
    fun makeMove(move: Move, playerSymbol: Char): Boolean
    fun getGrid(): Array<CharArray>
    fun isFull(): Boolean
}
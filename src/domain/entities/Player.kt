package domain.entities

import domain.valueObjects.Move

interface Player {
    val name: String
    val symbol: Char
    fun getNextMove(board: Board): Move
}
package domain.entities

interface Player {
    val name: String
    val symbol: Char
    fun getNextMove(board: Board): Move
}
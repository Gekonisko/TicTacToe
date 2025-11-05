package domain.entities

interface Board {
    val size: Int
    fun makeMove(move: Move, playerSymbol: Char): Boolean
    fun getGrid(): Array<CharArray>
    fun isFull(): Boolean
}
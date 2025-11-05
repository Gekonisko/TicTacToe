package infrastructure.boards

import domain.entities.*

class TicTacToeBoard : Board {
    override val size = 3
    private val grid = Array(size) { CharArray(size) { ' ' } }

    override fun makeMove(move: Move, playerSymbol: Char): Boolean {
        val (r, c) = move
        if (r !in 0 until size || c !in 0 until size) return false
        if (grid[r][c] != ' ') return false
        grid[r][c] = playerSymbol
        return true
    }

    override fun getGrid(): Array<CharArray> = grid

    override fun isFull(): Boolean = grid.all { row -> row.all { it != ' ' } }
}
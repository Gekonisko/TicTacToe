package fakes

import domain.entities.Board
import domain.valueObjects.Move

class FakeBoard(
    override val size: Int = 3
) : Board {

    private val grid: Array<CharArray> = Array(size) { CharArray(size) { ' ' } }

    override fun makeMove(move: Move, playerSymbol: Char): Boolean {
        val (r, c) = move
        if (r !in 0 until size || c !in 0 until size) return false
        if (grid[r][c] != ' ') return false
        grid[r][c] = playerSymbol
        return true
    }

    override fun getGrid(): Array<CharArray> =
        Array(size) { r -> grid[r].clone() }

    override fun isFull(): Boolean =
        grid.all { row -> row.all { it != ' ' } }

    fun setCell(row: Int, col: Int, symbol: Char) {
        grid[row][col] = symbol
    }

    fun clear() {
        for (r in 0 until size)
            for (c in 0 until size)
                grid[r][c] = ' '
    }
}
package infrastructure.players

import domain.entities.Board
import domain.entities.Player
import domain.entities.Rules
import domain.valueObjects.GameState
import domain.valueObjects.Move

class SmartAIPlayer(override val name: String, override val symbol: Char, private val rules: Rules) : Player {
    override fun getNextMove(board: Board): Move {
        var bestScore = Int.MIN_VALUE
        var bestMove = Move(0, 0)

        val grid = board.getGrid()
        for (r in 0 until board.size) {
            for (c in 0 until board.size) {
                if (grid[r][c] == ' ') {
                    grid[r][c] = symbol
                    val score = minimax(board, false, symbol, opponentSymbol())
                    grid[r][c] = ' '
                    if (score > bestScore) {
                        bestScore = score
                        bestMove = Move(r, c)
                    }
                }
            }
        }
        return bestMove
    }

    private fun minimax(board: Board, isMaximizing: Boolean, aiSymbol: Char, opponent: Char): Int {
        val aiResult = rules.evaluate(board, DummyPlayer(aiSymbol))
        val opponentResult = rules.evaluate(board, DummyPlayer(opponent))

        if (aiResult == GameState.WIN) return 10
        if (opponentResult == GameState.WIN) return -10
        if (aiResult == GameState.DRAW || opponentResult == GameState.DRAW) return 0

        val grid = board.getGrid()
        return if (isMaximizing) {
            var best = Int.MIN_VALUE
            for (r in 0 until board.size) {
                for (c in 0 until board.size) {
                    if (grid[r][c] == ' ') {
                        grid[r][c] = aiSymbol
                        best = maxOf(best, minimax(board, false, aiSymbol, opponent))
                        grid[r][c] = ' '
                    }
                }
            }
            best
        } else {
            var best = Int.MAX_VALUE
            for (r in 0 until board.size) {
                for (c in 0 until board.size) {
                    if (grid[r][c] == ' ') {
                        grid[r][c] = opponent
                        best = minOf(best, minimax(board, true, aiSymbol, opponent))
                        grid[r][c] = ' '
                    }
                }
            }
            best
        }
    }
    private fun opponentSymbol(): Char = if (symbol == 'X') 'O' else 'X'
}
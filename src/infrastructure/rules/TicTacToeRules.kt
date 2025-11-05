package infrastructure.rules

import domain.entities.Board
import domain.entities.GameState
import domain.entities.Player
import domain.entities.Rules

class TicTacToeRules : Rules {

    override fun evaluate(board: Board, currentPlayer: Player): GameState {
        val symbol = currentPlayer.symbol
        val grid = board.getGrid()
        val size = board.size

        for (r in 0 until size) {
            if ((0 until size).all { c -> grid[r][c] == symbol }) {
                return GameState.WIN
            }
        }

        for (c in 0 until size) {
            if ((0 until size).all { r -> grid[r][c] == symbol }) {
                return GameState.WIN
            }
        }

        if ((0 until size).all { i -> grid[i][i] == symbol }) {
            return GameState.WIN
        }

        if ((0 until size).all { i -> grid[i][size - 1 - i] == symbol }) {
            return GameState.WIN
        }

        if (board.isFull()) {
            return GameState.DRAW
        }

        return GameState.IN_PROGRESS
    }
}

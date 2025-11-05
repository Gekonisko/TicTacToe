package domain.entities

import domain.valueObjects.GameState

interface Rules {
    fun evaluate(board: Board, currentPlayer: Player): GameState
}
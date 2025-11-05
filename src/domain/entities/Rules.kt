package domain.entities

interface Rules {
    fun evaluate(board: Board, currentPlayer: Player): GameState
}
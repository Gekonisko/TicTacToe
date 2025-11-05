package application.usecases

import application.ports.PlayTurnPort
import domain.entities.Board
import domain.entities.Player

class PlayTurnUseCase : PlayTurnPort {
    override fun playTurn(board: Board, player: Player): Boolean {
        val move = player.getNextMove(board)
        return board.makeMove(move, player.symbol)
    }
}
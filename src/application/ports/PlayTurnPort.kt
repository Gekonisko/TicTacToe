package application.ports

import domain.entities.Board
import domain.entities.Player

interface PlayTurnPort {
    fun playTurn(board: Board, player: Player): Boolean
}
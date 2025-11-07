package infrastructure.players

import domain.entities.Board
import domain.entities.Player
import domain.valueObjects.Move

class DummyPlayer(override val symbol: Char) : Player {
    override val name = "Dummy"
    override fun getNextMove(board: Board): Move = Move(0, 0)
}
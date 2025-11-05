package fakes

import domain.entities.Board
import domain.valueObjects.Move
import domain.entities.Player

class FakePlayer(
    override val name: String = "TestPlayer",
    override val symbol: Char = 'X',
    private val plannedMoves: MutableList<Move> = mutableListOf(Move(0, 0))
) : Player {

    override fun getNextMove(board: Board): Move {
        return if (plannedMoves.isNotEmpty()) plannedMoves.removeAt(0)
        else Move(0, 0)
    }

    fun addMove(move: Move) {
        plannedMoves.add(move)
    }

    fun setMoves(vararg moves: Move) {
        plannedMoves.clear()
        plannedMoves.addAll(moves)
    }
}
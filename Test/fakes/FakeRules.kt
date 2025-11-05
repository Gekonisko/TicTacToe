package fakes

import domain.entities.Board
import domain.valueObjects.GameState
import domain.entities.Player
import domain.entities.Rules

class FakeRules(
    private var nextResult: GameState = GameState.IN_PROGRESS
) : Rules {

    override fun evaluate(board: Board, currentPlayer: Player): GameState = nextResult

    fun setNextResult(result: GameState) {
        nextResult = result
    }
}

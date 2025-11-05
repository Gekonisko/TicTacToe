package application.usecases

import application.ports.EvaluateStatePort
import domain.entities.Board
import domain.valueObjects.GameState
import domain.entities.Player
import domain.entities.Rules

class EvaluateGameStateUseCase : EvaluateStatePort {
    override fun evaluate(board: Board, rules: Rules, player: Player): GameState {
        return rules.evaluate(board, player)
    }
}
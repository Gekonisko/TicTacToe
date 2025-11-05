package application.ports

import domain.entities.Board
import domain.valueObjects.GameState
import domain.entities.Player
import domain.entities.Rules

interface EvaluateStatePort {
    fun evaluate(board: Board, rules: Rules, player: Player): GameState
}
package application.services

import application.ports.EvaluateStatePort
import application.ports.PlayTurnPort
import application.ports.RenderBoardPort
import domain.entities.Board
import domain.valueObjects.GameState
import domain.entities.Player
import domain.entities.Rules
import domain.entities.ShowBoard
import domain.valueObjects.GameResult

class GameService(
    private val playTurn: PlayTurnPort,
    private val evaluate: EvaluateStatePort,
    private val render: RenderBoardPort
) {
    fun start(board: Board, rules: Rules, players: List<Player>, showBoard: ShowBoard): GameResult {
        var state = GameState.IN_PROGRESS
        var winner: Player? = null

        render.render(board, showBoard)

        outer@ while (state == GameState.IN_PROGRESS) {
            for (player in players) {
                val moveSuccessful = playTurn.playTurn(board, player)
                if (!moveSuccessful) continue
                render.render(board, showBoard)
                state = evaluate.evaluate(board, rules, player)

                when (state) {
                    GameState.WIN -> {
                        winner = player
                        break@outer
                    }
                    GameState.DRAW -> break@outer
                    else -> continue
                }
            }
        }

        render.render(board, showBoard)
        return GameResult(state, winner)
    }
}
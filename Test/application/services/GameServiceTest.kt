package application.services

import application.usecases.EvaluateGameStateUseCase
import application.usecases.PlayTurnUseCase
import application.usecases.RenderBoardUseCase
import domain.entities.Board
import domain.valueObjects.GameState
import domain.valueObjects.Move
import domain.entities.ShowBoard
import fakes.FakeBoard
import fakes.FakePlayer
import fakes.FakeRules
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class GameServiceTest {

    @Test
    fun `should return winner when player wins`() {
        val board = FakeBoard()
        val rules = FakeRules(GameState.WIN)
        val showBoard = object : ShowBoard {
            override fun show(board: Board) = "rendered"
        }
        val player = FakePlayer("Tester", 'X', mutableListOf(Move(0, 0)))

        val service = GameService(
            playTurn = PlayTurnUseCase(),
            evaluate = EvaluateGameStateUseCase(),
            render = RenderBoardUseCase()
        )

        val result = service.start(board, rules, listOf(player), showBoard)

        assertEquals(GameState.WIN, result.state)
        assertEquals("Tester", result.winner?.name)
    }

    @Test
    fun `should return draw when rules return DRAW`() {
        val board = FakeBoard()
        val rules = FakeRules(GameState.DRAW)
        val showBoard = object : ShowBoard {
            override fun show(board: Board) = "rendered"
        }
        val player = FakePlayer("Tester", 'X', mutableListOf(Move(0, 0)))

        val service = GameService(
            playTurn = PlayTurnUseCase(),
            evaluate = EvaluateGameStateUseCase(),
            render = RenderBoardUseCase()
        )

        val result = service.start(board, rules, listOf(player), showBoard)

        assertEquals(GameState.DRAW, result.state)
        assertNull(result.winner)
    }
}

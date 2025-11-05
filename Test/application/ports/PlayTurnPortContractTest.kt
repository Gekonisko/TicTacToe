package application.ports

import domain.valueObjects.Move
import fakes.FakeBoard
import fakes.FakePlayer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

abstract class PlayTurnPortContractTest {

    abstract fun createPort(): PlayTurnPort

    @Test
    fun `should apply player move on the board`() {
        val port = createPort()
        val board = FakeBoard()
        val player = FakePlayer("Tester", 'X', mutableListOf(Move(0, 0)))

        val success = port.playTurn(board, player)

        Assertions.assertTrue(success)
        Assertions.assertEquals('X', board.getGrid()[0][0])
    }

    @Test
    fun `should reject invalid move when cell already occupied`() {
        val port = createPort()
        val board = FakeBoard()
        board.makeMove(Move(0, 0), 'X')
        val player = FakePlayer("Tester", 'O', mutableListOf(Move(0, 0)))

        val success = port.playTurn(board, player)

        Assertions.assertFalse(success)
    }
}
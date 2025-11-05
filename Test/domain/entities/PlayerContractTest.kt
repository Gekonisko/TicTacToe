package domain.entities

import domain.valueObjects.Move
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

abstract class PlayerContractTest {
    abstract fun createPlayer(symbol: Char = 'X', name: String = "Player X"): Player
    abstract fun createBoard(): Board

    @Test
    fun `player should expose non-empty name`() {
        val player = createPlayer()
        Assertions.assertTrue(player.name.isNotBlank(), "Player name must not be blank")
    }

    @Test
    fun `player should expose correct symbol`() {
        val symbol = 'O'
        val player = createPlayer(symbol)
        Assertions.assertEquals(symbol, player.symbol)
    }

    @Test
    fun `player should produce a move within board boundaries`() {
        val board = createBoard()
        val player = createPlayer('X')

        val move = player.getNextMove(board)

        Assertions.assertTrue(
            move.row in 0 until board.size && move.col in 0 until board.size,
            "Player produced move out of board range: $move"
        )
    }

    @Test
    fun `player should not choose already occupied cell`() {
        val board = createBoard()
        val player = createPlayer('X')

        board.makeMove(Move(1, 1), 'O')

        val move = player.getNextMove(board)

        Assertions.assertNotEquals(
            Move(1, 1), move,
            "Player chose an already occupied cell: $move"
        )
    }

    @Test
    fun `player should return new Move instance each time`() {
        val board = createBoard()
        val player = createPlayer('X')

        val first = player.getNextMove(board)
        val second = player.getNextMove(board)

        Assertions.assertNotSame(first, second, "Player returned the same Move instance twice")
    }
}
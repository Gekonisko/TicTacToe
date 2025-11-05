package infrastructure.players

import domain.entities.Board
import domain.entities.Move
import domain.entities.Player
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

abstract class PlayerContractTest {
    abstract fun createPlayer(symbol: Char = 'X', name: String = "Player X"): Player
    abstract fun createBoard(): Board

    @Test
    fun `player should expose non-empty name`() {
        val player = createPlayer()
        assertTrue(player.name.isNotBlank(), "Player name must not be blank")
    }

    @Test
    fun `player should expose correct symbol`() {
        val symbol = 'O'
        val player = createPlayer(symbol)
        assertEquals(symbol, player.symbol)
    }

    @Test
    fun `player should produce a move within board boundaries`() {
        val board = createBoard()
        val player = createPlayer('X')

        val move = player.getNextMove(board)

        assertTrue(
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

        assertNotEquals(
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

        assertNotSame(first, second, "Player returned the same Move instance twice")
    }
}

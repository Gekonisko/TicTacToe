package domain.entities

import domain.valueObjects.GameState
import domain.valueObjects.Move
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

abstract class RulesContractTest {
    abstract fun createRules(): Rules
    abstract fun createBoard(): Board
    abstract fun createPlayer(symbol: Char = 'X', name: String = "Player X"): Player

    @Test
    fun `should return IN_PROGRESS on empty board`() {
        val rules = createRules()
        val board = createBoard()
        val player = createPlayer('X')

        val state = rules.evaluate(board, player)

        Assertions.assertEquals(GameState.IN_PROGRESS, state)
    }

    @Test
    fun `should detect WIN when player has three in a row`() {
        val rules = createRules()
        val board = createBoard()
        val player = createPlayer('X')

        board.makeMove(Move(0, 0), player.symbol)
        board.makeMove(Move(0, 1), player.symbol)
        board.makeMove(Move(0, 2), player.symbol)

        val state = rules.evaluate(board, player)

        Assertions.assertEquals(GameState.WIN, state, "Rules should detect a win for player X")
    }

    @Test
    fun `should detect DRAW when board is full and no winner`() {
        val rules = createRules()
        val board = createBoard()
        val player = createPlayer('X')

        val pattern = listOf(
            "XOX",
            "XXO",
            "OXO"
        )
        for (r in pattern.indices)
            for (c in pattern[r].indices)
                board.makeMove(Move(r, c), pattern[r][c])

        val state = rules.evaluate(board, player)

        Assertions.assertEquals(GameState.DRAW, state)
    }

    @Test
    fun `should not modify board during evaluation`() {
        val rules = createRules()
        val board = createBoard()
        val player = createPlayer('X')

        board.makeMove(Move(1, 1), 'O')
        val snapshot = board.getGrid().map { it.clone() }

        rules.evaluate(board, player)

        for (r in board.getGrid().indices) {
            Assertions.assertArrayEquals(snapshot[r], board.getGrid()[r])
        }
    }
}
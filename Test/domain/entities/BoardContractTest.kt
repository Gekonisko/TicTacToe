package domain.entities

import domain.valueObjects.Move
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

abstract class BoardContractTest {

    abstract fun createBoard(): Board

    @Test
    fun `empty board should have all empty cells`() {
        val board = createBoard()

        for (r in 0 until board.size)
            for (c in 0 until board.size)
                Assertions.assertEquals(
                    ' ', board.getGrid()[r][c],
                    "Expected empty cell at ($r, $c)"
                )
    }

    @Test
    fun `player can place mark on empty cell`() {
        val board = createBoard()
        val success = board.makeMove(Move(0, 0), 'X')

        Assertions.assertTrue(success, "Expected move to succeed on empty cell")
        Assertions.assertEquals('X', board.getGrid()[0][0])
    }

    @Test
    fun `player cannot place mark on occupied cell`() {
        val board = createBoard()

        board.makeMove(Move(0, 0), 'X')
        val success = board.makeMove(Move(0, 0), 'O')

        Assertions.assertFalse(success, "Expected move to fail on occupied cell")
        Assertions.assertEquals('X', board.getGrid()[0][0])
    }

    @Test
    fun `board reports not full when any empty cell exists`() {
        val board = createBoard()
        Assertions.assertFalse(board.isFull(), "Expected board not to be full initially")
    }

    @Test
    fun `board reports full when all cells are filled`() {
        val board = createBoard()
        for (r in 0 until board.size)
            for (c in 0 until board.size)
                board.makeMove(Move(r, c), if ((r + c) % 2 == 0) 'X' else 'O')

        Assertions.assertTrue(board.isFull(), "Expected board to be full after all moves")
    }
}
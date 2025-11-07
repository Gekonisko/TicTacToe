package infrastructure.players

import domain.entities.Rules
import domain.valueObjects.Move
import infrastructure.boards.TicTacToeBoard
import infrastructure.rules.TicTacToeRules
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SmartAIPlayerTest {
    private val rules: Rules = TicTacToeRules()

    @Test
    fun `AI should take immediate winning move`() {
        val board = TicTacToeBoard()
        val ai = SmartAIPlayer("AI-X", 'X', rules)

        // X | X |
        // O | O |
        //   |   |
        val grid = board.getGrid()
        grid[0][0] = 'X'
        grid[0][1] = 'X'
        grid[1][0] = 'O'
        grid[1][1] = 'O'

        val move = ai.getNextMove(board)

        assertEquals(Move(0, 2), move)
    }

    @Test
    fun `AI should block opponent's winning move`() {
        val board = TicTacToeBoard()
        val ai = SmartAIPlayer("AI-O", 'O', rules)

        // X | X |
        //   |   |
        //   |   |
        val grid = board.getGrid()
        grid[0][0] = 'X'
        grid[0][1] = 'X'

        val move = ai.getNextMove(board)

        assertEquals(Move(0, 2), move)
    }

    @Test
    fun `AI should pick any valid move when no win or block possible`() {
        val board = TicTacToeBoard()
        val ai = SmartAIPlayer("AI-X", 'X', rules)

        // X | O | X
        // O | X | O
        //   |   |
        val grid = board.getGrid()
        grid[0][0] = 'X'
        grid[0][1] = 'O'
        grid[0][2] = 'X'
        grid[1][0] = 'O'
        grid[1][1] = 'X'
        grid[1][2] = 'O'

        val move = ai.getNextMove(board)

        val validMoves = listOf(Move(2, 0), Move(2, 1), Move(2, 2))
        assertTrue(validMoves.contains(move))
    }
}
package infrastructure.showBoard

import domain.entities.Board
import domain.entities.Move
import domain.entities.ShowBoard
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

abstract class ShowBoardContractTest {

    abstract fun createShowBoard(): ShowBoard
    abstract fun createBoard(): Board

    @Test
    fun `should return non-empty string`() {
        val board = createBoard()
        val renderer = createShowBoard()

        val output = renderer.show(board)
        assertTrue(output.isNotBlank(), "ShowBoard must return a non-empty string representation")
    }

    @Test
    fun `should contain current symbols on the board`() {
        val board = createBoard()
        board.makeMove(Move(0, 0), 'X')
        board.makeMove(Move(1, 1), 'O')

        val renderer = createShowBoard()
        val output = renderer.show(board)

        assertTrue(output.contains("X"), "Rendered output should include X")
        assertTrue(output.contains("O"), "Rendered output should include O")
    }

    @Test
    fun `should contain grid separators for readability`() {
        val board = createBoard()
        val renderer = createShowBoard()
        val output = renderer.show(board)

        assertTrue(
            output.contains("|") || output.contains("-") || output.contains("+"),
            "Rendered output should contain visual separators like |, -, or +"
        )
    }

    @Test
    fun `should render correct number of rows`() {
        val board = createBoard()
        val renderer = createShowBoard()

        val output = renderer.show(board)
        val rows = output.lines().filter { it.isNotBlank() }

        assertTrue(
            rows.size >= board.size,
            "Rendered output should have at least ${board.size} visible rows"
        )
    }
}

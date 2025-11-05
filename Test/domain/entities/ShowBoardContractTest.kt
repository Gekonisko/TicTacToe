package domain.entities

import domain.valueObjects.Move
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

abstract class ShowBoardContractTest {

    abstract fun createShowBoard(): ShowBoard
    abstract fun createBoard(): Board

    @Test
    fun `should return non-empty string`() {
        val board = createBoard()
        val renderer = createShowBoard()

        val output = renderer.show(board)
        Assertions.assertTrue(output.isNotBlank(), "ShowBoard must return a non-empty string representation")
    }

    @Test
    fun `should contain current symbols on the board`() {
        val board = createBoard()
        board.makeMove(Move(0, 0), 'X')
        board.makeMove(Move(1, 1), 'O')

        val renderer = createShowBoard()
        val output = renderer.show(board)

        Assertions.assertTrue(output.contains("X"), "Rendered output should include X")
        Assertions.assertTrue(output.contains("O"), "Rendered output should include O")
    }

    @Test
    fun `should contain grid separators for readability`() {
        val board = createBoard()
        val renderer = createShowBoard()
        val output = renderer.show(board)

        Assertions.assertTrue(
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

        Assertions.assertTrue(
            rows.size >= board.size,
            "Rendered output should have at least ${board.size} visible rows"
        )
    }
}
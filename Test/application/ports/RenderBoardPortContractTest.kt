package application.ports

import domain.entities.Board
import domain.entities.ShowBoard
import fakes.FakeBoard
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class RenderBoardPortContractTest {

    abstract fun createPort(): RenderBoardPort

    @Test
    fun `should return board representation from showBoard`() {
        val board = FakeBoard()
        val port = createPort()
        val showBoard = object : ShowBoard {
            override fun show(board: Board) = "rendered"
        }

        val result = port.render(board, showBoard)

        assertEquals("rendered", result)
    }
}
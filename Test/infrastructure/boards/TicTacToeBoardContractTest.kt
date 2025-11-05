package infrastructure.boards

import domain.entities.Board
import domain.entities.BoardContractTest

class TicTacToeBoardContractTest : BoardContractTest() {
    override fun createBoard(): Board = TicTacToeBoard()
}
package infrastructure.boards

import domain.entities.Board

class TicTacToeBoardContractTest : BoardContractTest() {
    override fun createBoard(): Board = TicTacToeBoard()
}
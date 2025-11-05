package infrastructure.showBoard

import domain.entities.Board
import domain.entities.ShowBoard
import infrastructure.boards.TicTacToeBoard

class ConsoleShowBoardContractTest : ShowBoardContractTest() {
    override fun createShowBoard(): ShowBoard = ConsoleShowBoard()
    override fun createBoard(): Board = TicTacToeBoard()
}
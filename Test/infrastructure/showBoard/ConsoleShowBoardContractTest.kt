package infrastructure.showBoard

import domain.entities.Board
import domain.entities.ShowBoard
import domain.entities.ShowBoardContractTest
import infrastructure.boards.TicTacToeBoard

class ConsoleShowBoardContractTest : ShowBoardContractTest() {
    override fun createShowBoard(): ShowBoard = ConsoleShowBoard(false)
    override fun createBoard(): Board = TicTacToeBoard()
}
package infrastructure.players

import domain.entities.Board
import domain.entities.Player
import domain.entities.PlayerContractTest
import infrastructure.boards.TicTacToeBoard

class RandomPlayerContractTest : PlayerContractTest() {

    override fun createPlayer(symbol: Char, name: String): Player =
        RandomPlayer(name, symbol)

    override fun createBoard(): Board = TicTacToeBoard()
}
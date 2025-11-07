package infrastructure.players

import domain.entities.Board
import domain.entities.Player
import domain.entities.PlayerContractTest
import infrastructure.boards.TicTacToeBoard
import infrastructure.rules.TicTacToeRules

class SmartAIPlayerContractTest : PlayerContractTest(){
    override fun createPlayer(symbol: Char, name: String): Player = SmartAIPlayer(name, symbol, TicTacToeRules())

    override fun createBoard(): Board = TicTacToeBoard()
}
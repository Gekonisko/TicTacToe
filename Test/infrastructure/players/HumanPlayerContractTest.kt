package infrastructure.players

import domain.entities.Board
import domain.entities.Player
import infrastructure.boards.TicTacToeBoard
import infrastructure.inputProviders.FakeInputProvider

class HumanPlayerContractTest : PlayerContractTest() {

    override fun createPlayer(symbol: Char, name: String): Player {
        val fakeInputs = listOf("1", "1",
                                "2", "2")
        val fakeInputProvider = FakeInputProvider(fakeInputs)
        return HumanPlayer(name, symbol, fakeInputProvider)
    }

    override fun createBoard(): Board = TicTacToeBoard()
}

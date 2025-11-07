package infrastructure.players

import domain.entities.Board
import domain.entities.Player
import domain.entities.PlayerContractTest
import infrastructure.boards.TicTacToeBoard
import fakes.FakeInputProvider
import fakes.FakeOutputProvider

class HumanPlayerContractTest : PlayerContractTest() {

    override fun createPlayer(symbol: Char, name: String): Player {
        val fakeInputs = listOf("1", "1",
                                "2", "2")
        val fakeInputProvider = FakeInputProvider(fakeInputs)
        val fakeOutputProvider = FakeOutputProvider()
        return HumanPlayer(name, symbol, fakeInputProvider, fakeOutputProvider)
    }

    override fun createBoard(): Board = TicTacToeBoard()
}

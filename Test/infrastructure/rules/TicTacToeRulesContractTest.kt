package infrastructure.rules

import domain.entities.Board
import domain.entities.Player
import domain.entities.Rules
import domain.entities.RulesContractTest
import infrastructure.boards.TicTacToeBoard
import fakes.FakeInputProvider
import infrastructure.players.HumanPlayer

class TicTacToeRulesContractTest : RulesContractTest() {
    override fun createRules(): Rules = TicTacToeRules()

    override fun createBoard(): Board = TicTacToeBoard()

    override fun createPlayer(symbol: Char, name: String) : Player {
        val fakeInputs = listOf("1", "1",
            "2", "2")
        val fakeInputProvider = FakeInputProvider(fakeInputs)
        return HumanPlayer(name, symbol, fakeInputProvider)
    }
}
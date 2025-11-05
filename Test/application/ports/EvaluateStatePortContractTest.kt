package application.ports

import domain.valueObjects.GameState
import fakes.FakeBoard
import fakes.FakePlayer
import fakes.FakeRules
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class EvaluateStatePortContractTest {

    abstract fun createPort(): EvaluateStatePort

    @Test
    fun `should return same result as rules evaluate`() {
        val rules = FakeRules(GameState.WIN)
        val board = FakeBoard()
        val player = FakePlayer()
        val port = createPort()

        val result = port.evaluate(board, rules, player)

        assertEquals(GameState.WIN, result)
    }
}

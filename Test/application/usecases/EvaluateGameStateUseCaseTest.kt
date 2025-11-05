package application.usecases

import application.ports.EvaluateStatePort
import application.ports.EvaluateStatePortContractTest

class EvaluateGameStateUseCaseTest : EvaluateStatePortContractTest() {
    override fun createPort(): EvaluateStatePort = EvaluateGameStateUseCase()
}
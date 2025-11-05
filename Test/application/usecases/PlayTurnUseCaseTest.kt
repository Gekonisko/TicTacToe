package application.usecases

import application.ports.PlayTurnPort
import application.ports.PlayTurnPortContractTest

class PlayTurnUseCaseTest : PlayTurnPortContractTest() {
    override fun createPort(): PlayTurnPort = PlayTurnUseCase()
}
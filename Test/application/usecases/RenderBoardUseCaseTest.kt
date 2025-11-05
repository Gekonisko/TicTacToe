package application.usecases

import application.ports.RenderBoardPort
import application.ports.RenderBoardPortContractTest

class RenderBoardUseCaseTest : RenderBoardPortContractTest() {
    override fun createPort(): RenderBoardPort = RenderBoardUseCase()
}
package application.usecases

import application.ports.RenderBoardPort
import domain.entities.Board
import domain.entities.ShowBoard

class RenderBoardUseCase : RenderBoardPort {
    override fun render(board: Board, showBoard: ShowBoard): String {
        return showBoard.show(board)
    }
}
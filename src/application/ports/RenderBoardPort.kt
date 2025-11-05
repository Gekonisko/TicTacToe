package application.ports

import domain.entities.Board
import domain.entities.ShowBoard

interface RenderBoardPort {
    fun render(board: Board, showBoard: ShowBoard): String
}
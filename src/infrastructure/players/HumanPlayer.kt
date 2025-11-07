package infrastructure.players

import domain.entities.*
import domain.valueObjects.Move

class HumanPlayer(
    override val name: String,
    override val symbol: Char,
    private val inputProvider: InputProvider,
    private val outputProvider: OutputProvider
) : Player {
    override fun getNextMove(board: Board): Move {
        outputProvider.print("Enter row (1–${board.size}): ")
        val row = inputProvider.readLine().toIntOrNull()?.minus(1) ?: -1

        outputProvider.print("Enter column (1–${board.size}): ")
        val col = inputProvider.readLine().toIntOrNull()?.minus(1) ?: -1

        return Move(row, col)
    }
}
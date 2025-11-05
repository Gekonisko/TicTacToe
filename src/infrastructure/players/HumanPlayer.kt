package infrastructure.players

import domain.entities.*

class HumanPlayer(
    override val name: String,
    override val symbol: Char,
    private val inputProvider: InputProvider
) : Player {

    override fun getNextMove(board: Board): Move {
        print("Enter row (1–${board.size}): ")
        val row = inputProvider.readLine().toIntOrNull()?.minus(1) ?: -1

        print("Enter column (1–${board.size}): ")
        val col = inputProvider.readLine().toIntOrNull()?.minus(1) ?: -1

        return Move(row, col)
    }
}
package infrastructure.players

import domain.entities.*

class RandomPlayer(override val name: String, override val symbol: Char) : Player {

    private val random = java.util.Random()

    override fun getNextMove(board: Board): Move {
        val emptyCells = mutableListOf<Move>()
        for (r in 0 until board.size)
            for (c in 0 until board.size)
                if (board.getGrid()[r][c] == ' ')
                    emptyCells.add(Move(r, c))

        return emptyCells[random.nextInt(emptyCells.size)]
    }
}
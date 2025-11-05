package infrastructure.showBoard

import domain.entities.Board
import domain.entities.ShowBoard

class ConsoleShowBoard(private val autoPrint: Boolean = true) : ShowBoard {

    override fun show(board: Board): String {
        val grid = board.getGrid()
        val size = board.size
        val builder = StringBuilder()

        builder.appendLine()
        for (i in 0 until size) {
            builder.append(" ${grid[i].joinToString(" | ")} ")
            builder.appendLine()
            if (i < size - 1) builder.appendLine("---+---+---")
        }
        builder.appendLine()

        val output = builder.toString().trimEnd()
        if (autoPrint) println(output)

        return builder.toString().trimEnd()
    }
}
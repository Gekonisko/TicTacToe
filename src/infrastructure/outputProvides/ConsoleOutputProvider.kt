package infrastructure.outputProvides

import domain.entities.OutputProvider

class ConsoleOutputProvider : OutputProvider {
    override fun print(text: String) = kotlin.io.print(text)
}
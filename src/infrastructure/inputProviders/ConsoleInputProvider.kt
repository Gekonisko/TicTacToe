package infrastructure.inputProviders

import domain.entities.InputProvider

class ConsoleInputProvider : InputProvider {
    override fun readLine(): String = readln()
}
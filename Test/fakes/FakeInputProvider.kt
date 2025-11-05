package fakes

import domain.entities.InputProvider

class FakeInputProvider(private val inputs: List<String>) : InputProvider {
    private var index = 0
    override fun readLine(): String = inputs[index++]
}
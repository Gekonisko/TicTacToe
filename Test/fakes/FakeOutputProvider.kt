package fakes

import domain.entities.OutputProvider

class FakeOutputProvider : OutputProvider {
    private val _printedMessages = mutableListOf<String>()
    val printedMessages: List<String> get() = _printedMessages

    override fun print(text: String) {
        _printedMessages.add(text)
    }

    fun clear() {
        _printedMessages.clear()
    }
}
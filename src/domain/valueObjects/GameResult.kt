package domain.valueObjects

import domain.entities.Player

data class GameResult(
    val state: GameState,
    val winner: Player?
)
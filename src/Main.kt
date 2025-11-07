import application.usecases.EvaluateGameStateUseCase
import application.services.GameService
import application.usecases.PlayTurnUseCase
import application.usecases.RenderBoardUseCase
import domain.entities.Board
import domain.entities.OutputProvider
import domain.entities.Player
import domain.entities.Rules
import domain.entities.ShowBoard
import domain.valueObjects.GameState
import infrastructure.boards.TicTacToeBoard
import infrastructure.inputProviders.ConsoleInputProvider
import infrastructure.outputProvides.ConsoleOutputProvider
import infrastructure.players.HumanPlayer
import infrastructure.players.RandomPlayer
import infrastructure.players.SmartAIPlayer
import infrastructure.rules.TicTacToeRules
import infrastructure.showBoard.ConsoleShowBoard

fun main() {
    println("Welcome to Kotlin Tic-Tac-Toe!")

    val board: Board = TicTacToeBoard()
    val rules: Rules = TicTacToeRules()
    val showBoard: ShowBoard = ConsoleShowBoard()

    println("Enter name for Player:")
    val playerXName = readln()

    val players: List<Player> = listOf(
        HumanPlayer(playerXName, 'X', ConsoleInputProvider(), ConsoleOutputProvider()),
        SmartAIPlayer("AI Player", 'O', rules)
    )

    val playTurn = PlayTurnUseCase()
    val evaluate = EvaluateGameStateUseCase()
    val render = RenderBoardUseCase()

    val gameService = GameService(
        playTurn = playTurn,
        evaluate = evaluate,
        render = render
    )

    val result = gameService.start(board, rules, players, showBoard)

    if (result.state == GameState.WIN) println("Win player: ${result.winner?.name}")
    println("Game finished: ${result.state}")
    println("Thanks for playing!")
}
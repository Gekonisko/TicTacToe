# TicTacToe Library & CLI Game

This project implements a **Tic-Tac-Toe** game in **Kotlin**, designed as a **reusable library** with a **simple command-line interface**.

The goal of the project is to provide a flexible, testable, and extensible architecture following **Domain-Driven Design (DDD)** and **Clean Architecture** principles.

The library drives the game logic, while the user interface is abstracted away — allowing you to replace the console with a notebook, GUI, or web front-end.
 
## Task Summary (as per JetBrains Internship Assignment)

### Required Features:

1. When starting the game, the app requests the names of Player X and Player O.
2. The initial board state is displayed after players have been named.
3. Players take turns choosing positions to place their marks.
4. The board updates and prints after each move.
5. When the game is over, the result (win or draw) is printed.

### Bonus Features:
6. Player types are configurable — choose between human and computer (random).
7. A “true AI” opponent can make intelligent decisions using the Minimax algorithm.
8. A Kotlin Notebook can demonstrate how to use the library interactively.


## Architecture Overview
The project is built using **Clean Architecture** principles and separates concerns across three layers:

### Domain Layer
- Defines core interfaces:
    `Board`, `Player`, `Rules`, `ShowBoard`
- Defines value objects:
    `Move`, `GameState`
- Contains business rules independent of UI or frameworks.

### Application Layer
- Orchestrates use cases like:
    - `PlayTurnUseCase`
    - `EvaluateGameStateUseCase`
    - `RenderBoardUseCase`
- `GameService` – the main entry point for running a game.
- Depends only on domain abstractions.

### Infrastructure Layer
- Provides concrete implementations:
    - `TicTacToeBoard` -> board logic.
    - `TicTacToeRules` -> rule evaluation (win/draw detection).
    - `ConsoleShowBoard` -> prints the board in CLI.
    - `HumanPlayer`, `RandomPlayer`, `SmartAIPlayer` -> various player types.
    - `InputProvider` / `OutputProvider` -> abstracted I/O for testability.


## Requirements
- Kotlin 1.9+
- JVM (Java 17+ recommended)
- Works in IntelliJ IDEA or via command line using Gradle

## Testing

The project is built with **Test-Driven Development (TDD)**.
Tests cover:
- Board logic (`TicTacToeBoardContractTest`)
- Rule evaluation (`TicTacToeRulesTest`)
- Player logic (`SmartAIPlayerTest`, `RandomPlayerTest`)
- Use cases (`PlayTurnUseCaseTest`, `EvaluateGameStateUseCaseTest`)
- Input/Output using **Fakes**:
- `FakeInputProvider`
- `FakeOutputProvider`
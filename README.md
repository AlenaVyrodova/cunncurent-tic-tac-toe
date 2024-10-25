# 🎮 Concurrent Tic-Tac-Toe

## 🧩 Overview
**Concurrent Tic-Tac-Toe** is a multithreaded Java implementation of the classic Tic-Tac-Toe game. Here, two concurrent threads, each representing a player, compete to place marks on a shared 3x3 board. The goal is to handle synchronization effectively, allowing players to take turns marking the board while managing concurrency issues.

## 📋 Game Mechanics
In **Concurrent Tic-Tac-Toe**:
- The game board is a shared resource and managed by the `TicTacToe` interface.
- Two players ("X" and "O") are implemented using the `Player` interface.
- Each player runs in a separate thread, taking turns to mark the board.
- The game stops once a player wins or the board is full.

## 🚀 Getting Started

### Requirements
- Java 8+
- Maven (for building the project)

### Building the Project
Clone the repository and run:
```bash
mvn clean install

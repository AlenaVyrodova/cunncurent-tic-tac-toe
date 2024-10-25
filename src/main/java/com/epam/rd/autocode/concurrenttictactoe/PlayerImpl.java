package com.epam.rd.autocode.concurrenttictactoe;

import java.util.Arrays;

public class PlayerImpl implements Player{
    private final TicTacToe ticTacToe;
    private final char mark;
    private final PlayerStrategy strategy;

    public PlayerImpl(TicTacToe ticTacToe, char mark, PlayerStrategy strategy) {
        this.ticTacToe = ticTacToe;
        this.mark = mark;
        this.strategy = strategy;
    }

    @Override
    public void run() {
        while (!checkWinner()) {
            synchronized (ticTacToe) {
                if (mark != ticTacToe.lastMark() && !checkWinner() && hasAvailableSpace()) {
                    Move move = strategy.computeMove(mark, ticTacToe);
                    ticTacToe.setMark(move.row, move.column, mark);
                }
            }
        }
    }

    private boolean hasAvailableSpace() {
        return Arrays.stream(ticTacToe.table())
                .flatMap(row -> new String(row).chars().mapToObj(c -> (char) c))
                .anyMatch(cell -> cell == ' ');
    }

    private boolean checkWinner() {

        for (char[] row : ticTacToe.table()) {
            if (row[0] != ' ' && row[0] == row[1] && row[1] == row[2]) return true;
        }
        for (int j = 0; j < ticTacToe.table()[0].length; j++) {
            if (ticTacToe.table()[0][j] != ' ' &&
                    ticTacToe.table()[0][j] == ticTacToe.table()[1][j] &&
                    ticTacToe.table()[1][j] == ticTacToe.table()[2][j]) return true;
        }

        char center = ticTacToe.table()[1][1];
        if (center == ' ') return false;
        return (ticTacToe.table()[0][0] == center && ticTacToe.table()[2][2] == center) ||
                (ticTacToe.table()[0][2] == center && ticTacToe.table()[2][0] == center);
    }
}
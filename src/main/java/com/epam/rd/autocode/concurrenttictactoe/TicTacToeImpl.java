package com.epam.rd.autocode.concurrenttictactoe;

import java.util.Arrays;

public class TicTacToeImpl implements TicTacToe {

    private static final int BOARD_SIZE = 3;
    private final char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private char lastMark = '0';
    private final Object lock = new Object();
    public TicTacToeImpl() {
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
    }

    @Override
    public void setMark(int x, int y, char mark) {
        synchronized (lock) {
            if (board[x][y] == ' ') {
                board[x][y] = mark;
                lastMark = mark;
            } else {
                throw new IllegalArgumentException("Cannot set Mark more than once.");
            }
    }
    }

    @Override
    public char[][] table() {
        synchronized (lock) {
            char[][] copy = new char[BOARD_SIZE][BOARD_SIZE];
            for (int i = 0; i < BOARD_SIZE; i++) {
                copy[i] =Arrays.copyOf(board[i],BOARD_SIZE);
            }
            return copy;
        }
    }

    @Override
    public char lastMark() {
        synchronized (lock) {
            return lastMark;
        }
    }
}
package testingsudoku;

import java.io.IOException;
import java.util.stream.IntStream;
import GUI.SudokuFrame;
import java.awt.Event;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class BacktrackingAlgorithm {

    private static final int BOARD_SIZE = 9;
    private static final int SUBSECTION_SIZE = 3;
    private static final int BOARD_START = 0;

    private static final int ZERO = 0;
    private static final int MIN = 1;
    private static final int MAX = 9;

    private static int board[][] = new int[9][9];

    public static void setBoard(int[][] board) {
        BacktrackingAlgorithm.board = board;
    }

    public static int[][] getBoard() {
        return board;
    }

    public static void main(String[] args) throws IOException {
        SudokuFrame sudoku = new SudokuFrame();
        sudoku.setVisible(true);
    }

    public static void printBoard() {
        for (int row = BOARD_START; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START; column < BOARD_SIZE; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }

    public boolean solve(int[][] board) {

        for (int row = BOARD_START; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START; column < BOARD_SIZE; column++) {
                if (board[row][column] == ZERO) {
                    for (int k = MIN; k <= MAX; k++) {
                        board[row][column] = k;
                        if (isValid(board, row, column) && solve(board)) {
                            return true;
                        }
                        board[row][column] = ZERO;
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(int[][] board, int row, int column) {
        return rowCheck(board, row)
                && columnCheck(board, column)
                && subsectionCheck(board, row, column);
    }

    private boolean subsectionCheck(int[][] board, int row, int column) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        int subsectionRowStart = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subsectionRowEnd = subsectionRowStart + SUBSECTION_SIZE;

        int subsectionColumnStart = (column / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subsectionColumnEnd = subsectionColumnStart + SUBSECTION_SIZE;

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!boxCheck(board, r, constraint, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean columnCheck(int[][] board, int column) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        for (int range = 0; range < 9; range++) {
            if(!(boxCheck(board ,range,constraint,column))){
                return false;
            }
        }
        return true;
    }
    
    private boolean rowCheck(int[][] board, int row) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        for (int range = 0; range < 9; range++) {
            if(!(boxCheck(board ,row,constraint,range))){
                return false;
            }
        }
        return true;
    }

    private static boolean boxCheck(int[][] board, int row, boolean[] constraint, int column) {
        if (board[row][column] != 0) {
            if (!constraint[board[row][column] - 1]) {
                constraint[board[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }

}

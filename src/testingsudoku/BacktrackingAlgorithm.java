package testingsudoku;

import java.io.IOException;
import GUI.SudokuFrame;

public class BacktrackingAlgorithm {

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
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }

    public boolean solve(int[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        board[row][column] = k;
                        if (isValid(board, row, column) && solve(board)) {
                            return true;
                        }
                        board[row][column] = 0;
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
        boolean[] constraint = new boolean[9];
        int subsectionRowStart = (row / 3) * 3;
        int subsectionRowEnd = subsectionRowStart + 3;

        int subsectionColumnStart = (column / 3) * 3;
        int subsectionColumnEnd = subsectionColumnStart + 3;

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
        boolean[] constraint = new boolean[9];
        for (int range = 0; range < 9; range++) {
            if(!(boxCheck(board ,range,constraint,column))){
                return false;
            }
        }
        return true;
    }
    
    private boolean rowCheck(int[][] board, int row) {
        boolean[] constraint = new boolean[9];
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

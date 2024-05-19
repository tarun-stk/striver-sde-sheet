package org.example.recursion;

//TC: O(9^(9^2))
//SC: rec stack space  O(81)
//Problem link: https://leetcode.com/problems/sudoku-solver/
//Level: Medium
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(k, i, j, board)) {
                            board[i][j] = k;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char ch, int i, int j, char[][] board) {

        for (int r = 0; r < 9; r++) {
            if (board[r][j] == ch)
                return false;
        }
        for (int r = 0; r < 9; r++) {
            if (board[i][r] == ch)
                return false;
        }
        i = (i / 3) * 3;
        j = (j / 3) * 3;
        for (int r = i; r < i + 3; r++) {
            for (int c = j; c < j + 3; c++) {
                if (board[r][c] == ch) {
                    return false;
                }
            }
        }
        return true;
    }
}

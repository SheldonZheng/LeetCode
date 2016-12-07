/**
 * Created by Baiye on 2016/12/7.
 */

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode.36.Valid Sudoku
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet[] row = new HashSet[9];
        HashSet[] col = new HashSet[9];
        HashSet[] cell = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<Character>();
            col[i] = new HashSet<Character>();
            cell[i] = new HashSet<Character>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row[i].contains(board[i][j]) || col[j].contains(board[i][j]) || cell[3 * (i / 3) + j / 3].contains(board[i][j]))
                        return false;
                    else {
                        row[i].add(board[i][j]);
                        col[j].add(board[i][j]);
                        cell[3 * (i / 3) + j / 3].add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}

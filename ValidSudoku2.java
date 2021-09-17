/**
 * LeetCode 36 Valid Sudoku
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            throw new IllegalArgumentException();
        }
        int[][] rows = new int[10][10];
        int[][] cols = new int[10][10];
        int[][] subboxs = new int[10][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int n = c - '0';
                rows[i][n]++;
                cols[j][n]++;
                int subboxIndex = (i / 3 * 3) + j / 3;
                subboxs[subboxIndex][n]++;

                if (rows[i][n] > 1 || cols[j][n] > 1 || subboxs[subboxIndex][n] > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

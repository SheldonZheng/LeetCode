/**
 * LeetCode 130 Surrounded Regions
 */
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return ;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //edge
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board,i,j);
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'F') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board,int i ,int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == 'X' || board[i][j] == 'F') {
            return ;
        }

        board[i][j] = 'F';
        dfs(board,i + 1,j);
        dfs(board,i - 1,j);
        dfs(board,i,j + 1);
        dfs(board,i,j - 1);

        return ;
    }
}

/*
 * LeetCode 51 N-Queens
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars,'.');
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(res,0,board);
        return res;
    }

    public void backtrack(List<List<String>> res,int row,char[][] board) {
        if (row == board.length) {
            res.add(buildList(board));
            return ;
        }
        for (int i = 0; i < board.length; i++) {
            if (!isValid(board,row,i)) {
                continue;
            }
            board[row][i] = 'Q';
            backtrack(res,row + 1,board);
            board[row][i] = '.';
        }
    }

    public boolean isValid(char[][] board,int r, int c) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if (board[i][c] == 'Q') {
                return false;
            }
        }
        for (int i = r - 1,j = c + 1; i >= 0 && j < n;i--,j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = r - 1,j = c - 1; i >= 0 && j >= 0;i--,j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> buildList(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }
}

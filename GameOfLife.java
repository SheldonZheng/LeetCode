/**
 * LeetCode 289 Game of Life
 */
class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return ;
        }
        int[][] updateFlag = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (needUpdate(board,i,j)) {
                    updateFlag[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (updateFlag[i][j] == 1) {
                    board[i][j] = board[i][j] == 1 ? 0 : 1;
                }
            }
        }
        return ;
    }

    private boolean needUpdate(int[][] board,int i,int j) {
        int cur = board[i][j];
        int aliveC = 0;

        int top = Math.max(0,i - 1);
        int left = Math.max(0,j - 1);
        int floor = Math.min(board.length - 1,i + 1);
        int right = Math.min(board[i].length - 1,j + 1);

        for (int x = top; x <= floor; x++) {
            for (int y = left; y <= right; y++) {
                if (x == i && y == j) {
                    continue;
                }
                if (board[x][y] == 1) {
                    aliveC++;
                }
            }
        }

        if (cur == 1) {
            if (aliveC < 2) {
                return true;
            }
            if (aliveC > 3) {
                return true;
            }
            return false;
        } else {
            if (aliveC == 3) {
                return true;
            } else {
                return false;
            }
        }

    }
}

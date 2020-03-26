/**
 * LeetCode 999 Available Captures for Rook
 */
class Solution {
    public int numRookCaptures(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int x = i,y = j;

                        while (true) {
                            x += dx[k];
                            y += dy[k];
                            if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || board[x][y] == 'B') {
                                break;
                            }

                            if (board[x][y] == 'p') {
                                count++;
                                break;
                            }
                        }
                    }
                    return count;
                }
            }
        }
        throw new IllegalArgumentException();
    }
}

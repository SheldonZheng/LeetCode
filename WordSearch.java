/**
 * LeetCode 79 Word Search
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0) {
            return false;
        }
        int maxH = board.length;
        int maxD = board[0].length;
        char startWith = word.charAt(0);
        int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        boolean[][] marked = new boolean[maxH][maxD];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == startWith) {
                    //find
                    if (backtrack(i,j,word,0,board,maxH,maxD,marked,direction)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean backtrack(int i, int j,String word,int cur, char[][] board ,int maxH, int maxD,boolean[][] marked,int[][] direction) {
        if (i >= maxH || i < 0 || j >= maxD || j < 0) {
            return false;
        }

        if (cur == word.length() - 1) {
            return board[i][j] == word.charAt(cur);
        }

        if (board[i][j] == word.charAt(cur)) {
            marked[i][j] = true;
            for (int k = 0; k < direction.length; k++) {
                int nextI = direction[k][0] + i;
                int nextJ = direction[k][1] + j;
                if (!(nextI >= maxH || nextI < 0 || nextJ >= maxD || nextJ < 0) && !marked[nextI][nextJ]) {
                    if (backtrack(nextI, nextJ, word, cur + 1, board, maxH, maxD, marked, direction)) {
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }
}

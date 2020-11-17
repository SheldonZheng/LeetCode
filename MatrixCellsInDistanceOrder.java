/**
 * LeetCode 1030 Matrix Cells in Distance Order
 */
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int dist = 0;
        int cnt = 0;
        int[] step = {-1,1};
        while (cnt < R * C) {
            for (int rowDist = 0; rowDist <= dist; rowDist++) {
                int colDist = dist - rowDist;
                for (int i = 0; i < 2; i++) {
                    int row = r0 + (step[i] * rowDist);
                    for (int j = 0; j < 2; j++) {
                        int col = c0 + (step[j] * colDist);
                        if (row >= 0 && row < R && col >= 0 && col < C) {
                            res[cnt][0] = row;
                            res[cnt][1] = col;
                            cnt++;
                        }
                        if (colDist == 0) {
                            break;
                        }
                    }
                    if (rowDist == 0) {
                        break;
                    }
                }
            }
            dist++;
        }
        return res;
    }
}

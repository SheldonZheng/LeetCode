/**
 * LeetCode 1266 Minimum Time Visiting All Points
 */
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points == null || points.length < 2) {
            return 0;
        }
        int steps = 0;
        for (int i = 1; i < points.length; i++) {
            int prex = points[i - 1][0];
            int prey = points[i - 1][1];

            int curx = points[i][0];
            int cury = points[i][1];
            steps += Math.max(Math.abs(curx - prex),Math.abs(cury - prey));
        }
        return steps;
    }
}

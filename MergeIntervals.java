/**
 * LeetCode 56 Merge Intervals
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        int mergeCount = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) {
                    intervals[j][0] = Math.min(intervals[i][0],intervals[j][0]);
                    intervals[j][1] = Math.max(intervals[j][1],intervals[i][1]);
                    intervals[i] = null;
                    mergeCount++;
                    break;
                }
            }
        }

        int[][] res = new int[intervals.length - mergeCount][2];
        int p = 0;
        for (int[] interval : intervals) {
            if (interval != null) {
                res[p++] = interval;
            }
        }
        return res;
    }
}

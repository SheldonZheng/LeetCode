/**
 * LeetCode 1014 Best Sightseeing Pair
 */
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        if (values == null || values.length < 2) {
            return 0;
        }
        int res = 0;
        int beforeMax = values[0];
        for (int i = 1; i < values.length; i++) {
            res = Math.max(res,beforeMax + values[i] - i);

            beforeMax = Math.max(beforeMax,values[i] + i);
        }
        return res;
    }
}

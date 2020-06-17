/**
 * LeetCode 1014 Best Sightseeing Pair
 */
class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0] + 0;
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            ans = Math.max(ans,max + A[i] - i);
            max = Math.max(max,A[i] + i);
        }
        return ans;
    }
}

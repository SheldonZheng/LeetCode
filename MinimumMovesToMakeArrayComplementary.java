/**
 * LeetCode 1674 Minimum Moves to Make Array Complementary
 */
class Solution {
    public int minMoves(int[] nums, int limit) {
        if (nums == null || nums.length == 0 || limit == 0) {
            return 0;
        }
        // r + 1
        int[] diff = new int[limit * 2 + 2];

        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int first = nums[i];
            int second = nums[n - 1 - i];

            diff[2] += 2;
            diff[(2 * limit) + 1] -= 2;

            diff[Math.min(first,second) + 1] += -1;
            diff[limit + Math.max(first,second) + 1] -= -1;

            diff[first + second] += -1;
            diff[first + second + 1] -= -1;
        }
        int res = n;
        int cur = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            cur += diff[i];
            res = Math.min(cur,res);
        }
        return res;
    }
}

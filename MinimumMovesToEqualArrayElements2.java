/**
 * LeetCode 453 Minimum Moves to Equal Array Elements
 */
class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += (num - min);
        }
        return res;
    }
}

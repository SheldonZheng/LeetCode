/**
 * LeetCode 1365 How Many Numbers Are Smaller Than the Current Number
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] res = new int[nums.length];
        int[] count = new int[101];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[i] = count[nums[i] - 1];
            }
        }
        return res;
    }
}

/**
 * LeetCode 1486 XOR Operation in an Array
 */
class Solution {
    public int xorOperation(int n, int start) {
		if (n == 0) {
			return -1;
		}
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i * 2 + start;
		}
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			res ^= nums[i];
		}
		return res;
	}
}

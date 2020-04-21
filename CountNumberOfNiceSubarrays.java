/**
 * LeetCode 1248 Count Number of Nice Subarrays
 */
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] odd = new int[nums.length + 2];
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                odd[count++] = i;
            }
        }
        odd[0] = -1;// like + 1
        odd[count] = nums.length;
        int ans = 0;
        for (int i = 1; i <= count - k; i++) {
            ans += ((odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]));
        }
        return ans;
    }
}

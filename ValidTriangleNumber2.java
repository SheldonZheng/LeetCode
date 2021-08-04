/**
 * LeetCode 611 Valid Triangle Number 
 */
class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1,k = 0; k <= j; j--) {
                while (k < j && nums[k] + nums[j] <= nums[i]) {
                    k++;
                }
                res += (j - k);
            }
        }
        return res;
    }
}

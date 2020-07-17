/**
 * LeetCode 16 3Sum Closest
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int cur = nums[i] + nums[left] + nums[right];
                res = Math.abs(target - cur) < Math.abs(target - res) ? cur : res;
                if (cur > target) {
                    right--;
                } else if (cur < target) {
                    left++;
                } else {
                    return res;
                }
            }
        }
        return res;
    }
}

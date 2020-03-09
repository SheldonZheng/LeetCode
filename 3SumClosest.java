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
            int pf = i + 1;
            int pe = nums.length - 1;
            while (pf < pe) {
                int cur = nums[pf] + nums[pe] + nums[i];
                res = Math.abs(target - cur) < Math.abs(target - res) ? cur : res;
                if (cur > target) {
                    pe--;
                } else if (cur < target) {
                    pf++;
                } else {
                    return res;
                }
            }
        }
        return res;
    }
}

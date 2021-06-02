/**
 * LeetCode 523 Continuous Subarray Sum
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return false;
        }
        Map<Integer,Integer> container = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % k;
            if (sum == 0 && i > 0) {
                return true;
            }
            if (container.containsKey(sum)) {
                int pre = container.get(sum);
                if (i - pre >= 2) {
                    return true;
                }
            } else {
                container.put(sum,i);
            }
        }
        return false;
    }
}

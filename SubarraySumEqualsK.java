/**
 * LeetCode 560 Subarray Sum Equals K
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        int pre = 0;
        Map<Integer,Integer> container = new HashMap<>();
        container.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (container.containsKey(pre - k)) {
                result += container.get(pre - k);
            }
            container.put(pre,container.getOrDefault(pre,0) + 1);
        }
        return result;
    }
}

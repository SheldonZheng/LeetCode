/**
 * LeetCode 1 Two Sum 
 * 2
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> container = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            if (container.containsKey(v)) {
                return new int[]{container.get(v),i};
            }
            container.put(nums[i],i);
        }
        throw new IllegalArgumentException("no result");
    }
}

//LeetCode 1
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        Map<Integer,Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            temp.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (temp.containsKey(diff) && temp.get(diff) != i) {
                return new int[] {i,temp.get(diff)};
            }
        }
        throw new RuntimeException("What the fuck!");
    }
}

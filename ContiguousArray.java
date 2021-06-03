/**
 * LeetCode 525 Contiguous Array
 */
class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Map<Integer,Integer> container = new HashMap<>();
        int cur = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cur++;
            } else {
                cur--;
            }
            if (cur == 0 && i > 0) {
                maxLength = Math.max(i + 1,maxLength);
            }
            if (container.containsKey(cur)) {
                int pre = container.get(cur);
                maxLength = Math.max(i - pre,maxLength);
            } else {
                container.put(cur,i);
            }
        }
        return maxLength;
    }
}

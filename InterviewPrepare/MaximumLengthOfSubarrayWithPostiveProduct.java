/**
 * LeetCode 1567 Maximum Length of Subarray With Postive Product
 */
class Solution {
    public int getMaxLen(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pos = nums[0] > 0 ? 1 : 0;
        int neg = nums[0] >= 0 ? 0 : 1;
        int res = pos;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                pos++;
                neg = neg > 0 ? neg + 1 : 0;
            } else if (nums[i] < 0) {
                int newPos = neg > 0 ? neg + 1 : 0;
                int newNeg = pos + 1;
                pos = newPos;
                neg = newNeg;
            } else {
                pos = 0;
                neg = 0;
            }
            res = Math.max(res,pos);
        }
        return res;
    }
}

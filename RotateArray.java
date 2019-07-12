/**
 * LeetCode 189 Rotate Array
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        if (k == 0) {
            return ;
        }

        int n = nums.length;

        if (k > n) {
            k = k % n;
        }
        int[] newnums = new int[nums.length];

        int j = 0;

        for (int i = nums.length - k; i < nums.length; i++) {
            newnums[j] = nums[i];
            j++;
        }

        if (j < n) {
            for (int i = 0; i < nums.length - k; i++) {
                newnums[j] = nums[i];
                j++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = newnums[i];
        }

        return;
    }
}

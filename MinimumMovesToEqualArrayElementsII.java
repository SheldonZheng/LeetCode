//LeetCode 462
class Solution {
    public int minMoves2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Arrays.sort(nums);
        int r = 0;
        int i = 0,j = nums.length - 1;
        while (i < j) {
            r += (nums[j] - nums[i]);
            j--;
            i++;
        }
        return r;
    }
}

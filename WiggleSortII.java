/**
 * LeetCode 324 Wiggle Sort II
 */
class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int[] bak = Arrays.copyOf(nums,nums.length);
        Arrays.sort(bak);
        int len = nums.length;
        int mStart = (len + 1) / 2;
        int lStart = len - 1;
        mStart--;
        for (int i = 0; i < len / 2; i++) {
            nums[i * 2] = bak[mStart--];
            nums[i * 2 + 1] = bak[lStart--];
        }
        if (len % 2 != 0) {
            nums[len - 1] = bak[0];
        }
        return;
    }
}

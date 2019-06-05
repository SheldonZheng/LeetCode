//LeetCode 611
class Solution {
    public int triangleNumber(int[] nums) {
        int r = 0;
        if (nums == null || nums.length < 3) {
            return r;
        }
        Arrays.sort(nums);
        
        for (int i = 2; i < nums.length; i++) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    r += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return r;
    }
}

//Leetcode 477

class Solution {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        int n = nums.length;
        for (int i = 0;i<32;i++) {
            int cnt = 0;
            for (int num:nums) {
                cnt += (num >> i) & 0x01;
            }
            result += (cnt * (n - cnt));
        }
        return result;
    }

}

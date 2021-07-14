/**
 * LeetCode 1818 Minimum Absolute Sum Difference 
 */
class Solution {
    int mod = (int) 1e9 + 7;
    public int minAbsoluteSumDiff(int[] nums1,int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        long sum = 0;
        long max = 0;
        for (int i = 0; i < nums1.length; i++) {
            int a = nums1[i];
            int b = nums2[i];
            if (a == b) {
                continue;
            }
            int x = Math.abs(a - b);
            sum += x;
            int l = 0,r = nums1.length - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (sorted[mid] <= b) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int nr = Math.abs(sorted[r] - b);
            if (r + 1 < nums1.length) {
                nr = Math.min(nr,Math.abs(sorted[r + 1] - b));
            }
            if (nr < x) {
                max = Math.max(x - nr,max);
            }
        }
        return (int) ((sum - max) % mod);
    }
}

/**
 * LeetCode.88 Merge Sorted Array
 */
class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return ;
        }
        if (m == 0) {
            System.arraycopy(nums2,0,nums1,0,n);
            return;
        }
        int l = m + n - 1;

        int j = n - 1;
        int i = m - 1;
        while (j >= 0 && i >= 0) {
            nums1[l--] = (nums1[i] < nums2[j] ? nums2[j--] : nums1[i--]);
        }

        while (i >= 0) {
            nums1[l--] = nums1[i--];
        }

        while (j >= 0) {
            nums1[l--] = nums2[j--];
        }

        return;

    }
}

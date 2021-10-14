/**
 * 剑指Offer II 069 山峰数组的顶部
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 1,right = arr.length - 2;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}

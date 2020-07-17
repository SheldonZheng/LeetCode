/**
 * LeetCode Interview 40 最小的k个数
 */
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (arr == null || arr.length < k) {
            throw new IllegalArgumentException();
        }
        return quickSearch(arr,0,arr.length - 1,k - 1);
    }

    private int[] quickSearch(int[] nums,int lo,int hi,int k) {
        int j = partition(nums,lo,hi);
        if (j == k) {
            return Arrays.copyOf(nums,j + 1);
        }
        return j > k ? quickSearch(nums,lo,j - 1,k) : quickSearch(nums , j + 1, hi,k);
    }

    private int partition(int[] nums,int lo,int hi) {
        int v = nums[lo];
        int i = lo,j = hi + 1;
        while (true) {
            do {
                i++;
            } while (i <= hi && nums[i] < v);

            do {
                j--;
            } while (j >= lo && nums[j] > v);

            if (i >= j) {
                break;
            }
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }
}

/**
 * LeetCode 912 Sort an Array
 */
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        quickSort(nums,0,nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums,int begin,int end) {
        if (nums == null || nums.length == 0 || begin > end) {
            return ;
        }
        int k = nums[begin];
        int i = begin,j = end;
        while (i < j) {
            while (nums[j] >= k && i < j) {
                j--;
            }
            while (nums[i] <= k && i < j) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[begin] = nums[i];
        nums[i] = k;
        quickSort(nums,begin,i - 1);
        quickSort(nums,i + 1,end);
    }
}

/**
 * LeetCode Interview 51 数组中的逆序对
 */
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length - 1);
    }

    public int mergeSort(int[] nums,int l,int r) {
        if (l >= r) {
            return 0;
        }
        int mid = (l + r) / 2;
        int count = mergeSort(nums,l,mid) + mergeSort(nums,mid + 1,r);
        int[] temp = new int[r - l + 1];
        int i = l,j = mid + 1,pos = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                count += j - (mid + 1);
                temp[pos++] = nums[i++];
            } else {
                temp[pos++] = nums[j++];
            }
        }
        while (i <= mid) {
            count += (j - (mid + 1));
            temp[pos++] = nums[i++];
        }
        while (j <= r) {
            temp[pos++] = nums[j++];
        }
        System.arraycopy(temp,0,nums,l, r - l + 1);
        return count;
    }
}

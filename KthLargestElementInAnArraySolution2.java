/**
 * LeetCode 215 Kth Largest Element in an Array
 */
class Solution {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a,int l,int r,int target) {
        int index = randomPartition(a,l,r);
        if (target == index) {
            return a[index];
        } else {
            return index < target ? quickSelect(a,index + 1,r,target) : quickSelect(a,l,index - 1,target);
        }
    }

    public int randomPartition(int[] a,int l,int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a,i,r);
        return partition(a,l,r);
    }

    public int partition(int[] a,int l,int r) {
        int x = a[r];
        int i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a,++i,j);
            }
        }
        swap(a,i + 1,r);
        return i + 1;
    }

    public void swap(int[] a,int i,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

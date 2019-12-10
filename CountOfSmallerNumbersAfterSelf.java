/**
 * LeetCode 315 Count of Smaller Numbers After Self
 */
class Solution {
    private int[] temp;
    private int[] counter;
    private int[] indexes;

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int len = nums.length;
        temp = new int[len];
        counter = new int[len];
        indexes = new int[len];

        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }

        divideList(nums,0,len - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < counter.length; i++) {
            res.add(counter[i]);
        }
        return res;
    }

    private void divideList(int[] nums,int l,int r) {
        if (l == r) {
            return ;
        }
        int mid = (l + r) / 2;
        divideList(nums,l,mid);
        divideList(nums,mid + 1,r);

        if (nums[indexes[mid]] > nums[indexes[mid + 1]]) {
            mergeTwoList(nums,l,mid,r);
        }
    }

    private void mergeTwoList(int[] nums,int l,int mid,int r) {
        for (int i = l; i <= r; i++) {
            temp[i] = indexes[i];
        }
        int i = l; //left point
        int j = mid + 1; //right point

        for (int k = l; k <= r; k++) {
            if (i > mid) {
                indexes[k] = temp[j];
                j++;
            } else if (j > r) {
                indexes[k] = temp[i];
                i++;
                counter[indexes[k]] += (r - mid);
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                indexes[k] = temp[i];
                i++;
                counter[indexes[k]] += (j - mid - 1);
            } else {
                indexes[k] = temp[j];
                j++;
            }
        }
    }
}

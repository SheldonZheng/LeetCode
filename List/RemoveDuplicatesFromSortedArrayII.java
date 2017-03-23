package List;

/**
 * @author Baiye
 * @since 2017-03-23
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int sum = 1;
        int cnt = 1;
        int pre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (pre == nums[i]) {
                cnt++;
                if (cnt <= 2) {
                    sum++;
                    nums[sum - 1] = nums[i];
                }
            } else {
                pre = nums[i];
                cnt = 1;
                sum++;
                nums[sum - 1] = nums[i];
            }
        }
        return sum;
    }
}


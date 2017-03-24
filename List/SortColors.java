package List;

/**
 * @author Baiye
 * @since 2017-03-24
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if(nums.length == 0)
            return ;
        int red = -1;
        int white = -1;
        int blue = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[++blue] = 2;
                nums[++white] = 1;
                nums[++red] = 0;
            } else if (nums[i] == 1) {
                nums[++blue] = 2;
                nums[++white] = 1;
            }
            else {
                nums[++blue] = 2;
            }
        }
    }
}

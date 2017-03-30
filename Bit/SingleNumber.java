package Bit;

/**
 * @author Baiye
 * @since 2017-03-30
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        if(nums.length == 0)
            return 0;

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
            System.out.println(result);
        }
        return result;
    }

}

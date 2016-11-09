/**
 * Created by Baiye on 2016/11/9.
 */

/**
 * LeetCode.66.Plus One
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0)
            return digits;

        for(int i = digits.length - 1;i >= 0;--i)
        {
            if(digits[i] <= 8)
            {
                digits[i] = digits[i] + 1;
                break;
            }
            else
            {
                if(i != 0)
                    digits[i] = 0;
                else
                {
                    digits[0] = 0;
                    int[] array = new int[digits.length + 1];
                    array[0] = 1;
                   /* for(int j = 1;j < array.length;j++)
                        array[j] = digits[j - 1];*/

                    return array;
                }
            }

        }
        return digits;
    }

}

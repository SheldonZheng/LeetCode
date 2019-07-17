/**
 * LeetCode 66 Plus One
 */
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        boolean sub = false;
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i >= 0; i--) {

            if (sub) {
                if (digits[i] + 1 > 9) {
                    digits[i] = 0;
                    continue;
                } else {
                    digits[i] += 1;
                    sub = false;
                }
            }
            if (digits[i] > 9) {
                digits[i] = 0;
                sub = true;
            }
        }
        if (sub) {
            int []result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
        return digits;
    }
}

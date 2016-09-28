/**
 * Created by Baiye on 2016/9/28.
 */

/**
 * LeetCode.191.Number of 1 Bits
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 */
public class NumberOf1Bits {
    public int hammingWeight(int value) {
        int count = 0;
        String binaryString = Integer.toBinaryString(value);
        for (int i = 0; i < binaryString.length(); i++) {
            char charAt = binaryString.charAt(i);
            if (charAt == '1') {
                count++;
            }
        }
        return count;
    }
}

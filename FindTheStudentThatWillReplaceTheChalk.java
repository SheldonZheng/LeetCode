/**
 * LeetCode 1894 Find the Student that Will Replace the Chalk
 */
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        if (chalk == null || chalk.length == 0) {
            throw new IllegalArgumentException();
        }
        long sumNumber = 0;
        for (int i : chalk) {
            sumNumber += i;
        }
        
        k %= sumNumber;
        
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        throw new ArithmeticException();
    }
}

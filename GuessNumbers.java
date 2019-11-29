/**
 * LeetCode LCP1 Guess Numbers
 */
class Solution {
    public int game(int[] guess, int[] answer) {
        if (guess == null || guess.length == 0 || answer == null || answer.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                result++;
            }
        }
        return result;
    }
}

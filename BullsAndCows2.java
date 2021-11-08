/**
 * LeetCode 299 Bulls and Cows
 */
class Solution {
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null) {
            return "0A0B";
        }
        int bulls = 0;
        int[] countS = new int[10];
        int[] countG = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                countS[secret.charAt(i) - '0']++;
                countG[guess.charAt(i) - '0']++;
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(countS[i],countG[i]);
        }

        return Integer.toString(bulls).concat("A").concat(Integer.toString(cows)).concat("B");
    }
}

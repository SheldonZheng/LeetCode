/**
 * LeetCode 318 Maximum Product of Word Lengths
 */
class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int[] container = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            container[i] = convert(words[i]);
        }

        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((container[i] & container[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    private int convert(String word) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            int cur = word.charAt(i) - 'a';
            res |= (1 << cur);
        }
        return res;
    }
}

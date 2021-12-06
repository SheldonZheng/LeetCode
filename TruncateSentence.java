/**
 * LeetCode 1816 Truncate Sentence
 */
class Solution {
    public String truncateSentence(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int point = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.toCharArray()[i] == ' ') {
                k--;
            }
            if (k == 1) {
                point = i;
            }
        }
        return s.substring(0,point + 1);
    }
}

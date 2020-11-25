/**
 * LeetCode 1370 Increastring Decreastring String
 */
class Solution {
    public String sortString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] num = new int[26];
        for (char c : s.toCharArray()) {
            num[c - 'a']++;
        }
        StringBuffer res = new StringBuffer();
        while (res.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (num[i] > 0) {
                    res.append((char) (i + 'a'));
                    num[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (num[i] > 0) {
                    res.append((char) (i + 'a'));
                    num[i]--;
                }
            }
        }
        return res.toString();
    }
}

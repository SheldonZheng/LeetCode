/**
 * LeetCode 14 Longest Common Prefix 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null)
            return "";
        if (!(strs.length > 0))
            return "";

        String c = strs[0];
        for (int i = 0; i < c.length(); i++) {
            char a = c.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != a) {
                    return c.substring(0,i);
                }
            }
        }
        return c;
    }
}

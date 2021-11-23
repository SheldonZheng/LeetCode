/**
 * LeetCode 859 Buddy Strings
 */
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
                if (count[s.charAt(i) - 'a'] > 1) {
                    return true;
                }
            }
        } else {
            int l = -1,r = -1;
            for (int i = 0; i < goal.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (l == -1) {
                        l = i;
                    } else if (r == -1) {
                        r = i;
                    } else {
                        return false;
                    }
                }
            }

            return (r != -1 && s.charAt(l) == goal.charAt(r) && s.charAt(r) == goal.charAt(l));
        }
        return false;
    }
}

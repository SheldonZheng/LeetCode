//LeetCode 678
class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int l = 0,r = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                l++;
            } else {
                l--;
            }
            if (l < 0) {
                return false;
            }
        }

        if (l == 0) {
            return true;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') {
                r++;
            } else {
                r--;
            }
            if (r < 0) {
                return false;
            }
        }
        return true;
    }
}

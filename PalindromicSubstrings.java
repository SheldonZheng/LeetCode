/**
 * LeetCode 647 Palindromic Substrings
 */
class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        StringBuffer sb = new StringBuffer("$#");
        for (char c : s.toCharArray()) {
            sb.append(c);
            sb.append("#");
        }
        sb.append("^");
        int n = sb.length();

        int[] container = new int[n];
        int center = 0,rMax = 0,res = 0;
        for (int i = 1; i < n - 1; i++) {
            if (i < rMax) {
                container[i] = Math.min(container[2 * center - i],rMax - i);
            } else {
                container[i] = 1;
            }
            while (sb.charAt(i + container[i]) == sb.charAt(i - container[i])) {
                container[i]++;
            }
            if (i + container[i] > rMax) {
                center = i;
                rMax = i + container[i];
            }

            res += (container[i] / 2);
        }
        return res;
    }
}

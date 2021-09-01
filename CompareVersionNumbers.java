/**
 * LeetCode 165 Compare Version Numbers
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null || version1.length() == 0 || version2.length() == 0) {
            throw new IllegalArgumentException();
        }
        int p1 = 0,p2 = 0;
        while (p1 < version1.length() || p2 < version2.length()) {

            int x = 0;
            while (p1 < version1.length() && version1.charAt(p1) != '.') {
                x = x * 10 + version1.charAt(p1) - '0';
                p1++;
            }
            p1++;
            int y = 0;
            while (p2 < version2.length() && version2.charAt(p2) != '.') {
                y = y * 10 + version2.charAt(p2) - '0';
                p2++;
            }
            p2++;
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}

/**
 * LeetCode 744 Find Smallest Letter Greater Than Target
 */
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters == null || letters.length == 0) {
            return '?';
        }
        if (letters[0] > target || letters[letters.length - 1] <= target) {
            return letters[0];
        }
        int lo = 0;
        int hi = letters.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (letters[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return letters[hi];
    }
}

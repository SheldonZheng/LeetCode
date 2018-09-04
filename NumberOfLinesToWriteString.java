//LeetCode 806
class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int maxLine = 100;
        char[] strs = S.toCharArray();
        int currentLine = 0;
        int lines = 1;
        for (int i = 0; i < strs.length; i++) {
            if (currentLine + (widths[strs[i] - 97]) > maxLine) {
                lines++;
                currentLine = (widths[strs[i] - 97]);
            } else {
                currentLine += widths[strs[i] - 97];
            }
        }
        return new int[] {lines,currentLine};
    }
}

/**
 * LeetCode 1051 Height Checker
 */
class Solution {
    public int heightChecker(int[] heights) {
        int[] container = new int[101];
        for (int height : heights) {
            container[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < container.length; i++) {
            while (container[i]-- > 0) {
                if (heights[j++] != i) {
                    count++;
                }
            }
        }
        return count;
    }
}

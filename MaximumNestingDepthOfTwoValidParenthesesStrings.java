/**
 * LeetCode 1111 Maximum Nesting Depth of Two Valid Parentheses Strings
 */
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        if (seq == null) {
            return null;
        }
        int[] res = new int[seq.length()];
        int p = 0;
        for (char c : seq.toCharArray()) {
            // p % 2 == p & 1
            res[p++] = c == '(' ? p & 1 : (p + 1) & 1;
        }
        return res;
    }
}

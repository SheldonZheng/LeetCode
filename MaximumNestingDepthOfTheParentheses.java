/**
 * LeetCode 1614 Maximum Nesting Depth of the Parentheses
 */
class Solution {
    public int maxDepth(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        int res = 0;
        for (char c : chars) {
            if (c == '(') {
                stack.offer(c);
            } else if (c == ')') {
                stack.pop();
            }
            res = Math.max(res,stack.size());
        }
        return res;
    }
}

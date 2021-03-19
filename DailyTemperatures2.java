/**
 * LeetCode 739 Daily Temperatures
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return null;
        }
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.empty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            res[i] = stack.empty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }
}

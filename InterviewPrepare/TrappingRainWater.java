/**
 * LeetCode 42 Trapping Rain Water
 */
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        while (cur < height.length) {
            while (!stack.empty() && height[cur] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.empty()) {
                    break;
                }
                int dis = cur - stack.peek() - 1;
                int min = Math.min(height[stack.peek()],height[cur]);
                res += dis * (min - h);
            }
            stack.push(cur++);
        }
        return res;
    }
}

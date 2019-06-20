/**
 * LeetCode 42 Trapping Rain Water
 */
class Solution {
    public int trap(int[] height) {
        int count = 0;
        if (height == null || height.length < 2) {
            return count;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < height.length){
            if (stack.empty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            }
            else {
                int j = stack.pop();
                if (stack.isEmpty()) {
                    continue;
                }
                int r =  (Math.min(height[i],height[stack.peek()]) - height[j])  * (i - stack.peek() - 1);
                count += r;
            }
        }
        return count;
    }
}

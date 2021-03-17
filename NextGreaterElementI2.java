/**
 * LeetCode 496 Next Greater Element I
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> container = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek()) {
                container.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.empty()) {
            container.put(stack.pop(),-1);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = container.get(nums1[i]);
        }
        return res;
    }
}

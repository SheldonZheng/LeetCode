//LeetCode 559
class Solution {
    public int maxDepth(Node root) {
            if (null == root)
                return 0;
            if (root.children == null || root.children.size() == 0)
                return 1;
            
            int max = 0;
            for (Node child : root.children) {
                int tempResult = maxDepth(child) + 1;
                if (tempResult > max) {
                    max = tempResult;
                }
            }

            return max;
        }
}

//LeetCode 590
class Solution {
     public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        rTree(root,result);
        return result;
    }

    public void rTree(Node root , List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node child : root.children) {
                rTree(child,result);
            }
        }
        result.add(root.val);
        return;
    }
}

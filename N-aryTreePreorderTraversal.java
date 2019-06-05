//LeetCode 589
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            result.add(temp.val);
            if (temp.children != null) {
                for (int i = temp.children.size() - 1; i >= 0; i--) {
                    stack.push(temp.children.get(i));
                } 
            }
        }

        return result;
    }
}

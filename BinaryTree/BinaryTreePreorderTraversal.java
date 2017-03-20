package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Baiye
 * @since 2017-03-20
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> tempStack = new Stack<>();

        if(root == null)
            return result;

        while(true) {
            while(root != null) {
                result.add(root.val);
                tempStack.push(root);
                root = root.left;
            }
            if(tempStack.isEmpty())
                break;

            root = tempStack.pop().right;
        }

        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

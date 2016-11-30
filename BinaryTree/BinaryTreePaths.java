package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Baiye on 2016/11/30.
 */

/**
 * LeetCode.257. Binary Tree Paths
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root == null)
            return result;

        if(root.left == null && root.right == null)
        {
            result.add(String.valueOf(root.val));
            return result;
        }

        for (String path : binaryTreePaths(root.left))
            result.add(String.valueOf(root.val) + "->" + path);

        for (String path : binaryTreePaths(root.right))
            result.add(String.valueOf(root.val) + "->" + path);

        return result;
    }

    private class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
}

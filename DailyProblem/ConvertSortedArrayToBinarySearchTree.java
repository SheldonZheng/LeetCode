/**
 * LeetCode 108 Convert Sorted Array to Binary Search Tree
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length - 1);
    }

    public TreeNode buildTree(int[] nums,int start,int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = buildTree(nums,start,mid - 1);
        treeNode.right = buildTree(nums,mid + 1,end);
        return treeNode;
    }
}

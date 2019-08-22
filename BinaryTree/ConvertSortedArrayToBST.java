package BinaryTree; /**
 * Created by Baiye on 2016/8/17.
 */

/**
 * LeetCode 108.Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * 因为给出的数组已经排好序，那么就二分下去，拿中点的值作为root，左右节点分别二分，递归求解。特殊情况是左节点或者右节点为空的
 * 2019-08-22
 */

public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {


        return sortedArrayToBST(nums,0,nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums,int start,int end)
    {
        if(start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if(start == end)
            return root;

        root.left = sortedArrayToBST(nums,start,mid - 1);
        root.right = sortedArrayToBST(nums,mid + 1,end);

        return root;

    }


    private class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }
}

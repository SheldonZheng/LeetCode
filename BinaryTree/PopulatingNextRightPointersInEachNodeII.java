package BinaryTree;

/**
 * Created by hang.zheng on 2017/3/8.
 * LeetCode.117
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level = new TreeLinkNode(0);
        TreeLinkNode queue = root;
        while(queue != null) {
            level.next = null;
            TreeLinkNode current = level;
            while(queue != null) {
                if(queue.left != null) {
                    current.next = queue.left;
                    current = current.next;
                }
                if(queue.right != null) {
                    current.next = queue.right;
                    current = current.next;
                }
                queue = queue.next;
            }
            queue = level.next;
        }
    }

    private class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}

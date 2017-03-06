package BinaryTree;

/**
 * Created by hang.zheng on 2017/3/6.
 */
public class PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {
        TreeLinkNode n;

        while(root != null && root.left != null) {
            n = root;
            while(n != null) {
                n.left.next = n.right;

                if(n.next != null) {
                    n.right.next = n.next.left;
                }
                n = n.next;
            }
            root = root.left;
        }
    }



    private class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
}

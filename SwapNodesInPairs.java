/**
 * Created by Baiye on 2016/10/31.
 */

/**
 * LeetCode.24.Swap Nodes in Pairs
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;

        return temp;
    }




      private class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
}

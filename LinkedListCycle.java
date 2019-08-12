/**
 * Created by Baiye on 2016/11/23.
 */

/**
 * LeetCode.141.Linked List Cycle
 */
public class LinkedListCycle {
 a   public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

  a      while (p1 != null && p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2)
                return true;
        }

        return false;
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}



    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}



/**
 * Created by Baiye on 2016/11/23.
 */

/**
 * LeetCode.141.Linked List Cycle
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p1 != null && p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2)
                return true;
        }

        return false;
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



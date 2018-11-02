//LeetCode 148
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
     public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head,slow = head;

        //cut link
        ListNode cut = null;

        while (fast != null && fast.next != null) {
            cut = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //cut link
        cut.next = null;
        

        return mergeTwoListNode(sortList(head),sortList(slow));
    }

    public ListNode mergeTwoListNode(ListNode o ,ListNode t) {
        ListNode c = new ListNode(-1);
        ListNode p = c;

        while (o != null && t != null) {
            if (o.val < t.val) {
                p.next = o;
                o = o.next;
            } else {
                p.next = t;
                t = t.next;
            }
            p = p.next;
        }

        if (o != null) {
            p.next = o;
        }
        if (t != null) {
            p.next = t;
        }

        return c.next;
    }
}

/**
 * LeetCode 2 Add Two Numbers
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p = new ListNode(-1);
        ListNode head = p;
        boolean upNext = false;
        while (l1 != null || l2 != null || upNext) {
            int cV = 0;
            if (l1 != null) {
                cV += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                cV += l2.val;
                l2 = l2.next;
            }
            if (upNext) {
                cV += 1;
            }
            if (cV > 9) {
                upNext = true;
                cV -= 10;
            } else {
                upNext = false;
            }
            p.next = new ListNode(cV);
            p = p.next;
        }

        return head.next;
    }
}

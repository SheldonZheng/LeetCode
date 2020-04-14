/**
 * LeetCode 445 Add Two Numbers II
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
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        boolean addOne = false;
        ListNode holder = new ListNode(-1);
        ListNode newNode = holder;
        int remain = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int num = (x + y + remain) % 10;
            remain = (x + y + remain) / 10;
            ListNode node = new ListNode(num);
            newNode.next = node;
            newNode = newNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (remain > 0) {
            newNode.next = new ListNode(remain);
        }
        return reverseList(holder.next);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode point = head.next;
        pre.next = null;
        ListNode nxt = null;
        while (point != null) {
            nxt = point.next;
            point.next = pre;
            pre = point;
            point = nxt;
        }
        return pre;
    }
}

/**
 * Created by Baiye on 2016/9/18.
 */

/**
 * LeetCode.206.Reverse Linked List
 * Reverse a singly linked list.
 */

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;

        ListNode p = head.next;
        ListNode n = reverseList(p);

        head.next = null;
        p.next = head;

        return n;
    }


    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
    }
}

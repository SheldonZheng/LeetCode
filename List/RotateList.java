package List;

/**
 * Created by Baiye on 24/04/2017.
 */

/**
 * LeetCode.61. Rotate List
 */
public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;

        ListNode tail = head;
        int n = 1;
        while(tail.next != null) {
            n++;
            tail = tail.next;
        }
        k %= n;

        if(k == 0)
            return head;

        int len = n - k;
        ListNode cur = head;
        while(--len != 0) {
            cur = cur.next;
        }

        ListNode post = cur.next;
        cur.next = null;
        tail.next = head;
        return post;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

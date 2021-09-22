/**
 * LeetCode 725 Split Linked List in Parts
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        if (head == null) {
            return result;
        }
        ListNode temp = head;


        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        int splitLength = length / k;
        int otherLength = length % k;
        ListNode cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            result[i] = cur;
            int curSize = splitLength + (i < otherLength ? 1 : 0);
            for (int j = 1; j < curSize; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return result;
    }
}

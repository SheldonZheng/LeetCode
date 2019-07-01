/**
 * LeetCode 23 Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        int n = lists.length;
        while (n > 1) {
            int k = (n + 1) / 2;
            for (int i = 0; i < n / 2; i++) {
                lists[i] = mergeTwoLists(lists[i],lists[i + k]);
            }
            n = k;
        }
        return lists[0];

    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(-1);
        ListNode go = result;
        while (l1 != null && l2 != null) {
                if (l1.val >= l2.val) {
                    go.next = l2;
                    go = go.next;
                    l2 = l2.next;
                } else {
                    go.next = l1;
                    go = go.next;
                    l1 = l1.next;
                }
        }
        if (l1 != null) {
            go.next = l1;
        }
        if (l2 != null) {
            go.next = l2;
        }
        return result.next;
    }
}

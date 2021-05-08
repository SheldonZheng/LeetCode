/**
 * LeetCode 1290 Convert Binary Number in a Linked List to Integer
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
    public int getDecimalValue(ListNode head) {
		if (head == null) {
			return 0;
		}
		int ans = 0;
		while (head != null) {
			ans = ans * 2 + head.val;
			head = head.next;
		}
		return ans;
	}
}

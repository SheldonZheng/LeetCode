/**
 * Created by Baiye on 2016/12/22.
 */

/**
 * LeetCode.19.Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;
		ListNode headPoint = head;
		ListNode first = head;
		ListNode second = head;
		while (n-- > 0) {
			second = second.next;
		}
        if(second == null)
            return headPoint.next;

        while(second.next != null)
        {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return headPoint;
	}
	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}

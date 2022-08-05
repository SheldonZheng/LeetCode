/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func detectCycle(head *ListNode) *ListNode {
	slow ,fast := head,head
	for (fast != nil) {
		if (fast.Next == nil) {
			return nil
		}
		slow = slow.Next
		fast = fast.Next.Next

		if (fast == slow) {
			ptr := head
			for (ptr != slow) {
				ptr = ptr.Next
				slow = slow.Next
			}
			return ptr
		}
	}
	return nil
}

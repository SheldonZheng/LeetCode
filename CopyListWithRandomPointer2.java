/**
 * LeetCode 138 Copy List with Random Pointer
 */
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
    Map<Node,Node> container = new HashMap<>();
    Node holder = new Node(-1);
    Node p1 = holder;
    Node tmp = head;
    while (tmp != null) {
        Node cur = new Node(tmp.val);
        container.put(tmp,cur);
        p1.next = cur;
        p1 = p1.next;
        tmp = tmp.next;
    }
    p1 = holder.next;
    while (head != null) {
        if (head.random != null) {
            p1.random = container.get(head.random);
        }
        p1 = p1.next;
        head = head.next;
    }
    return holder.next;
}

}

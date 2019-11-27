/**
 * LeetCode 138 Copy List with Random Pointer
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    private final static Map<Node,Node> container = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        if (container.containsKey(head)) {
            return container.get(head);
        }

        Node newNode = new Node(head.val,null,null);

        container.put(head,newNode);

        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);

        return newNode;
    }
}

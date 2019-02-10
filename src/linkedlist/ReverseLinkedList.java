package linkedlist;

public class ReverseLinkedList {
    /*
     * Leetcode : 206
     *
     * Thought : Have 3 pointers: previous = null, current = node, next
     * Iterate through the ll using current.
     * copy the next and change current.next to prev.
     * set prev to current and current to next to iterate forward
     * */
    public Node reverse(Node node) {

        Node prev = null;
        Node current = node;

        while (current != null) {

            Node next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }

    /*
     * Thought : Using recursion
     * Termination condition: If there is 0 or 1 node, nothing to reverse, return that node.
     *
     * recursively call reverse for next node. See comments and output for clarity
     *
     * Input : 1->2->3->4->5
     * Ret : 5 Node : 4 Node.next : 5
     * Ret : 5 Node : 3 Node.next : 4
     * Ret : 5 Node : 2 Node.next : 3
     * Ret : 5 Node : 1 Node.next : 2
     * Output : 5->4->3->2->1
     * */

    public Node reverseRecursive(Node node) {

        //if there is 0 or 1 node, nothing to reverse, return the node
        if (node == null || node.next == null) return node;

        // recursively call reverse for next node
        Node ret = reverseRecursive(node.next);

        System.out.println("Ret : " + ret.val + " Node : " + node.val + " Node.next : " + node.next.val);

        // Assume there are 2 node - node(4) -> node.next(5)->null then reverse is 5->4->null
        node.next.next = node;
        node.next = null;

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Node node = Node.insert(nums);
        ReverseLinkedList rll = new ReverseLinkedList();
        node = rll.reverse(node);
        Node.print(node);

        node = Node.insert(nums);
        Node.print(node);
        node = rll.reverseRecursive(node);
        Node.print(node);
    }

}

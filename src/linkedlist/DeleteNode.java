package linkedlist;

public class DeleteNode {
    /*
     * Leetcode : 237
     *
     * Thought : We have a pointer to a node in singly linked list, so we cannot go to node previous to the input node.
     * All we can do is play with the node, node.next and there after.
     *
     * copy the next node's content and set node.next to node.next.next
     * */
    void delete(Node node) {
        if (node == null) return;

        if (node.next == null) {
            System.out.println("Last Node with value " + node.val + " cannot be deleted.");
            return;
        }

        // copy the next node's content and set node.next to node.next.next
        Node nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
        nextNode = null;
    }

    public static void main(String[] args) {
        int [] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node ll = Node.createLL(nums);
        Node.print("Before deleting :",ll);
        Node middle = Node.getNode(ll, 5);
        Node last = Node.getNode(ll, 9);

        DeleteNode dn = new DeleteNode();
        dn.delete(middle);
        Node.print("After deleting :",ll);

        dn.delete(last);

    }
}

package linkedlist.twoormorelinkedlists;

import linkedlist.Node;

public class AddTwoNumbers {
    /*
     * Leetcode : 2
     *
     * Note : The least significant digit is first node. MSD is last node.
     * The solution will be different otherwise.
     *
     * Thought : until both are not null, iterate.
     *
     * sum = carry + value of node that's not null
     *
     * carry = sum / 10
     * newNode.val = sum % 10
     *
     * check carry after all iteration, if there is a carry from last sum
     * add the carry to the result.
     *
     * */
    public Node add(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node iter = dummy;

        int carry = 0;
        while (l1 != null || l2 != null) {

            int sum = carry;

            // add the non-null node's val and move to it's next node
            if (l1 != null) {

                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {

                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;

            iter.next = new Node(sum % 10);
            iter = iter.next;
        }

        // handle any carry from MSD
        if (carry == 1)
            iter.next = new Node(carry);

        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        int[] nums1 = {7, 8, 9};
        int[] nums2 = {5, 4, 3};
        Node l1 = Node.createLL(nums1);
        Node l2 = Node.createLL(nums2);

        Node l3 = atn.add(l1, l2);
        Node.print("Result from adding 2 numbers",l3);

    }

}
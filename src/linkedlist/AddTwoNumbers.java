package linkedlist;

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

    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        int[] nums1 = {7, 8, 9};
        int[] nums2 = {5, 4, 3};
        Node l1 = Node.insert(nums1);
        Node l2 = Node.insert(nums2);

        Node l3 = atn.add(l1, l2);
        Node.print(l3);

    }

    public Node add(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node iter = dummy;

        int carry = 0;
        while (l1 != null || l2 != null) {

            int sum = carry;

            // add the non-null node's val
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

        if (carry == 1) {
            iter.next = new Node(carry);
        }

        return dummy.next;
    }


}

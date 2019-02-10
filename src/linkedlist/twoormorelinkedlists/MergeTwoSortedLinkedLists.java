package linkedlist.twoormorelinkedlists;

import linkedlist.Node;

public class MergeTwoSortedLinkedLists {

    /*
     * Leetcode : 21
     *
     * Thought : both the lls are sorted,
     * one has to fit into another {1,5}{2,3,4},
     * {}{1,2,3},{1}{2,3,4},{2,3,4}{5},{1,2}{2,2},{1,1}{1,1}
     * so we have to traverse both until one of them is not null
     * and append the left over
     *
     * Use dummy node
     *
     * */
    public Node mergeSortedLinkedLists(Node ll1, Node ll2) {

        // use dummy node makes life easy
        Node dummy = new Node(-1);
        Node itr = dummy;

        while (ll1 != null && ll2 != null) {

            // find and attach the smallest of the two nodes to itr then move that node pointer forward
            if (ll1.val > ll2.val) {

                itr.next = ll2;
                ll2 = ll2.next;

            } else {

                itr.next = ll1;
                ll1 = ll1.next;
            }

            // new node merged, move itr forward
            itr = itr.next;
        }

        // handle left overs
        if (ll1 != null) itr.next = ll1;
        if (ll2 != null) itr.next = ll2;

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 3, 5, 7, 9};
        int[] num2 = {0, 2, 4, 6, 8, 10};
        Node ll1 = Node.createLL(num1);
        Node ll2 = Node.createLL(num2);

        MergeTwoSortedLinkedLists m2sll = new MergeTwoSortedLinkedLists();
        Node ll = m2sll.mergeSortedLinkedLists(ll1, ll2);
        Node.print("Merged Linked list :", ll);
    }

}

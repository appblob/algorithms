package linkedlist.twoormorelinkedlists;

import linkedlist.Node;

public class MergeTwoSortedLinkedLists {

    public Node mergeSortedLinkedLists(Node ll1, Node ll2) {

        Node dummy = new Node(-1);
        Node itr = dummy;

        while (ll1 != null && ll2 != null) {

            if (ll1.val > ll2.val) {
                itr.next = ll2;
                ll2 = ll2.next;
            } else {
                itr.next = ll1;
                ll1 = ll1.next;
            }

            itr = itr.next;
        }

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
        Node.print("Merged Linked list :",ll);
    }

}

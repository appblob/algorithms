package linkedlist.twoormorelinkedlists;

import linkedlist.Node;

public class MergeKSortedLists {
    /*
     * Leetcode : 23
     *
     * Thought : We should be left with one merged list at the end.
     * Use 2 pointer: end pointing to the index of last list in the array
     * until end > 0 (i.e. there is more than one list left to merge)
     * reset begin to index 0
     * until begin and end cross over merge the contents of lls[end] into lls[begin] and move both closer
     * */


    public Node mergeKLists(Node[] lls) {
        int end = lls.length - 1;

        while (end > 0) {

            // reset begin to index 0
            int begin = 0;

            // until begin and end cross over merge the contents of lls[end] into lls[begin]
            while (begin < end) {

                lls[begin] = merge(lls[begin], lls[end]);

                // move both closer
                begin++;
                end--;
            }
        }

        return lls[0];
    }

    private Node merge(Node ll1, Node ll2) {
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

        //Node.print("After merging : " , dummy.next);
        return dummy.next;
    }

    public static void main(String[] args) {
        int [] nums1 = { 2, 4, 6};
        int [] nums2 = {1, 3};
        int [] nums3 = {7,8};
        int [] nums4 = {5};
        Node[] lls = { Node.createLL(nums1), Node.createLL(nums2), Node.createLL(nums3), Node.createLL(nums4)};

        MergeKSortedLists mksl = new MergeKSortedLists();
        Node merged = mksl.mergeKLists(lls);
        Node.print("Merged sorted list : " , merged);
     }
}

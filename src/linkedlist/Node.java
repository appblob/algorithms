package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Node {
    // making public to reduce getters and setters in algorithm code
    public int val;
    public Node next;

    public Node(int value) {
        val = value;
    }

    // helpers //
    public static Node createLL(int[] nums) {
        Node dummy = new Node(0);
        Node iter = dummy;

        for (int num : nums) {

            iter.next = new Node(num);
            iter = iter.next;
        }

        return dummy.next;
    }

    public static void print(String msg, Node node) {
        StringBuilder sb = new StringBuilder();
        sb.append(msg);
        if(msg.lastIndexOf(" ") != msg.length() - 1)
            sb.append(" ");

        while (node != null) {
            sb.append(node.val);
            if (node.next != null) sb.append("->");
            node = node.next;
        }

        System.out.println(sb.toString());
    }

    public static Node getNode(Node ll, int value) {

        while(ll != null) {

            if(ll.val == value) return ll;

            ll = ll.next;
        }
        return null;
    }

    // assumption this is a well behaving function with valid inputs
    // node values are assumed to be unique
    public static Node createCycle(int[] uniqueNums, int cycleHeadIndex) {
        if(cycleHeadIndex > uniqueNums.length || cycleHeadIndex < 0) cycleHeadIndex = uniqueNums.length / 2;
        Node dummy = new Node(0);
        Node iter = dummy;

        Node cHead = null;
        for (int i = 0; i < uniqueNums.length; i++) {

            iter.next = new Node(uniqueNums[i]);
            iter = iter.next;

            if(cycleHeadIndex == i) cHead = iter;
        }
        if(cHead != null && iter != null) iter.next = cHead;

        return dummy.next;
    }

    public static void printCycle(Node node) {
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();
        while (node != null) {
            if(set.contains(node.val)){
                sb.append("Cycle head here at node " + node.val);
                break;
            } else {
                set.add(node.val);
                sb.append(node.val);
                if (node.next != null) sb.append("->");
                node = node.next;
            }
        }

        System.out.println(sb.toString());
    }

}

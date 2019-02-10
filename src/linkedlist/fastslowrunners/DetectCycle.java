package linkedlist.fastslowrunners;

import linkedlist.Node;

public class DetectCycle {
    /*
     * Leetcode : 141
     *
     * Thought : Use 2 pointers(runners) : Fast and Slow
     * Consider you are running in a circular race track
     * fast runners covers 2 feet on each step and slow covers one feet.
     * The fast runner and slow runner will meet each other multiple times even thought running paces are different.
     *
     * Another example : Analog clock.
     * */
    public boolean hasCycle(Node head) {
        if (head == null || head.next == null) return false;

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node cycle = Node.createCycle(nums, 5);
        Node.printCycle(cycle);

        DetectCycle dc = new DetectCycle();
        System.out.println(dc.hasCycle(cycle) == true ? "Yes there is a cycle." : "No cycle here baby...");

        Node ll = Node.createLL(nums);
        Node.printCycle(ll);
        System.out.println(dc.hasCycle(ll) == true ? "Yes there is a cycle." : "No cycle here baby...");

    }
}

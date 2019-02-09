package linkedlist;

class Node {
    // making public to reduce getters and setters in algorithm code
    public int val;
    public Node next;

    public Node(int value) {
        val = value;
    }

    public static Node insert(int[] nums) {
        Node dummy = new Node(0);
        Node iter = dummy;

        for (int num : nums) {

            iter.next = new Node(num);
            iter = iter.next;
        }

        return dummy.next;
    }

    public static void print(Node node) {
        StringBuilder sb = new StringBuilder();

        while (node != null) {
            sb.append(node.val);
            if (node.next != null) sb.append("->");
            node = node.next;
        }

        System.out.println(sb.toString());
    }
}

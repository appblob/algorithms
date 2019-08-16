package math;

public class SwapTwoNumbers {

    public static void swap(int n1, int n2) { // 5, 6
        n1 = n1 + n2; // 11
        n2 = n1 - n2; // 5
        n1 = n1 - n2; // 6

        System.out.println(n1 + " " + n2);
    }

    public static void swapExOR(int n1, int n2) { // 5, 6
        n1 = n1 ^ n2; // 101 ^ 110 = 011
        n2 = n1 ^ n2; // 011 ^ 110 = 101
        n1 = n1 ^ n2; // 011 ^ 101 = 110

        System.out.println(n1 + " " + n2);
    }
    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 25;

        swap(n1, n2);
        swapExOR(n1, n2);

        n1 = Integer.MAX_VALUE;
        n2 = Integer.MIN_VALUE;

        swapExOR(n1, n2);
        swap(n1, n2);

        n1 = Integer.MAX_VALUE;
        n2 = Integer.MAX_VALUE;
        swapExOR(n1, n2);
        swap(n1, n2);


        n1 = Integer.MIN_VALUE;
        n2 = Integer.MIN_VALUE;
        swapExOR(n1, n2);
        swap(n1, n2);
    }
}

package math;

public class ReverseInteger {

    /*
    * Leetcode : 7
    *
    * */

    public static int reverse(int x) {

        // if it's one digit number nothing to reverse
        if (x >= -9 && x < 10) return x;

        //if number is negative
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = Math.abs(x);
        }

        // use long to store result
        long result = 0;
        while (x != 0) {

            result = (result * 10) + (x % 10);
            x /= 10;
        }

        // check the Integer boundary
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;

        return (int) (negative == true ? (-result) : result);
    }

    public static void main(String[] args) {
        System.out.println("10 reversed " + reverse(10));
        System.out.println("101 reversed " + reverse(101));
        System.out.println("-10 reversed " + reverse(-10));
        System.out.println("-109 reversed " + reverse(-109));
    }
}

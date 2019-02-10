package dynamicprogramming;

public class Fibonnaci {

    // Iterative approach
    public long fib(int n) {
        if (n == 0 || n == 1) return n;

        long n0 = 0, n1 = 1;
        for (int i = 2; i < n + 1; i++) {

            long n1Prev = n1;

            n1 = n0 + n1;
            n0 = n1Prev;
        }

        return n1;
    }

    // Recursion approach
    public long fibRec(int n) {

        // Terminating condition : fib(0) is 0 & fib(1) is 1
        if (n == 0 || n == 1) return n;

        return fibRec(n - 1) + fibRec(n - 2);
    }

    // Bottom Up approach with Memoization
    public long fibBUMemo(int n) {

        // createLL an array to hold 0 to n
        long[] memoization = new long[n + 1];

        memoization[0] = 0;
        memoization[1] = 1;

        for (int i = 2; i < memoization.length; i++) {

            // fib(n) = fib(n - 1) + fib(n - 2)
            memoization[i] = memoization[i - 1] + memoization[i - 2];
        }

        return memoization[n];
    }

    // Top Down approach with Memoization
    public long fibTDMemo(int n) {

        // createLL an array to hold 0 to n
        long[] memoization = new long[n + 1];

        return fibTDHelper(n, memoization);
    }

    private long fibTDHelper(int n, long[] m) {

        // Terminating condition : fib(0) is 0 & fib(1) is 1
        if (n == 0 || n == 1) return n;

        // m[n] is computed only once when m[n] is 0. Avoids overlapping subproblems
        if (m[n] == 0) {

            m[n] = fibTDHelper(n - 1, m) + fibTDHelper(n - 2, m);
        }

        return m[n];
    }

    public static void main(String[] args) {
        Fibonnaci f = new Fibonnaci();
        System.out.println(f.fib(50));
        System.out.println(f.fibRec(25));
        System.out.println(f.fibBUMemo(50));
        System.out.println(f.fibTDMemo(50));
    }
}

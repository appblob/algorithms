package arrays2d;

public class SearchSorted2DMatrix {
    /*
     * Leetcode : 74
     *
     * Search a value in an m x n matrix.
     * Integers in each row are sortedarrays from left to right.
     * First integer of each row is greater than the last integer of the previous row.
     *
     * THOUGHT : Start from topRight = m[0][m[0].len - 1]
     * while target > m[r][c], search row below.
     * while target < m[r][c], search in the same row.
     * */

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int num = 30;
        int num2 = 15;
        SearchSorted2DMatrix ssdm = new SearchSorted2DMatrix();
        System.out.println("Found  " + num + " : " + ssdm.search(matrix, num));
        System.out.println("Found  " + num2 + " : " + ssdm.search(matrix, num2));

        System.out.println("Found  " + num + " : " + ssdm.binarySearch(matrix, num));
        System.out.println("Found  " + num2 + " : " + ssdm.binarySearch(matrix, num2));

    }

    private boolean isWithin(int[][] matrix, int r, int c) {

        return (r < matrix.length && c >= 0);
    }

    public boolean search(int[][] matrix, int target) {
        boolean found = false;
        if (matrix == null || matrix.length == 0) return found;

        int top = 0, right = matrix[0].length - 1;
        while (top < matrix.length && right >= 0) {

            if (matrix[top][right] == target) return true;

            while (isWithin(matrix, top, right) && matrix[top][right] > target) right--;
            while (isWithin(matrix, top, right) && matrix[top][right] < target) top++;

        }

        return found;
    }

    /*
    THOUGHT : Treat 2D array like a 1D array and do binary search on it.
    left = 0; right = m * n - 1;
    mid = (left & right) + ((left ^ right) >> 1)
    row = mid / cols; col = mid % cols
    */
    public boolean binarySearch(int[][] matrix, int target) {
        boolean found = false;

        if (matrix == null || matrix.length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = (rows * cols) - 1;

        while (left <= right) {

            int mid = (left & right) + ((left ^ right) >> 1);

            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target)
                return true;

                // middle no is bigger than target => No lies to the left in 1D
            else if (matrix[row][col] > target)
                right = mid - 1;

                // middle no is less than target => No lies to the right in 1D
            else
                left = mid + 1;
        }

        return found;
    }
}

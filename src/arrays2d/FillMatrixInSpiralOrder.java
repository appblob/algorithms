package arrays2d;

import java.util.Arrays;

public class FillMatrixInSpiralOrder {
    public static void main(String[] args) {
        FillMatrixInSpiralOrder fmiso = new FillMatrixInSpiralOrder();
        int[][] matrix = fmiso.generateMatrix(4);

        System.out.println(Arrays.deepToString(matrix));
    }

    /*
    Leetcode : 59

    Thought : Input n should result in a n x n dimensional matrix.
    The numbers should range from 1 to n^2 in spiral order.

    There are 2 ways to view at a matrix
    Horizontally - Left to Right
    Vertically - Top to Bottom

    Fill n while Top <= Bottom && Left <= Right in the direction below, increment n each time
    Top (Left -> Right)
    Right (Top -> Bottom)
    Bottom (Right -> Left)
    Left (Bottom -> Top)
    */
    public int[][] generateMatrix(int n) {

        if (n == 0) return new int[0][0];

        int[][] matrix = new int[n][n];

        int Top = 0;
        int Bottom = matrix.length - 1;
        int Left = 0;
        int Right = matrix[0].length - 1;
        int num = 1;

        while (Top <= Bottom && Left <= Right) {

            for (int i = Left; i <= Right; i++) {
                matrix[Top][i] = num++;
            }
            Top++;

            for (int i = Top; i <= Bottom; i++) {
                matrix[i][Right] = num++;
            }
            Right--;

            for (int i = Right; i >= Left; i--) {
                matrix[Bottom][i] = num++;
            }
            Bottom--;

            for (int i = Bottom; i >= Top; i--) {
                matrix[i][Left] = num++;
            }
            Left++;
        }

        return matrix;
    }
}

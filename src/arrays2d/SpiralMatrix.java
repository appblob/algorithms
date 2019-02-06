package arrays2d;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        SpiralMatrix sm = new SpiralMatrix();
        System.out.println(sm.sprialOrder(matrix));
    }

    /*

    Leetcode : 54

    THOUGHT : There are 2 ways to view at a matrix
    Horizontally - Left to Right
    Vertically - Top to Bottom

    Iterate through the matrix in the following 4 directions
    while Top <= Bottom && Left <= Right to return all items spirally

    0 : Top (Left -> Right)
    1 : Right (Top -> Bottom)
    2 : Bottom (Right -> Left)
    3 : Left (Bottom -> Top)
    */
    public List<Integer> sprialOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new ArrayList<>();

        int Top = 0, Left = 0;
        int Bottom = matrix.length - 1, Right = matrix[0].length - 1;

        int direction = 0;

        List<Integer> result = new ArrayList<>(Right * Bottom);

        while (Top <= Bottom && Left <= Right) {

            // Top (Left -> Right)
            if (direction == 0) {
                for (int i = Left; i <= Right; i++) {
                    result.add(matrix[Top][i]);
                }

                Top++;

            }
            // Right (Top -> Bottom)
            else if (direction == 1) {
                for (int i = Top; i <= Bottom; i++) {
                    result.add(matrix[i][Right]);
                }

                Right--;

            }
            // Bottom (Right -> Left)
            else if (direction == 2) {
                for (int i = Right; i >= Left; i--) {
                    result.add(matrix[Bottom][i]);
                }

                Bottom--;

            }
            // Left (Bottom -> Top)
            else if (direction == 3) {
                for (int i = Bottom; i >= Top; i--) {
                    result.add(matrix[i][Left]);
                }

                Left++;
            }

            direction = (direction + 1) % 4;
        }

        return result;
    }
}

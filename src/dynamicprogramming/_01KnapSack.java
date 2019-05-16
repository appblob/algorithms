package dynamicprogramming;

import dynamicprogramming.helper.Matrix;

public class _01KnapSack {

    public static int maxValue(int maxWt, int[] weights, int[] values) {

        int itemLength = values.length + 1;

        // Additional row represents 0 value item
        // Additional column represents column with 0 weight
        int[][] maxValueAtCurrentWt = new int[itemLength][maxWt + 1];

        Matrix.print(maxValueAtCurrentWt);

        // for each item find the maximum value you can accumulate for a unit of incremental weight (0 to maxWt)
        for (int itemIndex = 1; itemIndex < itemLength; itemIndex++) {

            for (int currentAvailableWt = 1; currentAvailableWt < (maxWt + 1); currentAvailableWt++) {

                // when currentAvailableWt can hold the weight of the item
                if (currentAvailableWt >= weights[itemIndex - 1]) {

                    maxValueAtCurrentWt[itemIndex][currentAvailableWt] =
                            Math.max(
                                maxValueAtCurrentWt[itemIndex - 1][currentAvailableWt],
                                values[itemIndex - 1] + maxValueAtCurrentWt[itemIndex - 1][currentAvailableWt - weights[itemIndex - 1]]
                    );

                } else { // item weight is more than currentAvailableWt

                    maxValueAtCurrentWt[itemIndex][currentAvailableWt] = maxValueAtCurrentWt[itemIndex - 1][currentAvailableWt];
                }

                //Matrix.print(maxValueAtCurrentWt);
            }
        }

        Matrix.print(maxValueAtCurrentWt);
        return maxValueAtCurrentWt[values.length][maxWt];
    }


    public static void main(String[] args) {
        
        int[][] weights = {{1, 3, 5, 6}, {2, 3, 7, 9, 12}};
        int[][] values  = {{1, 4, 5, 7}, {4, 7, 3, 6, 8}};
        final int totalWt = 10;//15;

        for(int i = 0; i < weights.length; i++) {
            System.out.println("Maximum value of items that can be held in a KnapSack of " + totalWt + " is " + maxValue(totalWt, weights[i], values[i]));
        }
    }
}

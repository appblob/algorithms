package dynamicprogramming;

public class _01KnapSack {

    public static int maxValue(int totalWt, int[] weights, int[] values) {

        int[][] maxValues = new int[values.length + 1][totalWt + 1];

        // when wt is 0 or i is 0, maxValues[i] wt is 0
        for (int i = 1; i < values.length + 1; i++) {

            for (int wt = 1; wt < totalWt + 1; wt++) {

                if (wt - weights[i - 1] >= 0) {

                    maxValues[i][wt] = Math.max(
                            maxValues[i - 1][wt],
                            values[i - 1] + maxValues[i - 1][wt - weights[i - 1]]
                    );

                } else {

                    maxValues[i][wt] = maxValues[i - 1][wt];
                }
            }
        }

        return maxValues[values.length][totalWt];
    }

    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};//{2,3,7,9,12};
        int[] values = {1, 4, 5, 7};//{4,7,3,6,8};
        final int totalWt = 7;//15;

        System.out.println(maxValue(totalWt, weights, values));
    }
}

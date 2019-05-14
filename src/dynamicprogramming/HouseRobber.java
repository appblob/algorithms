package dynamicprogramming;

import java.util.Arrays;

public class HouseRobber {
    /*
    * Leetcode : 198
    *
    * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.
    * Numbers can be 0 or negative.
    *
    * Technique : At each point you decide if you want to include or exclude the current number.
    * Iterate the array at each point find the max sum by including the num[i] and excluding it.
    *
    * We only need the previous 2 sums.
    * */

    public static int rob(int[] nums) {

        int inclusive = 0; // currentMaxSum
        int exclusive = 0; // previousMaxSum

        for(int num : nums) {

            int temp = inclusive;

            inclusive = Math.max(inclusive, exclusive + num);

            exclusive = temp;
        }

        return inclusive;
    }

    /*
    Thought : At each step dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);

    This is same as the previous one, but with additional memory
    */
    public static int rob2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int len = nums.length;
        if(len == 1) return nums[0];

        // dp
        int [] monies = new int[len];

        // populate the first 2 with max thus far.
        monies[0] = nums[0];
        monies[1] = Math.max(nums[1], monies[0]);

        for(int i = 2; i < len; i++) {

            monies[i] = Math.max(nums[i] + monies[i - 2], monies[i - 1]);
        }

        return monies[len - 1];
    }

    public static void main(String[] args) {

        int[] monies = {1,2,3,1};
        int[]monies2 = {2,7,9,3,1};

        int maxAmount = rob(monies);
        System.out.println("The largest sum of non-adjacent numbers " + Arrays.toString(monies) + " is " + maxAmount);

        maxAmount = rob2(monies);
        System.out.println("The largest sum of non-adjacent numbers " + Arrays.toString(monies) + " is " + maxAmount);

        maxAmount = rob(monies2);
        System.out.println("The largest sum of non-adjacent numbers " + Arrays.toString(monies2) + " is " + maxAmount);

        maxAmount = rob(monies2);
        System.out.println("The largest sum of non-adjacent numbers " + Arrays.toString(monies2) + " is " + maxAmount);
    }


}

package arrays.subarray;

public class MaximumSumSubArray {

    /*
    * Technique: At index i, we know the maximum sum at i - 1. We can use it to compute sum at i
    * MaxSum[i] = Math.max(0, MaxSum[i - 1] + a[i])
    *
    * Thinks to know:
    * Continuous sum.
    * Contains positive and negative numbers.
    * */

    public static int maximumSumV0(int[] nums){
        int len = nums.length;
        int[] maxSums = new int[len];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < len; i++) {
            if(i == 0) {
                maxSums[i] = nums[0];
                continue;
            }

            maxSums[i] = Math.max(0, maxSums[i - 1] + nums[i]);

            max = Math.max(max, maxSums[i]);
        }

        return max;
    }

    // O(1) space

    public static int maximumSum(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            sum = Math.max(0, sum + nums[i]);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2, -1, 5, -4, 0, -2, 4};

        System.out.println("Maximum sum : " + maximumSumV0(nums));

        System.out.println("Maximum sum : " + maximumSum(nums));
    }
}

package arrays;

import java.util.Arrays;

public class ProductExceptSelf {

    /*
    Thought :
    nums = {2, 3, 4, 5}
    forward = {1, 2, 6, 24}, for(i -> 1 to (n - 1)) forward[i] = forward[i - 1] * nums[i - 1];
    backward = {60, 20, 5, 1}, for(i -> (n - 2) to 0) backward[i] = backward[i + 1] * nums[i + 1];
    Output = {60, 40, 30, 24}, for(i -> 0 to (n - 1)) forward[idx] = forward[idx] * backward[idx];*/
    public static int[] productExceptSelf(int[] nums) {

        int[] forward = new int[nums.length];
        int[] backward = new int[nums.length];

        forward[0] = 1;
        backward[nums.length - 1] = 1;

        for (int i = 1; i < forward.length; i++)
            forward[i] = forward[i - 1] * nums[i - 1];

        for(int i = backward.length - 2; i >= 0; i--)
            backward[i] = backward[i + 1] * nums[i + 1];

        for(int i = 0; i < forward.length; i++)
            forward[i] = forward[i] * backward[i];

        return forward;
    }


    /*
    Iterate and find the product. Note if zero was found and if zeros were found.
    */
    public static int[] productExceptSelfV1(int[] nums) {
        long product = 1;
        boolean foundZero = false;
        boolean foundMultipleZeros = false;
        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == 0) {

                foundMultipleZeros = foundZero == true;

                foundZero = true;

            } else product *= nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            // if only one zero is found: I/P [1,2,3,4,0] O/P:[0,0,0,0,24]
            // more than one zeros I/P [1,2,0,3,4,0] O/P:[0,0,0,0,0,0]
            if(foundZero == true) {

                nums[i] = (nums[i] != 0 || foundMultipleZeros == true) ? 0 : (int) product;

            } else {

                nums[i] = (int) product / nums[i];
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println("The product except self for : " + Arrays.toString(arr) + " is " + Arrays.toString(productExceptSelf(arr)));
        System.out.println("The product except self for : " + Arrays.toString(arr) + " is " + Arrays.toString(productExceptSelfV1(arr)));

        int[] arr2 = {1, 2, 3, 4, 0};
        System.out.println("The product except self for : " + Arrays.toString(arr2) + " is " + Arrays.toString(productExceptSelf(arr2)));
        System.out.println("The product except self for : " + Arrays.toString(arr2) + " is " + Arrays.toString(productExceptSelfV1(arr2)));

        int[] arr3 = {1, 0, 2, 3, 4, 0};
        System.out.println("The product except self for : " + Arrays.toString(arr3) + " is " + Arrays.toString(productExceptSelf(arr3)));
        System.out.println("The product except self for : " + Arrays.toString(arr3) + " is " + Arrays.toString(productExceptSelfV1(arr3)));
    }
}

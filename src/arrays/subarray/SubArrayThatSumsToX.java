package arrays.subarray;

import java.util.Arrays;
import java.util.List;

public class SubArrayThatSumsToX {
    /*
     * Array of positive numbers. sum of continuous numbers
     *
     * Technique : 2 Pointers technique. Windowing.
     * Since array contains only positive numbers, we can define a window and add it's contents and compare with X
     * Start both left and right pointers at 0
     * Note that the sum increases if we move right pointer and decreases if we move left pointer to right
     *
     * */

    public static List<Integer> contiguousSum(int[] arr, int X) {
        int left = 0, right = 0;

        int sum = 0;

        // explore all elements
        while (left < arr.length) {

            if (sum == X) {

                return Arrays.asList(left, (right != 0) ? right - 1 : 0);

            } else if (sum > X) {

                sum -= arr[left];
                left++;

            } else {

                // make sure right does not cross the boundary
                if (right < arr.length) {

                    sum += arr[right];
                    right++;

                } else break;
            }
        }

        return Arrays.asList(-1, -1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 50};
        System.out.println(contiguousSum(arr, 50));
        System.out.println(contiguousSum(arr, 1));
        System.out.println(contiguousSum(arr, 65));
        System.out.println(contiguousSum(arr, 18));
        System.out.println(contiguousSum(arr, 5));
    }
}

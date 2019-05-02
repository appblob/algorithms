package arrays;

import java.util.ArrayList;
import java.util.List;

public class LongestContiguousSubsequence {

    public static int lcis(int [] nums) {

        int count  = 0;
        int maxCount  = 1;

        int start = 0, maxStart = 0;
        int end = 0;

        for(int i = 1; i < nums.length; i++) {

            if(nums[i - 1] < nums[i]) {

                count++;

                if(count > maxCount) {

                    // set maxCount, maxStart and end
                    maxCount = count;
                    maxStart = start;
                    end = i;
                }

            } else {

                // reset count to 0 and start to i
                start = i;
                count = 0;

            }
        }

        List<Integer> lcs = new ArrayList<>();
        for (int i = maxStart; i <= end; i++) {

            lcs.add(nums[i]);
        }

        System.out.println("The longest contiguous increasing sub-sequence is : " + lcs);

        return maxCount;
    }

    public static void main(String[] args) {

        int[] arr = { 23, 10, 22, 5, 33, 8, 9, 21, 50, 41, 60, 80, 99, 22, 23, 24, 25, 26, 27};

        System.out.println("Length of longest contiguous increasing sub-sequence is : " + lcis(arr));

        int[] arr2 = { 5, 4, 3, 2, 1};
        System.out.println("Length of longest contiguous increasing sub-sequence is : " + lcis(arr2));


    }

}

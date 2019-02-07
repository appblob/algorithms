package arrays.two_pointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        ThreeSum ts = new ThreeSum();

        List<List<Integer>> result = ts.threeSum(arr);

        System.out.println(result);
    }

    /*
    Leetcode : 15

    problem : Array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0
    Find all unique triplets in the array which gives the sum of zero.

    Technique : sort & 2 pointers

    Thought:
    Sort the array.
    Iterate through the array.
    for every a[i] use 2 pointer technique iterate from l = i + 1 and h = a.len - 1 to find a[i] + a[l] + a[h] = 0
    */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new LinkedList<>();

        if (nums == null || nums.length < 3) return results;

        int len = nums.length;

        // sort
        Arrays.sort(nums);

        // iterate through the array
        for (int i = 0; i < len - 2; i++) {

            // use 2 pointers
            int l = i + 1;
            int h = len - 1;

            int sum = 0 - nums[i];

            while (l < h) {
                if (sum == nums[l] + nums[h]) {

                    results.add(Arrays.asList(nums[i], nums[l], nums[h]));

                    //remove duplicates
                    while (l < h && nums[l] == nums[l + 1]) l++;
                    while (l < h && nums[h] == nums[h - 1]) h--;

                    h--;
                    l++;
                } else if (sum < nums[l] + nums[h]) {
                    h--;
                } else l++;

            }

            // remove duplicates
            while (i < len - 2 && nums[i] == nums[i + 1]) i = i + 1;
        }

        return results;
    }
}

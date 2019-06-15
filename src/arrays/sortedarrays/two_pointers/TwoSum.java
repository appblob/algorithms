package arrays.sortedarrays.two_pointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
     * Leetcode : 1
     *
     *  Problem : Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may not use the same element twice.
     *
     * Technique : Map lookup.
     *
     * Thought : Create a map to store number and it's index.
     * Iterate the array.
     * Search if (target - nums[i]) is in the map.
     * Otherwise put <nums[i], i> into the map.
     *
     * Time Complexity : O(n)
     *
     * */
    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length < 2) return null;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};

            map.put(nums[i], i);

        }

        return new int[2];
    }

    /*
    Method 2 :

    Technique : Sort and 2 pointers.

    Algorithm :
    Make a copy of input array.
    Sort the copy array. Use 2 pointers start and end.
    When target - sum(copy[start], copy[end]) > 0, start++
    When target - sum(copy[start], copy[end]) < 0, end--

    Search copy[start] and copy[end] in nums.

    Time Complexity : O(N Log N)

    */
    public int[] twoSumV0(int[] nums, int target) {
        int[] result = {0, 0};

        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int begin = 0;
        int end = copy.length - 1;
        int firstNum = -1, secondNum = -1;

        while (end > begin) {

            while ((copy[begin] + copy[end] < target) && (end > begin)) {
                begin++;
            }
            while ((copy[begin] + copy[end] > target) && (end > begin)) {
                end--;
            }

            if (copy[begin] + copy[end] == target) {
                firstNum = copy[begin];
                secondNum = copy[end];
                break;
            }
        }

        // target was found if end > begin
        if (end > begin) {

            result = findIndex(nums, firstNum, secondNum);
        }

        return result;
    }

    private int[] findIndex(int[] nums, int firstNum, int secondNum) {
        int[] result = {0, 0};

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == firstNum) result[0] = i;
        }

        // search from back, avoids duplicates or {2,2}, 4
        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] == secondNum) result[1] = i;
        }

        return result;
    }

    /*
    Method 3 :

    Technique : Sort and binary search.

    Algorithm :
    Make a copy of input array.
    Sort the copy array.
    Iterate the array
    binary search (target - copy[i]) from i + 1

    Search copy[i] and copy[index] in nums.

    Time Complexity : O(N Log N)

    */
    public int[] twoSumV1(int[] nums, int target) {
        int[] result = {0, 0};

        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int firstNum = Integer.MAX_VALUE, secondNum = Integer.MAX_VALUE;
        for (int i = 0; i < copy.length; i++) {

            int index = Arrays.binarySearch(copy,i + 1, copy.length, target - copy[i]);
            if(index != -1) {
                firstNum = copy[i];
                secondNum = copy[index];
                break;
            }
        }

        if(firstNum != Integer.MAX_VALUE) {

            result = findIndex(nums, firstNum, secondNum);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 11, 7, 15};
        TwoSum ts = new TwoSum();

        int[] result = ts.twoSum(nums, 9);
        System.out.println(Arrays.toString(result));

        result = ts.twoSumV0(nums, 9);
        System.out.println(Arrays.toString(result));

        result = ts.twoSumV1(nums, 9);
        System.out.println(Arrays.toString(result));

        result = ts.twoSum(nums, 18);
        System.out.println(Arrays.toString(result));

        result = ts.twoSum(nums, 1);
        System.out.println(Arrays.toString(result));

        result = ts.twoSum(null, 0);
        System.out.println(Arrays.toString(result));
    }
}

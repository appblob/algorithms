package arrays.sorted.binarysearch;

public class SearchInRotatedSortedArray {
    /*
     * Leetcode : 33
     *
     * Problem : Array is sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * Assume there are no duplicates.
     * If target is found return its index, otherwise return -1.
     *
     * Technique : Binary Search
     *
     * Thought : Since array is sorted and then rotated left half or right half of mid (binary search) is sorted
     *
     * Algorithm :
     * Set l to 0 and r to nums.length
     * Repeat while l != r
     *   Compute m = l + r / 2 and check if nums[m] == target, if so return m
     *   If left half is sorted see if target lies between nums[l] and nums[m] and set r = m else set l = m + 1
     *   If right half is sorted see if target lies between nums[m] and nums[r] and set l = m + 1 else set r = m
     *
     * Time Complexity : O(log n)
     * */

    public static void main(String[] args) {

        int[] nums = {7, 8, 1, 2, 3, 4, 5};
        SearchInRotatedSortedArray sirsa = new SearchInRotatedSortedArray();
        System.out.println("Index of 7 : " + sirsa.search(nums, 7));
        System.out.println("Index of 4 : " + sirsa.search(nums, 4));
        System.out.println("Index of 5 : " + sirsa.search(nums, 5));
        System.out.println("Index of 6 : " + sirsa.search(nums, 6));
        System.out.println("Index of 1 : " + sirsa.search(nums, 1));
        System.out.println("Index of 8 : " + sirsa.search(nums, 8));
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;

        while (l != r) {

            int m = l + (r - l) / 2;

            if (nums[m] == target)
                return m;

            // if left half is sorted
            if (nums[l] <= nums[m]) {
                // check if target lies on the left half
                if (nums[l] <= target && target < nums[m]) r = m;
                else l = m + 1;

            } else {

                // check if target lies on the right half
                if (nums[m] < target && target <= nums[r - 1]) l = m + 1;
                else r = m;

            }
        }

        return -1;
    }
}

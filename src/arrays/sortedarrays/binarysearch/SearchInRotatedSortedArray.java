package arrays.sortedarrays.binarysearch;

public class SearchInRotatedSortedArray {
    /*
     * Leetcode : 33
     *
     * Problem : Array is sortedarrays in ascending order is rotated at some pivot unknown to you beforehand.
     * Assume there are no duplicates.
     * If target is found return its index, otherwise return -1.
     *
     * Technique : Binary Search
     *
     * Thought : Since array is sortedarrays and then rotated left half or right half of mid (binary search) is sortedarrays
     *
     * Algorithm :
     * Set l to 0 and r to nums.length
     * Repeat while l != r
     *   Compute m = l + r / 2 and check if nums[m] == target, if so return m
     *   If left half is sortedarrays see if target lies between nums[l] and nums[m] and set r = m else set l = m + 1
     *   If right half is sortedarrays see if target lies between nums[m] and nums[r] and set l = m + 1 else set r = m
     *
     * Time Complexity : O(log n)
     * */

    public static void main(String[] args) {

        int[] nums = {7, 8, 1, 2, 3, 4, 5};
        SearchInRotatedSortedArray sirsa = new SearchInRotatedSortedArray();
        System.out.println("Index of 7 : " + search(nums, 7));
        System.out.println("Index of 4 : " + search(nums, 4));
        System.out.println("Index of 5 : " + search(nums, 5));
        System.out.println("Index of 6 : " + search(nums, 6));
        System.out.println("Index of 1 : " + search(nums, 1));
        System.out.println("Index of 8 : " + search(nums, 8));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;

            if(nums[mid] < nums[right]) {//[7 8 3 5 6]
                if(target > nums[mid] && target <= nums[right]) left = mid + 1; //[7 8 3 5 6], 5
                else right = mid - 1; //[7 8 3 5 6], 8

            } else if(nums[mid] > nums[right]) {//[6 7 8 3 5]

                if(target < nums[mid] && target >= nums[left]) right = mid - 1; //[6 7 8 3 5], 7
                else left = mid + 1; //[6 7 8 3 5], 3

            }
            else right--; // nums[mid] = nums[right] [1 2 3 3 3]

        }
        return -1;
    }

}

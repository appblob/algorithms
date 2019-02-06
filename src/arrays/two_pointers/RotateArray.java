package arrays.two_pointers;

/*
 * Leetcode 189.
 *
 * Techniques : Range and 2 Pointers.
 *
 * Thought :
 * k = k % len - 1
 * Rotate the whole array (0 to len - 1)
 * Rotate 0 to k - 1
 * Rotate from k to len - 1
 *
 * Rotate Method : use 2 pointers pointing either ends of the array, swap and move closer.
 * */

import java.util.Arrays;

public class RotateArray {

    void rotateArray(int[] nums, int k) {

        if (nums == null || nums.length <= 1 || k == 0 || (k %= nums.length) == 0) return;

        k %= nums.length;

        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }

    private void rotate(int[] nums, int start, int end) {

        while (start < end) {

            int t = nums[start];
            nums[start++] = nums[end];
            nums[end--] = t;
        }
    }

    public static void main(String[] args) {

        RotateArray ra = new RotateArray();
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        ra.rotateArray(nums1, 2);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        ra.rotateArray(nums2, 8);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
        ra.rotateArray(nums3, 0);
        System.out.println(Arrays.toString(nums3));

        int[] nums4 = {1, 2, 3, 4, 5, 6, 7};
        ra.rotateArray(nums4, nums4.length - 1);
        System.out.println(Arrays.toString(nums4));

        int[] nums5 = {1};
        ra.rotateArray(nums5, 0);
        System.out.println(Arrays.toString(nums5));

        int[] nums6 = null;
        ra.rotateArray(nums6, 5);
        System.out.println(Arrays.toString(nums6));


    }

}

package arrays;

import java.util.TreeSet;

public class ContainsDuplicates3 {
    /*
    * Leetcode 220
    *
    * Given an array of integers, find out whether there are two distinct indices i and j in the array such
    * that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference
    * between i and j is at most k.
    *
    *
    * */


    /*
    Technique : Use a TreeSet iterate and add items to it.
    prun and keep only k items. Find ceiling and floor.
    */
    public static boolean containsNearbyAlmostDuplicateTreeSet(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k < 1 || t < 0) return false;

        TreeSet<Long> window = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {

            long num = (long) nums[i];

            Long ceiling = window.ceiling(num - t);
            Long floor = window.floor(num + t);

            if((ceiling != null  && ceiling <= num)
                    || (floor != null && floor >= num)) return true;

            window.add(num);

            // remove from tree items farther than (i - k)
            if(i >= k) window.remove((long)nums[i - k]);
        }

        return false;
    }

    /*
    Technique : Windowing : For every i, run j from i+1 to i+k
    */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (k == 0 || k == 10000) return false;

        for (int i = 0; i < nums.length - 1; i++) {

            // run j from i+1 to i+k
            for(int j = (i + 1); j <= (i + k) && j < nums.length; j++) {

                long difference = Math.abs((long)nums[i] - nums[j]);

                if (difference <= t) return true;

            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {1,0,1,1};
        int[] nums3 = {1,5,9,1,5,9};

        int t = 0, k = 3;
        System.out.println(nums1 + "contains nearby almost duplicate " + t + " within " + k + " is :" + containsNearbyAlmostDuplicate(nums1, k, t));
        System.out.println(nums1 + "contains nearby almost duplicate " + t + " within " + k + " is :" + containsNearbyAlmostDuplicateTreeSet(nums1, k, t));

        k = 1; t = 2;
        System.out.println(nums2 + "contains nearby almost duplicate " + t + " within " + k + " is :" + containsNearbyAlmostDuplicate(nums2, k, t));
        System.out.println(nums1 + "contains nearby almost duplicate " + t + " within " + k + " is :" + containsNearbyAlmostDuplicateTreeSet(nums2, k, t));

        k = 2; t = 3;
        System.out.println(nums3 + "contains nearby almost duplicate " + t + " within " + k + " is :" + containsNearbyAlmostDuplicate(nums3, k, t));
        System.out.println(nums1 + "contains nearby almost duplicate " + t + " within " + k + " is :" + containsNearbyAlmostDuplicateTreeSet(nums3, k, t));

    }
}

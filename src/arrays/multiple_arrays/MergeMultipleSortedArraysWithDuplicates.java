package arrays.multiple_arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeMultipleSortedArraysWithDuplicates {

    /*
    * There are 2 sorted arrays that might contain duplicates.
    * Write a function that creates merged sorted array without duplicates.
    *
    * Company : Tabuleau
    *
    * Technique : Pointers Technique, one pointer for each array.
    *
    * */
    public static int[] merge(int[] ar1, int[] ar2) {

        if(ar1 == null || ar1.length == 0) return ar2;
        if(ar2 == null || ar2.length == 0) return ar1;

        int p1 = 0, p2 = 0;

        List<Integer> result = new LinkedList<>();
        while(p1 < ar1.length && p2 < ar2.length) {

            // skip the duplicates in both arrays
            while((p1 + 1) < ar1.length && ar1[p1] == ar1[p1 + 1]) p1++;
            while((p2 + 1) < ar2.length && ar2[p2] == ar2[p2 + 1]) p2++;

            if(ar1[p1] < ar2[p2]) {

                result.add(ar1[p1]);
                p1++;

            } else if(ar1[p1] > ar2[p2]) {

                result.add(ar2[p2]);
                p2++;

            } else {

                // when ar2[p2] == ar1[p1] increment both pointers that way you skip duplicates.
                result.add(ar2[p2]);
                p2++;
                p1++;
            }

        }

        // handle left over array. Add non-duplicate integers.
        if(p1 < ar1.length) addUniques(ar1, p1, result);
        if(p2 < ar2.length) addUniques(ar2, p2, result);

        return result.stream().mapToInt(i -> i).toArray();
    }

    private static void addUniques(int[] ar, int p, List<Integer> result) {

        int writeIndex = p;
        while(p < ar.length) {

            // skip duplicates.
            while(p + 1 < ar.length && ar[p] == ar[p + 1]) p++;

            result.add(ar[writeIndex]);

            // assign the new writeIndex after incrementing.
            writeIndex = ++p;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,2,4};
        int[] arr2 = {3,4,4,5,6,6,7};

        int[] result = merge(arr1, arr2);

        System.out.println(Arrays.toString(result));

    }
}

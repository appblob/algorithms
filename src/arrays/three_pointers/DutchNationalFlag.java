package arrays.three_pointers;

import java.util.Arrays;

/*
Technique:
* The array can be divided int 4 regions <X | =X | NotExplored | >X
* less will point to the last replaced <X
* equals will point to the last index =X
* big will point to the first index > x
* */
public class DutchNationalFlag {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void compute(int[] arr, int pivot) {
        int equal = -1;
        int less = 0, big = arr.length - 1;

        while (equal < big) {

            if(arr[equal + 1] < pivot) {

                swap(arr, equal + 1, less);
                equal++;
                less++;

            } else if(arr[equal + 1] == pivot) {

                equal++;

            } else {

                swap(arr, equal + 1, big);
                big--;
                // you don't increment equal because it can be greater than or less than pivot
            }

        }
    }

    public static void main(String[] args) {

        int[] arr = {9, 3, 5, 1, 4, 8, 0, 7, 2, 6, 7, 3, 3};

        compute(arr, 6);

        System.out.println(Arrays.toString(arr));
    }
}



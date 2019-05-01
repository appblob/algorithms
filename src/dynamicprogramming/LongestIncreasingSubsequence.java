package dynamicprogramming;

import java.util.LinkedList;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static int lis(int[] arr) {
        int [] increasingCounter = new int[arr.length];
        int [] numOrdering = new int[arr.length];

        // initially the LIS at each index is 1 and the order is index
        for(int i = 0; i < arr.length; i++) {

            increasingCounter[i] = 1;
            numOrdering[i] = i;
        }

        for(int i = 1; i < arr.length; i++) {

            for (int j = 0; j < i; j++) {

                if(arr[i] > arr[j]) {

                    if(increasingCounter[j] + 1 > increasingCounter[i]) {

                        increasingCounter[i] = increasingCounter[j] + 1;
                        numOrdering[i] = j;
                    }
                }
            }
        }

        // find the index that has the maximum value (LIS)
        int idxOfMaxCount = 0;
        for (int i = 0; i < increasingCounter.length; i++) {

            idxOfMaxCount = (increasingCounter[idxOfMaxCount] < increasingCounter[i]) ? i : idxOfMaxCount;
        }

        /*
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(increasingCounter));
        System.out.println(Arrays.toString(numOrdering));
        System.out.println(idxOfMaxCount);
         */

        // the find the LIS
        List<Integer> lisList = new LinkedList<>();
        int currentIndex = idxOfMaxCount;
        int nextIndex = idxOfMaxCount;

        do {

            currentIndex = nextIndex;

            lisList.add(0, arr[currentIndex]);

            nextIndex = numOrdering[currentIndex];

        } while (currentIndex != nextIndex);

        System.out.println("The longest increasing sub-sequence is : " + lisList);

        return increasingCounter[idxOfMaxCount];
    }

    public static void main(String[] args) {

        int[] arr = {23, 10, 22, 5, 33, 8, 9, 21, 50, 41, 60, 80, 99, 22, 23, 24, 25, 26, 27};

        System.out.println("Length of longest increasing sub-sequence is : " + lis(arr));
    }
}

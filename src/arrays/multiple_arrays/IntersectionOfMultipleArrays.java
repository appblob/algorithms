package arrays.multiple_arrays;

import java.util.*;


public class IntersectionOfMultipleArrays {

    /*
    * There are array of arrays of integers. Write a function that returns an array containing common numbers in all the arrays.
    *
    * Technique : Use set to store the common numbers.
    *
    * Companies : Microsoft.
    * */

    public static int[] intersection(List<int[]> lstOfArrays) {

        if(lstOfArrays == null || lstOfArrays.size() == 0) return new int[] {};

        //Set<Integer> common = new HashSet<>();
        Map<Integer, Integer> common = new HashMap<>();
        // find the list with least number of items or just select 0th array.
        // selecting 0th array
        int[] arr = lstOfArrays.get(0);

        // add all it's items to a set named common
        for(int i = 0; i < arr.length; i++) {
            //common.add(arr[i]);
            common.put(arr[i], common.getOrDefault(arr[i], 0) + 1);
        }


        // iterate through the list.
        // While iterating through the array find if it's in common set and add it to intersection set
        // make intersection set as common set at the end.
        for(int i = 1; i < lstOfArrays.size(); i++) {

            Map<Integer, Integer> intersection = new HashMap<>();

            int [] array = lstOfArrays.get(i);

            for(int j = 0; j < array.length; j++) {

                if(common.containsKey(array[j])) {

                    intersection.put(array[j], intersection.getOrDefault(array[j], 0) + 1);

                    int occuranceCount = common.get(array[j]);
                    if(occuranceCount == 1) common.remove(array[j]);
                    else common.put(array[j], occuranceCount- 1);
                }
            }

            common.clear();
            common = intersection;
        }

        return createArrayFromMap(common);
    }

    private static int[] createArrayFromMap(Map<Integer, Integer> map) {
        List<Integer> result = new LinkedList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for(int i = 0; i < entry.getValue(); i++) {
                result.add(entry.getKey());
            }
        }

        return result.stream().mapToInt(i -> i).sorted().toArray();
    }

    public static void main(String[] args) {
        List<int[]> lstOfArrays = new ArrayList<>();
        lstOfArrays.add(new int[] {10, 20, 30, 40, 30, 50});
        lstOfArrays.add(new int[] {20, 30, 40, 50, 30, 60});
        lstOfArrays.add(new int[] {30, 40, 50, 60, 30, 70});

        int[] result = intersection(lstOfArrays);
        System.out.println(Arrays.toString(result));
    }
}

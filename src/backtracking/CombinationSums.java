package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSums {
    /*
    * Leetcode : 39
    * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
    * find all unique combinations in candidates where the candidate numbers sums to target.
    *
    * The same repeated number may be chosen from candidates unlimited number of times.
     * */

    private static List<List<Integer>> computeSum(int[] candidates, int targetNum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output =  new ArrayList<>();

        backtrack(candidates, 0, targetNum, output, result);

        return result;
    }

    private static void backtrack(int[] candidates, int index, int targetNum, List<Integer> output,
                                  List<List<Integer>> result) {

        if(targetNum == 0) {
            result.add(new ArrayList<>(output));
            //return;
        }

        if(targetNum < 0) return;


        for(int i = index; i < candidates.length; i++) {

            // you want to avoid [3,2,2] [2,3,2] but not [2,2,3]
            // also like to avoid adding number that exceeds remaining target // (target - candidates[i]) >= 0
            if((output.size() == 0 || candidates[i] >= output.get(output.size() - 1))
                    && (targetNum - candidates[i] >= 0)) {

                output.add(candidates[i]);

                // candidates[i] can repeat, so index is not incremented
                backtrack(candidates, index, targetNum - candidates[i], output, result);

                output.remove(output.size() - 1);

            }
        }

    }


    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int num = 7;
        List<List<Integer>> result = computeSum(candidates, num);
        System.out.println(result);
    }

}

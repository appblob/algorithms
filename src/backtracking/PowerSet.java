package backtracking;

import java.util.ArrayList;
import java.util.List;

// A power set is all the subsets of a set
public class PowerSet {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;

        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    /*
    * This is a classic backtracking problem.
    * For every current i, loop from i + 1 to len and so on
    *
    * See the output statements for a better idea.
    * */
    private void backtrack(int[] nums, int idx, List<Integer> current, List<List<Integer>> result) {

        // Capture every possible state from empty array
        result.add(new ArrayList<>(current));


        for (int i = idx; i < nums.length; i++) {

            current.add(nums[i]);

            // System.out.println("Loop from " + idx + " to " + len + ". Current i : " + i + ". Backtracking from " + (i + 1) + " Content : " + current.toString());
            backtrack(nums, i + 1, current, result);

            // System.out.println("Loop from " + idx + " to " + len + ". Current i : " + i + ". Content : " + current.toString());
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        PowerSet ps = new PowerSet();
        int[] nums = {0, 1, 2};
        List<List<Integer>> lst = ps.subsets(nums);
        System.out.println(lst.toString());
    }
}

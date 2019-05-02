package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static List<List<Integer>> computeQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();

        helper(n, columns, result);

        return result;
    }

    private static boolean isValid(List<Integer> columns) {

        int lastColIndex = columns.size() - 1;

        for (int i = 0; i < lastColIndex; i++) {

            int diff = Math.abs(columns.get(i) - columns.get(lastColIndex));

            if(diff == 0 || (lastColIndex - i) == diff)
                return false;

        }

        return true;

    }
    private static void helper(int n, List<Integer> columns, List<List<Integer>> result) {

        if(n == columns.size()) result.add(new ArrayList<>(columns));

        for(int col = 0; col < n; col++) {

            columns.add(col);

            if(isValid(columns))
                helper(n, columns, result);

            columns.remove(columns.size() - 1);

        }
    }

    public static void main(String[] args) {

        List<List<Integer>> result = computeQueens(4);

        System.out.println(result);
    }
}

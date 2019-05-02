package arrays;

import java.util.Arrays;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] result = new int[intervals.length + 1][2];

        int i = 0;
        int r = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            result[r][0] = intervals[i][0];
            result[r][1] = intervals[i][1];

            i++;
            r++;
        }

        while(i < intervals.length && newInterval[1] >= intervals[i][0]) {

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        result[r][0] = newInterval[0];
        result[r][1] = newInterval[1];
        r++;


        while(i < intervals.length) {
            result[r][0] = intervals[i][0];
            result[r][1] = intervals[i][1];

            i++;
            r++;
        }

        int[][] temp = new int[r] [2];
        for(i = 0; i < temp.length; i++) {

            temp[i][0] = result[i][0];
            temp[i][1] = result[i][1];
        }

        return temp;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        int[][] result = insert(intervals, newInterval);

        System.out.println(Arrays.deepToString(result));
    }
}

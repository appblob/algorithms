package strings;

import java.util.HashMap;
import java.util.Map;

public class RobotReturnToOrigin {
    /*
     * Leetcode : 657
     *
     * Robot is at (0,0).
     * It performs a series of moves on a 2D plane.
     * L = left, R = right, U = up, D = down
     * Does it end up at origin at the end of the moves.
     *
     * Input : String moves
     *
     * Thought : For robot to be at the place it started, for every forward move there should be an equivalent backward move.
     * Which means the count(left) - count(right) == 0 and count(up) == count(down)
     * */



    /*
     * Iterate the string
     * Vertical move : Up increment, Down decrement
     * Horizontal move : left decrement, right increment
     *
     * if both vertical and horizontal counters are zeros => at origin
     * */
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) return true;

        int v = 0, h = 0;

        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'L':
                    v--;
                    break;
                case 'R':
                    v++;
                    break;
                case 'U':
                    h++;
                    break;
                case 'D':
                    h--;
                    break;
            }
        }
        return (h == 0 && v == 0);
    }

    /*
     * Using array as counter. You can use map instead.
     * count(left) - count(right) == 0 and count(up) == count(down) => returns to origin
     * */
    public boolean judgeCircle2(String moves) {
        if (moves == null || moves.length() == 0) return true;

        int[] counter = new int[128];

        for (char move : moves.toCharArray()) {
            counter[move]++;
        }

        return (counter['L'] == counter['R'] && counter['U'] == counter['D']);
    }

    public boolean judgeCircle3(String moves) {
        if (moves == null || moves.length() == 0) return true;

        Map<Character, Integer> counter = new HashMap<>();

        for (char move : moves.toCharArray()) {
            counter.put(move, counter.getOrDefault(move, 0) + 1);
        }

        return (counter.get('L') == counter.get('R') && counter.get('U') == counter.get('D'));
    }

    public static void main(String[] args) {

        RobotReturnToOrigin rrto = new RobotReturnToOrigin();

        String[] moves = {"LRUD", "LL"};

        for (int i = 0; i < moves.length; i++) {

            System.out.println("With " + moves[i] + " , can reach origin : " + rrto.judgeCircle(moves[i]));
            System.out.println("With " + moves[i] + " , can reach origin : " + rrto.judgeCircle2(moves[i]));
            System.out.println("With " + moves[i] + " , can reach origin : " + rrto.judgeCircle3(moves[i]));

        }
    }

}

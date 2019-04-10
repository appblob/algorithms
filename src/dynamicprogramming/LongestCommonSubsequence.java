package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {

    public static int lengthOflcs(char[] s1, char[] s2) {
        int maxLen = 0;

        int[][] length = new int[s1.length + 1][s2.length + 1];

        for (int s1Idx = 1; s1Idx < s1.length + 1; s1Idx++) {

            for (int s2Idx = 1; s2Idx < s2.length + 1; s2Idx++) {

                // when the characters in either string are same, add one to the last length of lcs found diagonally
                if (s1[s1Idx - 1] == s2[s2Idx - 1]) length[s1Idx][s2Idx] = length[s1Idx - 1][s2Idx - 1] + 1;

                // find max of left and top
                else length[s1Idx][s2Idx] = Math.max(length[s1Idx - 1][s2Idx], length[s1Idx][s2Idx - 1]);


                maxLen = Math.max(maxLen, length[s1Idx][s2Idx]);
            }
        }

        return maxLen;
    }

    public static int lcs(char[] s1, char[] s2, int l1, int l2, Map<String, Integer> cache) {

        if (l1 == s1.length || l2 == s2.length) return 0;

        if (cache.containsKey(l1 + " " + l2))
            return cache.get(l1 + " " + l2);

        if (s1[l1] == s2[l2])
            return 1 + lcs(s1, s2, l1 + 1, l2 + 1, cache);

        else {
            int first = lcs(s1, s2, l1 + 1, l2, cache);
            cache.put((l1 + 1) + " " + l2, first);

            int second = lcs(s1, s2, l1, l2 + 1, cache);
            cache.put(l1 + " " + (l2 + 1), second);

            return Math.max(first, second);
        }

    }

    public static void main(String[] args) {
        char[] chars1 = {'a', 'a', 'b', 'c', 'k', 'l'};
        char[] chars2 = {'b', 'c', 'j', 'l'};
        System.out.println(lengthOflcs(chars1, chars2));

        Map<String, Integer> cache = new HashMap<>();
        System.out.println(lcs(chars1, chars2, 0, 0, cache));
    }
}

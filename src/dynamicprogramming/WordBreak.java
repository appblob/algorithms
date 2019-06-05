package dynamicprogramming;

import java.util.List;

public class WordBreak {
    /*
    * Leetcode : 139
    *
    * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
    * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
    * */

    public static boolean wordBreak(String s, List<String> dictionary) {
        int len = s.length();
        boolean [] breakFound = new boolean[len];
        breakFound[0] = true;

        for (int i = 0; i < s.length(); i++) {

            if(breakFound[i] == false) continue;

            for (String word:dictionary) {

                int endIndex = i + word.length();
                
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}

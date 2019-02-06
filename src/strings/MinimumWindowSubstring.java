package strings;

public class MinimumWindowSubstring {

    /*

    Leetcode : 76

    Technique : Map(hash table), 2 pointers

    Thought:
    Use map(hash table) to count number of occurrences of target.
    The counter to count number of characters to find.
    Use 2 pointers(windowing) to find and to resize the range.

    counter is intially the size of the target string size. It is decremented each time a character of t is found in s.
    When counter is 0, all characters have been found.
    Time to find actual start of the range that is between begin and end
    */
    public String minWindow(String s, String t) {
        char [] ss = s.toCharArray();
        char [] tt = t.toCharArray();

        int [] map = new int[128];
        int counter = tt.length;

        // count the number of occurrences of chars in target
        for(char tChar : tt) map[tChar]++;

        // begin and end : sliding window range where t can be found.
        int begin = 0, end = 0;

        int startOfMinRange = 0, minLen = Integer.MAX_VALUE;
        while(end < ss.length) {

            if(map[ss[end++]]-- > 0) counter--;
            /*
            // if character from target
            if(map[ss[end]] > 0) counter--;

            map[ss[end]]--;
            end++;
            */

            // all chars of target are between begin and end.
            while(counter == 0) {

                if((end - begin) < minLen) {
                    //startOfMinRange = begin;
                    minLen = end - (startOfMinRange = begin);
                }

                // one char of target found, so we can search new window again.
                if(map[ss[begin++]]++ == 0) counter++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(startOfMinRange, startOfMinRange + minLen);
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC", T = "ABC";

        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        System.out.println(mws.minWindow(S, T));
    }
}

package strings;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
    Leetcode : 3

    Thought : iterate through the string
    distance between last unique characters = i - index at which last time s[i] was found.

    */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;

        // current index of character
        int[] index = new int[128];
        Arrays.fill(index, -1);


        // try to extend the range [i, j]
        int lastFoundIndex = -1;
        for (int i = 0; i < n; i++) {

            lastFoundIndex = Math.max(index[s.charAt(i)], lastFoundIndex);

            // one based, handles " " also don't have to do Arrays.fill(index, -1)
            index[s.charAt(i)] = i;

            // distance between last unique characters = i - index at which last time s[i] was found.
            ans = Math.max(ans, i - lastFoundIndex);
        }

        return ans;
    }
}

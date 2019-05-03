package strings;

public class OneEditDistance {

    /*
   Leetcode : 161

   THOUGHT : Only one edit(Insert/Update/Delete) is allowed.

   The length of two strings can vary by 1 character.
   Iterate through the array, if characters vary there are 3 cases based on length.
   1) When both have same length, characters from (i + 1) should be same
   2) When t has larger length, skip current character from t and see if remaining characters are same.
   3) When s has larger length, skip current character from s and see if remaining characters are same.
   */
    public static boolean isOneEditDistance(String s, String t) {
        int slen = s.length(), tlen = t.length();

        if(Math.abs(slen-tlen) > 1) return false;

        int minLen = Math.min(slen, tlen);

        // iterate the length
        for(int i = 0; i < minLen; i++) {

            // when characters are not the same, ie found first non-matching character.
            if(s.charAt(i) != t.charAt(i)) {

                // when both have same length, characters from (i + 1) should be same
                if(slen == tlen) return s.substring(i + 1).equals(t.substring(i + 1));//aba aca

                    // t is larger, skip character from t and see if remaining characters are same.
                else if(slen < tlen) return s.substring(i).equals(t.substring(i + 1));//aba acba

                    // s is larger, skip character from s and see if remaining characters are same.
                else return s.substring(i + 1).equals(t.substring(i)); //aabc abc
            }
        }

        //aba abaD -> true
        //abc abc -> false
        return (Math.abs(slen - tlen) == 1);
    }

    public static void main(String[] args) {

        String s = "aabc";
        String t = "abc";

        System.out.println(s + " and " + t + (isOneEditDistance(s, t) == true ? " are at one edit distance." : " are not at one edit distance"));

        s = "abc";
        t = "abc";
        System.out.println(s + " and " + t + (isOneEditDistance(s, t) == true ? " are at one edit distance." : " are not at one edit distance"));

        s = "abc";
        t = "aac";
        System.out.println(s + " and " + t + (isOneEditDistance(s, t) == true ? " are at one edit distance." : " are not at one edit distance"));

    }
}

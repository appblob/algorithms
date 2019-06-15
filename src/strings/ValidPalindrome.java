package strings;

public class ValidPalindrome {
    /*
    * Check if a sentence is palindrome. The sentence may contain Letters(upper & lower), digits and other characters
    *
    * Leetcode : 125. Valid Palindrome
    *
    * Technique : Two pointers :

    * Details :
    Use pointers start = 0 and end = (len - 1)
    While they don't cross:
    Skip non-letters or non-digits pointed by start and end. Otherwise chars should match.
    Move both closer.
    * */


    // using java in-built functions

    public static boolean isPalindrome(String s) {
        boolean ret = true;
        if(s == null || s.length() < 2) return ret;

        int start = 0, end = s.length() -1;

        // convert the word into lower case.
        char[] chars = s.toLowerCase().toCharArray();

        while (start < end) {

            // skip non-letter and non-digit character.
            while (start < end && !Character.isLetterOrDigit(chars[start])) start++;
            while (start < end && !Character.isLetterOrDigit(chars[end])) end--;

            // characters should match.
            if(chars[start] != chars[end]) return false;

            start++;
            end--;
        }

        return true;
    }

    // explicit validation
    public static boolean isPalindromeV1(String s) {

        if(s == null || s.length() < 2) return true;

        int start = 0;
        int end = s.length() - 1;

        char[] c = s.toCharArray();

        while((end - start) >= 1) {

            //if both start and end char are alphaNumeric and not equal return false
            int startChar = c[start];
            int endChar = c[end];

            if(!validateChar(startChar)) { start++; continue;}

            if(!validateChar(endChar)) { end--; continue;}

            if(toLowerCase(startChar) != toLowerCase(endChar)) return false;

            else { start++; end--;}
        }

        return true;
    }


    /*
    Ranges :
    0 to 9  : 48 to 57
    a to z  : 65 to 90
    A to Z  : 97 to 122
    */
    public static boolean validateChar(int c) {

        return (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    public static int toLowerCase(int c) {
        if(c >= 97 && c <= 122) return (c - 32);
        return c;
    }

    /*
    * Checks if a lower case word is a palindrome.
    * */
    public static boolean isWordPalindrome(String s) {
        int len = s.length();

        for(int i = 0; i < len / 2; i++)
            if(s.charAt(i) != s.charAt((len - 1) - i)) return false;

        return true;
    }


    public static void main(String[] args) {
        String sentence = "A man, a plan, a canal: Panama";

        System.out.println(sentence + " is palindrome : " + isPalindrome(sentence));
        System.out.println(sentence + " is palindrome : " + isPalindromeV1(sentence));

        String word = "malayalam";
        System.out.println(word + " is palindrome : " + isWordPalindrome(word));
    }

}

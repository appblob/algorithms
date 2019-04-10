package strings;

public class LongestPalindromeInAString {
    /*
    Leetcode : 5

    THOUGHT : Use 3 pointers. current, left and right.

    while (c < len), We try to find a palindrome at every current index by doing the following :
    set l and r to c (say 1 in "abbba")
    move r forward until s[r] == s[r + 1]
    compare char[l - 1] with char[r + 1] and move l and r away by one step each
    */


    public static void main(String[] args) {
        LongestPalindromeInAString lpias = new LongestPalindromeInAString();
        System.out.println(lpias.longestPalindrome1("seabbbab"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        int left, right, current = 0;

        int maxPLen = 0, pStart = 0;

        char[] chs = s.toCharArray();
        while (current <= len - (maxPLen / 2)) {

            //set both left and right to new index from where we explore palindrome
            left = right = current;

            //skip forward when character repeats
            while (right < len - 1 && chs[right] == chs[right + 1]) right++;

            //store the next start position
            current = right + 1;

            //the palindrome will be between left and right
            while (left > 0 && right < len - 1 && chs[left - 1] == chs[right + 1]) {
                left--;
                right++;
            }

            // compute the length of newly found palindrome
            int pLen = right - left + 1;

            if (pLen > maxPLen) {
                maxPLen = pLen;
                pStart = left;
            }
        }

        return s.substring(pStart, pStart + maxPLen);
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() <= 1) return s;
        int len = s.length();

        int left, right, current = 0;

        int start = 0, maxLen = 0;

        while (current < len - (maxLen / 2)) {

            left = right = current;

            while (right + 1 < len && s.charAt(right) == s.charAt(right + 1)) right++;

            current = right + 1;

            while (left > 0 && right + 1 < len && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }

            int slen = right - left + 1;

            if (slen > maxLen) {
                maxLen = slen;
                start = left;
            }
        }

        return s.substring(start, start + maxLen);
    }
}

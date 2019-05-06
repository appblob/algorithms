package strings;

import java.util.LinkedList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();

        int left = 0;

        while(left < words.length) {

            int right = findRight(words, left, maxWidth);
            result.add(justify(left, right,words, maxWidth));

            left = right + 1;
        }

        return result;
    }

    // Find how many words can fit in a line of maxWidth.
    private int findRight(String[] words, int left, int maxWidth) {

        final int lengthOfBlankSpace = 1;
        int right = left;

        int sumOfCharacters = words[right++].length();

        while (right < words.length && (sumOfCharacters + lengthOfBlankSpace + words[right].length()) <= maxWidth) {

            sumOfCharacters += lengthOfBlankSpace + words[right++].length();
        }

        return right - 1;

    }

    private String generateNWhitespaces(int n) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }

    private String padRight(String s, int maxWidth) {

        StringBuilder sb = new StringBuilder(s);

        int remainingLength = maxWidth - s.length();
        sb.append(generateNWhitespaces(remainingLength));

        return sb.toString();
    }

    private String justify(int left, int right, String[] words, int maxWidth) {

        // if 1 word can fill the line
        if(left == right) return padRight(words[left], maxWidth);

        int sumOfCharacters = 0;
        for (int i = left; i <= right ; i++) sumOfCharacters += words[i].length();

        int numOfWhitespaces = maxWidth - sumOfCharacters;

        int numOfWords = right - left;

        boolean isLastLine  = (right == words.length - 1);

        int numOfSpacesBetween = (isLastLine) ? 1 : (numOfWhitespaces / numOfWords);

        //spaces remaining after integer division 8 % 5 = 3
        int remainingSpaces  = (isLastLine) ? 0 : (numOfWhitespaces % numOfWords);

        StringBuilder result = new StringBuilder();
        for(int i = left; i < right; i++) {

            result.append(words[i])
                    .append(generateNWhitespaces(numOfSpacesBetween))
                    .append(remainingSpaces-- > 0 ? " " : "");
        }

        // append the last word
        result.append(words[right]);

        return (isLastLine) ? padRight(result.toString(), maxWidth) : result.toString();
    }


    private void print(List<String> lines) {

        for(int i = 0; i < lines.size(); i++) System.out.println(lines.get(i));
        System.out.println();
    }
    public static void main(String[] args) {

        String [] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String [] words1 = {"What","must","be","acknowledgment","shall","be"};
        String [] words2 = {"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do."};

        TextJustification tj = new TextJustification();
        List<String> lines = tj.fullJustify(words, 13);
        tj.print(lines);

        lines = tj.fullJustify(words1, 16);
        tj.print(lines);

        lines = tj.fullJustify(words2, 16);
        tj.print(lines);
    }

}

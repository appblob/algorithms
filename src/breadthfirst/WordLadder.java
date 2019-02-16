package breadthfirst;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        String startWord = "hit";
        String endWord = "cog";

        WordLadder wl = new WordLadder();
        System.out.println(wl.ladderLength(startWord, endWord, new HashSet<>(Arrays.asList(wordList))));


        System.out.println(wl.ladderLengthSimpleBFS(startWord, endWord, new HashSet<>(Arrays.asList(wordList))));
    }

    //2 ended BFS
    private int biDiBFS(Set<String> startSet, Set<String> endSet, Set<String> wordList, int ladderLen) {

        if (startSet.size() == 0) return 0;

        // holds all possible words originating from startSet that are in wordList
        Set<String> wordsOfStart = new HashSet<>();

        for (String s : startSet) {

            // replace each character of the string with 'a' to 'z' and find if it's either in endSet or wordList
            // and add to a new set wordsOfStart which contains works that can be formed from startSet that are in wordList
            char[] sChars = s.toCharArray();
            for (int i = 0; i < sChars.length; i++) {

                char orig = sChars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {

                    sChars[i] = ch;
                    String newStr = new String(sChars);

                    if (endSet.contains(newStr)) return ladderLen;

                    // newStr is in wordList, it is one of the possible words
                    // that can be formed from words in startSet
                    if (wordList.contains(newStr)) {

                        wordsOfStart.add(newStr);
                        wordList.remove(newStr);
                    }
                }
                // restore the original character
                sChars[i] = orig;
            }
        }

        // use the smallest of wordsOfStart and endSet as startSet
        if (wordsOfStart.size() < endSet.size()) {

            return biDiBFS(wordsOfStart, endSet, wordList, ladderLen + 1);

        } else {

            return biDiBFS(endSet, wordsOfStart, wordList, ladderLen + 1);
        }
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {

        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        startSet.add(beginWord);
        endSet.add(endWord);

        wordList.remove(beginWord);
        wordList.remove(endWord);

        //length is already 2, we have beginWord and endWord
        return biDiBFS(startSet, endSet, wordList, 2);
    }

    public int ladderLengthSimpleBFS(String beginWord, String endWord, Set<String> wordList) {

        // add the beginWord to queue and set the level to 1 also add endWord to wordList
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;

        wordList.add(endWord);

        while (!queue.isEmpty()) {
            // at each level fetch the each word and replace each of it's character with characters 'a' to 'z'
            int size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {

                String s = queue.poll();
                char[] chars = s.toCharArray();

                for (int j = 0; j < chars.length; j++) {

                    // At each position, copy the character and replace it with 'a' to 'z'
                    // and find if it's either in wordList or the endWord
                    char c = chars[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        chars[j] = ch;
                        String temp = new String(chars);


                        if (endWord.equals(temp))
                            return level;

                        // if the new temp word is in wordList add it to queue and remove for wordList
                        if (wordList.contains(temp)) {

                            queue.add(temp);
                            wordList.remove(temp);
                        }
                    }

                    // restore the original character
                    chars[j] = c;
                }
            }
        }

        return 0;
    }
}

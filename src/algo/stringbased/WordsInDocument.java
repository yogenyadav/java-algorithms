package algo.stringbased;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find all the valid words which make up the entire string
 * Dictionary with words is given with isValid method
 *
 * Example
 * s = "helloworld"
 * dict = {"he", "hello", "world"}
 *
 * return [hello, world] as this finds all the valid words and they make up entire string.
 *
 * do not return [he] or [he, world] as this is not set of words that make up entire string.
 *
 * Return
 * if words found then Words in string separated by space.
 * if words not found then null
 */
public class WordsInDocument {
    static String findWords(String doc) {
        return findWordsHelper(doc, 0, 0);
    }

    static String findWordsHelper(String doc, int st, int end) {
        // base case
        if (end >= doc.length()) {
            if (isValid(doc.substring(st, end))) {
                // reached end of doc and last word is valid
                return doc.substring(st);
            } else {
                // last word is not valid
                return null;
            }
        }

        // if substring is a valid word then there are 2 possibilities:
        if (isValid(doc.substring(st, end))) {
            // 1. if this word is considered then this and rest of words in the document
            //    will make up whole document i.e. there will be no null words
            String s1 = doc.substring(st, end) + " " + findWordsHelper(doc, end, end+1); // considered therefore start looking after this word
            if (!s1.contains("null")) { // checks if any word is null
                return s1;
            } else {
                // 2. if this word is not considered then this and rest of words in the document
                //    will make up whole document i.e. there will be no null words
                String s2 = findWordsHelper(doc, st, end + 1);
                if (s2 != null && !s2.contains("null")) {
                    return s2;
                }
            }
            return null;
        } else {
            // substring is not a valid word
            return findWordsHelper(doc, st, end+1);
        }
    }

    static Set<String> dict = new HashSet<String>() {
        {
            this.add("he");
            this.add("world");
            this.add("hello");
            this.add("no");
            this.add("nomad");
        }
    };

    static boolean isValid(String str) {
        return dict.contains(str);
    }

    public static void main(String[] args) {
        System.out.println(findWords("helloheworldnomad"));
        System.out.println(findWords("helloheworldnormal"));
    }
}

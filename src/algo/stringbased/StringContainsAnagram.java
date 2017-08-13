package algo.stringbased;

/**
 * How to check if a string contains an anagram of another string?
 *
 * Anagram: An anagram is a type of word play, the result of rearranging the letters of a word or phrase
 * to produce a new word or phrase, using all the original letters exactly once.
 * For example, string “logain” is an anagram of “gainlo”.
 *
 * Algorithm:
 * Sliding window technique.
 *
 * Find if String A contains anagram of String B
 * 1. In a hash map store frequency of each letter in B.
 * 2. Start with 2 index pointers into A. index1 = 0, index2 = len(B) - 1.
 * 3. For every step of sliding window, subtract the char frequency in hash map from the substring.
 * 4. Once the hash map gets zero for all keys, the current sliding window has the anagram substring.
 *
 */
public class StringContainsAnagram {
}

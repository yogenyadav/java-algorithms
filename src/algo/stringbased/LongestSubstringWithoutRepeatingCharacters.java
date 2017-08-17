package algo.stringbased;

/**
 * Given a string, find the longest substring without repeating characters.
 *
 * Algorithm:
 * 1. Keep two pointers (start, end) that denotes the current substring we’re checking and both has an
 * initial value of 0.
 * 2. Each time, move forward end pointer by 1 character and use the hash set to check if the newly added character
 * has already existed.
 * 2.1 If not, keep moving end pointer forward.
 * 2.2 If the new character is a duplicate one, move the start pointer all the way to pass the duplicate
 * character and pop out all these characters from the hash set.
 * 2.2.1 Keep a longestString variable, at this step check if current substring is longer than longestString, save
 *       it if it is.
 * 3. Repeating step 2 and output the longest substring without dup after finishing the whole string.
 *
 * http://blog.gainlo.co/index.php/2016/10/07/facebook-interview-longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

}

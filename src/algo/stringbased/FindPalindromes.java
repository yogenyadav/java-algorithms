package algo.stringbased;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Palindrome: a word, phrase, or sequence that reads the same backward as forward, e.g., madam or nurses run.
 */
public class FindPalindromes {

    public static Set<CharSequence> findPalindromes(String input) {
        if (input.length() <= 2) {
            return Collections.emptySet();
        }
        Set<CharSequence> out = new HashSet<CharSequence>();
        int length = input.length();
        for (int i = 1; i <= length; i++) {
            for (int j = i - 1, k = i; j >= 0 && k < length; j--, k++) {
                if (input.charAt(j) == input.charAt(k)) {
                    out.add(input.subSequence(j, k + 1));
                } else {
                    break;
                }
            }
        }
        return out;
    }

    /**
     * The left side of a palindrome is a mirror image of its right side.
     *
     */
    public static boolean isPalindromeIterativeMethod(String str) {
        int len = str.length();
        for(int i=0; i<len/2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeRecurssiveMethod(String str) {
        if (str.length() <= 1) {
            return true;
        } else if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        } else {
            return isPalindromeRecurssiveMethod(str.substring(1, (str.length() - 1)));
        }
    }

    public static boolean isPalindromeUsingQueueAndStack(String str) {
        // can also be implemented using a queue and a stack
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeIterativeMethod("madam"));
        System.out.println(isPalindromeIterativeMethod("nursesrun"));
        System.out.println(isPalindromeIterativeMethod("abba"));
        //
        System.out.println(isPalindromeRecurssiveMethod("madam"));
        System.out.println(isPalindromeRecurssiveMethod("nursesrun"));
        System.out.println(isPalindromeRecurssiveMethod("abba"));
    }
}

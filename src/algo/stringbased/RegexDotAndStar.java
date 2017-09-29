package algo.stringbased;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * '.' is treated as a single a character wildcard
 * '*' is matched for a zero or more sequence of the previous letter
 * For simplicity, assume that the actual symbols '.' and '*' do not appear in the text string and are used as special
 * symbols only in the pattern string.
 */
public class RegexDotAndStar {

    public static boolean isMatch(String text, String pattern) {
        if (text == null || pattern == null) {
            return false;
        }
        return isMatchHelper(text.toCharArray(), pattern.toCharArray(), 0, 0);
    }

    /**
     *
     * @param text array
     * @param pattern array
     * @param t text index
     * @param p pattern index
     * @return true if match
     */
    private static boolean isMatchHelper(char[] text, char[] pattern, int t, int p) {
        Arrays.sort(new int[5]);
        // base conditions
        if (t >= text.length) {
            if (p >= pattern.length) {
                // 1. if text ended and pattern ended
                return true;
            } else {
                // 2. if text ended and pattern has not
                // cases can be
                // text = abcd
                // patterns:
                // abcd* - match
                // abcd** - match
                // abcd. - no match
                // abcd.. - no match
                // abcde - no match
                if (p+1 < pattern.length && pattern[p+1] == '*') {
                    return isMatchHelper(text, pattern, t, p+1);
                } else {
                    if (pattern[p] == '*') {
                        return true;
                    }
                    return false;
                }
            }
        } else if (p >= pattern.length) {
            // 3. pattern has ended, text has not
            return false;
        } else {
            // both text and pattern not ended yet...cases:
            // 1. curr chars match and next char in pattern = '*', 2 cases:
            // 1.1 zero occurrences of current char i.e. text[t+1] matches pattern[p+2]
            // 1.2 one or more occurrences of current char i.e. text[t+1] matches pattern[p]
            if (p+1 < pattern.length && pattern[p+1] == '*') {
                if (t+1 < text.length && (text[t] == pattern[p] || pattern[p] == '.')) {
                    return isMatchHelper(text, pattern, t+1, p+2)
                            || isMatchHelper(text, pattern, t+1, p);
                }
            } else if (text[t] == pattern[p]) {
                // 2. text and pattern chars match at curr index, move on to next chars in text and pattern
                return isMatchHelper(text, pattern, t+1, p+1);
            } else if (pattern[p] == '.') {
                // 3. pattern has '.' at curr index, move on to next chars in text and pattern
                return isMatchHelper(text, pattern, t+1, p+1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        assertEquals(true, isMatch("", ""));
        assertEquals(false, isMatch("aa", "a"));
        assertEquals(true, isMatch("bb", "bb"));
        assertEquals(true, isMatch("", "a*"));
        assertEquals(false, isMatch("abbdbb", "ab*d"));
        assertEquals(true, isMatch("aba", "a.a"));
        assertEquals(false, isMatch("acd", "ab*c"));
//        assertEquals(true, isMatch("abaa", "a.*a*"));
    }
}

package algo.stringbased;

public class Regex {

    /**
     * pattern: "dog*"
     * return true
     *
     * pattern: "*dog"
     * return false
     *
     * '*' - any one char
     *
     */
    private static boolean anyMatch1(char[] word, char[] regex, int w, int p) {
        if (w == word.length || p == regex.length) {
            return true;
        }

        if (word[w] == regex[p] || regex[p] == '*') {
            return anyMatch1(word, regex, ++w, ++p);
        } else {
            return false;
        }
    }

    /**
     * dogs
     * dog
     * pattern: "dog?"
     * return true
     *
     * dog
     * adog
     * pattern: "?dog"
     * return true
     *
     * '?' - 0 or any 1 char
     *
     */
    private static boolean anyMatch2(char[] word, char[] regex, int w, int p) {
        // base case
        if (w == word.length || p == regex.length) {
            return true;
        }

        // chars match so move on to next char in both
        if (word[w] == regex[p]) {
            return anyMatch2(word, regex, ++w, ++p);
        }

        if (regex[p] == '?') {
            if (word.length - w == regex.length - p) {
                // p = ab?cd, t = abzcd - should be a match as z is any one char
                // p is at ? and w is at z, so if length of remaining pattern and text is same
                // it means there is one char at ? location in text
                // so ++w and ++p
                return anyMatch2(word, regex, ++w, ++p);
            } else if (regex.length - p > word.length - w) {
                // p = ab?cd, t = abcd - should be a match, as there is no char after b
                // remaining text is shorter than remaining pattern it means
                // there are zero chars at ? location, therefore rest of the chars in pattern
                // should match the text
                return anyMatch2(word, regex, w, ++p);
            }
        }
        //falls here if p = ab?cd, t = abzzzcd
        return false;
    }

    public static void main(String[] args) {
        System.out.println(anyMatch1("dogs".toCharArray(), "dog*".toCharArray(), 0, 0));
        System.out.println(anyMatch1("dogs".toCharArray(), "do**".toCharArray(), 0, 0));
        System.out.println(anyMatch1("dogs".toCharArray(), "*dogs".toCharArray(), 0, 0));

        System.out.println(anyMatch2("dogs".toCharArray(), "dog?".toCharArray(), 0, 0));
        System.out.println(anyMatch2("dog".toCharArray(), "dog?".toCharArray(), 0, 0));
        System.out.println(anyMatch2("dogs".toCharArray(), "do??".toCharArray(), 0, 0));

        System.out.println(anyMatch2("dogs".toCharArray(), "?ogs".toCharArray(), 0, 0));
        System.out.println(anyMatch2("dog".toCharArray(), "?dog".toCharArray(), 0, 0));
        System.out.println(anyMatch2("dog".toCharArray(), "?dog?".toCharArray(), 0, 0));
        System.out.println(anyMatch2("dogs".toCharArray(), "??gs".toCharArray(), 0, 0));
        System.out.println(anyMatch2("dog".toCharArray(), "??gs".toCharArray(), 0, 0));
    }
}

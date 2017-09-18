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
        if (w == word.length || p == regex.length) {
            return true;
        }

        if (word[w] == regex[p]) {
            return anyMatch2(word, regex, ++w, ++p);
        }

        if (regex[p] == '?') {
            if (word.length - w == regex.length - p) {
                return anyMatch2(word, regex, ++w, ++p);
            } else if (regex.length - p > word.length - w) {
                return anyMatch2(word, regex, w, ++p);
            }
        }
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

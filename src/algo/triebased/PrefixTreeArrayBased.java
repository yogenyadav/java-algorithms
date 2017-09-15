package algo.triebased;

import com.google.common.base.Stopwatch;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * https://medium.com/algorithms/trie-prefix-tree-algorithm-ee7ab3fe3413
 * Prefix Tree or Trie
 *
 * Array based impl is 23 times faster to build tree and 14 times faster to find word
 * compared to map based impl.
 *
 * Trie time complexity - O(W*L)
 *
 */
public class PrefixTreeArrayBased {

    static final int BASE = 'a';

    Node[] root = new Node[26];

    public void addWord(String word) {
        Node n = root[word.charAt(0) - BASE];
        if (n == null) {
            n = new Node(word.charAt(0));
            root[word.charAt(0) - BASE] = n;
        }
        addWord(word, 1, n);
    }

    public boolean isWord(String word) {
        if (root[word.charAt(0) - BASE] == null) {
            return false;
        }

        return isWord(word, 1, root[word.charAt(0) - BASE]);
    }

    public boolean isPrefix(String prefix) {
        if (root[prefix.charAt(0) - BASE] == null) {
            return false;
        }

        return isPrefix(prefix, 1, root[prefix.charAt(0) - BASE]);
    }

    private boolean isPrefix(String prefix, int idx, Node n) {
        if (idx == prefix.length()) {
            return true;
        }

        if (n.nodes[prefix.charAt(idx) - BASE] != null
                && n.nodes[prefix.charAt(idx) - BASE].c == prefix.charAt(idx)) {
            return isPrefix(prefix, idx + 1, n.nodes[prefix.charAt(idx) - BASE]);
        }

        return false;
    }

    private boolean isWord(String word, int idx, Node n) {
        if (idx == word.length() && n.isWord) {
            return true;
        }

        if (idx == word.length()) {
            return false;
        }

        if (n.nodes[word.charAt(idx) - BASE] != null
                && n.nodes[word.charAt(idx) - BASE].c == word.charAt(idx)) {
            return isWord(word, idx + 1, n.nodes[word.charAt(idx) - BASE]);
        }

        return false;
    }

    private void addWord(String word, int idx, Node n) {
        if (idx == word.length()) {
            n.isWord = true;
            return;
        }

        if (n.nodes[word.charAt(idx) - BASE] != null) {
            addWord(word, idx+1, n.nodes[word.charAt(idx) - BASE]);
        } else {
            n.nodes[word.charAt(idx) - BASE] = new Node(word.charAt(idx));
            addWord(word, idx+1, n.nodes[word.charAt(idx) - BASE]);
        }
    }

    private static class Node {
        char c;
        boolean isWord;
        Node[] nodes = new Node[56];

        public Node(char c) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
        PrefixTreeArrayBased pt = new PrefixTreeArrayBased();
        Stopwatch sw = Stopwatch.createStarted();
        pt.addWord("app");
        pt.addWord("apps");
        pt.addWord("apple");
        pt.addWord("aplomb");
        pt.addWord("apprentice");
        pt.addWord("applaud");
        pt.addWord("application");

        pt.addWord("boom");
        pt.addWord("bomb");
        pt.addWord("basket");
        pt.addWord("ball");
        pt.addWord("boss");
        pt.addWord("bowling");
        pt.addWord("batman");
        sw.stop();
        System.out.println(sw.elapsed(TimeUnit.NANOSECONDS));

        sw.start();
        System.out.println(pt.isWord("boom"));
        System.out.println(pt.isWord("booms"));
        System.out.println(pt.isWord("zebra"));

        System.out.println(pt.isPrefix("b"));
        System.out.println(pt.isPrefix("bo"));
        System.out.println(pt.isPrefix("boo"));
        System.out.println(pt.isPrefix("boom"));
        System.out.println(pt.isPrefix("booms"));

        System.out.println(sw.elapsed(TimeUnit.NANOSECONDS));
    }
}

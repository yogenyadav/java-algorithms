package algo.triebased;

import com.google.common.base.Stopwatch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * https://medium.com/algorithms/trie-prefix-tree-algorithm-ee7ab3fe3413
 * Prefix Tree or Trie
 *
 */
public class PrefixTreeMapBased {

    Map<Character, Node> root = new HashMap<>();

    public void addWord(String word) {
        Node n = root.get(word.charAt(0));
        if (n == null) {
            n = new Node(word.charAt(0));
            root.put(word.charAt(0), n);
        }
        addWord(word, 1, n);
    }

    public boolean isWord(String word) {
        if (root.get(word.charAt(0)) == null) {
            return false;
        }

        return isWord(word, 1, root.get(word.charAt(0)));
    }

    private boolean isWord(String word, int idx, Node n) {
        if (idx == word.length() && n.isWord) {
            return true;
        }

        if (n.nodes.get(word.charAt(idx)) != null
                && n.nodes.get(word.charAt(idx)).c == word.charAt(idx)) {
            return isWord(word, idx + 1, n.nodes.get(word.charAt(idx)));
        }

        return false;
    }

    private void addWord(String word, int idx, Node n) {
        if (idx == word.length()) {
            n.isWord = true;
            return;
        }

        if (n.nodes.containsKey(word.charAt(idx))) {
            addWord(word, idx+1, n.nodes.get(word.charAt(idx)));
        } else {
            n.nodes.put(word.charAt(idx), new Node(word.charAt(idx)));
            addWord(word, idx+1, n.nodes.get(word.charAt(idx)));
        }
    }

    private static class Node {
        char c;
        boolean isWord;
        Map<Character, Node> nodes = new HashMap<>();

        public Node(char c) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
        PrefixTreeMapBased pt = new PrefixTreeMapBased();
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
        System.out.println(sw.elapsed(TimeUnit.NANOSECONDS));
    }
}

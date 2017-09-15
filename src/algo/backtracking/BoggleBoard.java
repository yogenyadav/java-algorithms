package algo.backtracking;

import algo.triebased.PrefixTreeArrayBased;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class BoggleBoard {

    PrefixTreeArrayBased pt = new PrefixTreeArrayBased();

    public void buildPrefixTree(List<String> words) {
        for (String word : words) {
            pt.addWord(word);
        }
    }

    public List<String> findWords(char[][] boggle) {

        List<String> words = new ArrayList<>();
        for (int r = 0; r < boggle.length; r++) {
            for (int c = 0; c < boggle[0].length; c++) {
                findWords(boggle, r, c, String.valueOf(boggle[r][c]), -1, words);
            }
        }

        return words;
    }

    /**
     * when exploring a char all its adjacents should be explored except its parent i.e. the char where we came from
     * Ex. exploring b to c: c to f and c to e should be explored; c to b should not be explored
     * bc, bcf, bce, bcfi... are valid for exploration not bcb
     *
     */
    private void findWords(char[][] boggle, int row, int col, String str, int parent, List<String> words) {
        for (int r = row - 1; r <= row + 1 && r < boggle.length; r++) {
            if (r >= 0) {
                for (int c = col - 1; c <= col + 1 && c < boggle[0].length; c++) {
                    if (c >= 0) {
                        if (boggle[r][c] != parent) {
                            if (pt.isPrefix(str + boggle[r][c])) {
                                str = str + boggle[r][c];
                                if (pt.isWord(str)) {
                                    words.add(str);
                                }
                                findWords(boggle, r, c, str, boggle[r][c], words);
                                str = str.substring(0, str.length() - 1); //after a char is explored back track, to next adjacent char for prefix/word
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] boggle = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
        };

        BoggleBoard bb = new BoggleBoard();
        bb.buildPrefixTree(ImmutableList.of("ade", "bcf", "dhie", "bcfed", "gd", "badg", "cfi", "ehi", "bcfi", "ehif"));
        System.out.println(bb.findWords(boggle));

        char[][] boggle2 = {
                {'c', 'a', 't'},
                {'r', 'r', 'e'},
                {'t', 'o', 'n'},
        };

        bb = new BoggleBoard();
        bb.buildPrefixTree(ImmutableList.of("cat", "cater", "art", "toon", "moon", "not", "eat", "ton"));
        System.out.println(bb.findWords(boggle2));
    }
}

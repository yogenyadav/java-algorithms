package algo.stringbased;

/**
 * Given a dictionary as a hashtable. Find the minimum # of deletions needed for a given word in order to
 * make it match any word in the dictionary.
 *
 * For starters, suppose that you have a single word w in the the hash table and that your word is x.
 * You can delete letters from x to form w if and only if w is a subsequence of x, and in that case the
 * number of letters you need to delete from x to form w is given by |x - w|. So certainly one option would be
 * to just iterate over the hash table and, for each word, to see if x is a subsequence of that word,
 * taking the best match you find across the table.
 *
 */
public class MinimumNumberOfDeletionsOfAString {
}

package algo.stringbased;

public class StringContainsPattern {

    /**
     * Does string s contains a pattern e.g. 'like' in 'alike'; 'room' in 'bedroom', 'air' in 'stair'
     *
     */
    public static boolean hasPattern(String str, String p) {
        int pHash = p.hashCode();
        int pLen = p.length();
        int sLen = str.length();

        for (int i = 0; i < sLen; i++) {
            if ((sLen - i) >= pLen) {
                int sHash = str.substring(i, i + pLen).hashCode();
                if (pHash == sHash) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasPattern("alike", "like"));
        System.out.println(hasPattern("bedroom", "room"));
        System.out.println(hasPattern("stair", "air"));
        System.out.println(hasPattern("bottle", "gas"));
    }
}

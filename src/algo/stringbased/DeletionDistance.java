package algo.stringbased;

import java.util.HashMap;
import java.util.Map;

/**
 * The deletion distance of two strings is the minimum number of characters you need to delete in the two
 * strings in order to get the same string. For instance, the deletion distance between "heat" and "hit" is 3.
 *
 */
public class DeletionDistance {

    static int deletionDistance2(String str1, String str2) {
        Map<Character, Integer> cf1 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (cf1.containsKey(c)) {
                cf1.put(c, cf1.get(c) + 1);
            } else {
                cf1.put(c, 1);
            }
        }
        Map<Character, Integer> cf2 = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if (cf1.containsKey(c)) {
                if (cf1.get(c) > 1) {
                    cf1.put(c, cf1.get(c) - 1);
                } else {
                    cf1.remove(c);
                }
            } else {
                if (cf2.containsKey(c)) {
                    cf2.put(c, cf2.get(c) + 1);
                } else {
                    cf2.put(c, 1);
                }
            }
        }

        int distance = 0;
        for (char c : cf1.keySet()) {
            distance = distance + cf1.get(c);
        }
        for (char c : cf2.keySet()) {
            distance = distance + cf2.get(c);
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println("distance for doog, frog " + deletionDistance2("doog", "frog"));
        System.out.println("distance for some, some " + deletionDistance2("some", "some"));
        System.out.println("distance for some, thing " + deletionDistance2("some", "thing"));
        System.out.println("distance for empty empty " + deletionDistance2("", ""));

        System.out.println("distance for dog, frogoo " + deletionDistance2("dog", "frogoo"));
    }
}

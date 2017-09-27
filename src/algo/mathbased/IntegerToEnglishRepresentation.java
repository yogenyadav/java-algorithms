package algo.mathbased;

import java.util.ArrayList;
import java.util.List;

public class IntegerToEnglishRepresentation {

    private static String[] ONES_AND_TEENS = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };
    private static String[] TENS = {
            "",
            "ten",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety",
            "hundred"
    };

    public static String intToString(int i) {
        if (i == 0) {
            return "zero";
        }

        List<String> l = new ArrayList<>();
        if (i < 0) {
            l.add("negative");
            i = Math.abs(i);
        }

        i = convert(i, 1000000000, "billion", l);
        i = convert(i, 1000000, "million", l);
        i = convert(i, 1000, "thousand", l);
        i = convert(i, 100, "hundred", l);
        teens(i, l);

        return String.join("-", l);
    }

    private static int convert(int i, int num, String value, List<String> l) {
        if (i/num == 0) {
            return i;
        }
        teens(hundred(i/num, l), l);
        l.add(value);
        return i % num;
    }

    private static int hundred(int i, List<String> l) {
        if (i/100 == 0) {
            return i;
        }
        l.add(ONES_AND_TEENS[i/100]);
        l.add("hundred");
        return i%100;
    }

    private static void teens(int i, List<String> l) {
        if (i < 20) {
            if (!ONES_AND_TEENS[i].equals("")) {
                l.add(ONES_AND_TEENS[i]);
            }
        } else {
            l.add(TENS[i/10]);
            if (!ONES_AND_TEENS[i%10].equals("")) {
                l.add(ONES_AND_TEENS[i%10]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(intToString(0));
        System.out.println(intToString(1));

        System.out.println(intToString(5));
        System.out.println(intToString(10));

        System.out.println(intToString(12));
        System.out.println(intToString(19));

        System.out.println(intToString(20));
        System.out.println(intToString(30));
        System.out.println(intToString(90));

        System.out.println(intToString(100));
        System.out.println(intToString(101));
        System.out.println(intToString(119));
        System.out.println(intToString(120));
        System.out.println(intToString(149));

        System.out.println(intToString(10000));
        System.out.println(intToString(10001));
        System.out.println(intToString(10005));
        System.out.println(intToString(10009));
        System.out.println(intToString(10010));
        System.out.println(intToString(10012));
        System.out.println(intToString(10019));
        System.out.println(intToString(99456));

        System.out.println(intToString(100456));
        System.out.println(intToString(119456));
        System.out.println(intToString(100000));

        System.out.println(intToString(1000000));
        System.out.println(intToString(2353679));

        System.out.println(intToString(1000000000));
        System.out.println(intToString(2000000011));
        System.out.println(intToString(2000350011));
        System.out.println(intToString(2140000011));

        System.out.println(intToString(-1000000000));
        System.out.println(intToString(-2000000011));
        System.out.println(intToString(-2000350011));
        System.out.println(intToString(-2140000011));
    }
}

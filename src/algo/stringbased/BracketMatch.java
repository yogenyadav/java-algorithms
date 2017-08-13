package algo.stringbased;

import java.util.Stack;

public class BracketMatch {

    static int bracketMatch(String text) {
        int needed = 0;
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '(') {
                if (s.empty()) {
                    s.push(c);
                    needed++;
                } else if (s.peek() == '(') {
                    s.push(c);
                    needed++;
                } else if (s.peek() == ')') {
                    s.pop();
                    needed--;
                }
            } else if (text.charAt(i) == ')') {
                if (s.empty()) {
                    needed++;
                } else if (s.peek() == '(') {
                    s.pop();
                    needed--;
                } else if (s.peek() == ')') {
                    needed++;
                }
            }
        }
        return needed;
    }

    public static void main(String[] args) {
        System.out.println(bracketMatch("(()"));
        System.out.println(bracketMatch("(())"));
        System.out.println(bracketMatch("())("));
    }

}
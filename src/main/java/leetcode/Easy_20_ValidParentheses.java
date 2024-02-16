package leetcode;

import java.util.Stack;

public class Easy_20_ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("("));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if (value == '(') {
                stack.push(')');
            } else if (value == '{') {
                stack.push('}');
            } else if (value == '[') {
                stack.push(']');
            } else {
                if (stack.empty() || stack.pop() != value) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}

package leetcode;

import java.util.Stack;

public class Hard_32_LongestValidParentheses {

    public static void main(String[] args) {
//        System.out.println(dp("((()") == 2);
//        System.out.println(dp(")") == 0);
//        System.out.println(dp("(") == 0);
//        System.out.println(dp("()()") == 4);
//        System.out.println(dp("()()((") == 4);
//        System.out.println(dp("(()") == 2);
//        System.out.println(dp(")()())") == 4);
        System.out.println(dp("()(())") == 6);
    }

    public static int stack(String s) {
        int left = -1;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    left = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        result = Math.max(result, i - left);
                    } else {
                        Integer lastIndex = stack.peek();
                        result = Math.max(result, i - lastIndex);
                    }
                }
            }
        }
        return result;
    }

    public static int dp(String s) {
        int[] values = new int[s.length()];
        int result = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0) {
                values[i] = values[i - 1] + 2;
                values[i] += (i > values[i]) ? values[i - values[i]] : 0;
                result = Math.max(result, values[i]);
                leftCount--;
            } else {
                leftCount = 0;
            }
        }
        return result;
    }


}

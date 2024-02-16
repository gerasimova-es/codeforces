package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Medium_22_GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        check(n * 2, 1, 1, "(", result);
        return result;
    }

    public static void check(int n, int i, int opened, String value, List<String> values) {
        if (i == n) {
            values.add(value);
        }
        if (opened < n / 2) {
            check(n, i + 1, opened + 1, value + "(", values);
        }
        if (i - opened < opened) {
            check(n, i + 1, opened, value + ")", values);
        }
    }
}

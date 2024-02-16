package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hard_301_RemoveInvalidParentheses {

    private static int maxLength = 0;
    private static Set<String> results = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("(a)())()"));
    }

    public static List<String> removeInvalidParentheses(String s) {
        maxLength = 0;
        results.clear();
        result(s, "", 0, 0, 0);
        return results.stream().toList();
    }

    public static void result(String string, String result, int position, int opened, int closed) {
        if (position == string.length()) {
            if (opened != closed) {
                return;
            }
            if (result.length() > maxLength) {
                results.clear();
                results.add(result);
                maxLength = result.length();
            } else if (result.length() == maxLength) {
                results.add(result);
            }
            return;
        }
        char charAt = string.charAt(position);

        if (charAt == '(') {
            result(string, result + charAt, position + 1, opened + 1, closed);
            if (opened >= closed) {
                result(string, result, position + 1, opened, closed);
            }
        } else if (charAt == ')') {
            if (opened > closed) {
                result(string, result + charAt, position + 1, opened, closed + 1);
            }
            result(string, result, position + 1, opened, closed);
        } else {
            result(string, result + charAt, position + 1, opened, closed);
        }
    }
}

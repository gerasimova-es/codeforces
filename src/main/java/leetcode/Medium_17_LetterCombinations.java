package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Medium_17_LetterCombinations {
    private static final List<String> values = new ArrayList<>();
    private static final Map<Character, String> mapping =
            Map.of('2', "abc", '3', "def", '4', "ghi",
                    '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return List.of();
        }
        values.clear();
        recursion(digits, 0, new StringBuilder());
        return values;
    }

    private void recursion(String digits, int position, StringBuilder option) {
        if (digits.length() == position) {
            values.add(option.toString());
            return;
        }
        String letters = mapping.get(digits.charAt(position));
        for (int i = 0; i < letters.length(); i++) {
            recursion(digits, position + 1, option.append(letters.charAt(i)));
            option.deleteCharAt(i);
        }
    }
}

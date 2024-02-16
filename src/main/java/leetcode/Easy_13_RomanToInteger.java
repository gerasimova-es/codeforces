package leetcode;

import java.util.Map;

public class Easy_13_RomanToInteger {

    public static final Map<Character, Integer> MAP =
            Map.of('I', 1,
                    'V', 5,
                    'X', 10,
                    'L', 50,
                    'C', 100,
                    'D', 500,
                    'M', 1000);

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer current = MAP.get(s.charAt(i));
            Integer next = i + 1 < s.length() ? MAP.get(s.charAt(i + 1)) : 0;
            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
        }
        return result;
    }
}

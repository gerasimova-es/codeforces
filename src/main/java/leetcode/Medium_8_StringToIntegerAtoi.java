package leetcode;

import java.util.Map;

public class Medium_8_StringToIntegerAtoi {

    private static final Map<Character, Integer> MAP =
            Map.of('0', 0, '1', 1, '2', 2, '3', 3, '4', 4, '5', 5,
                    '6', 6, '7', 7, '8', 8, '9', 9);

    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String s) {
        s = s.stripLeading();
        if (s.isEmpty()) {
            return 0;
        }
        int sign = 1;
        if (s.startsWith("-")) {
            sign = -1;
        }
        long value = 0;
        for (int i = s.startsWith("-") || s.startsWith("+") ? 1 : 0; i < s.length(); i++) {
            Integer digit = MAP.get(s.charAt(i));
            if (digit == null) {
                break;
            }
            value = value * 10 + digit;
            if (value * sign <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (value * sign >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int) value * sign;
    }

}

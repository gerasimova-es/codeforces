package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class TODO_Medium_227_BasicCalculator {
    private static int position = 0;

    public static void main(String[] args) {
        System.out.println(calculate("1-(     -2)"));
    }

    public static int calculate(String s) {
        if (s.length() <= 2) {
            return Integer.parseInt(s);
        }
        Deque<Character> operators = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if (Character.isSpaceChar(value)) {
                continue;
            }
            if (Character.isDigit(value)) {
                result.append(value);
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    result.append(s.charAt(i + 1));
                    i++;
                }
                result.append(" ");
            } else if (value == '+' || value == '-' || value == '(') {
                if (value == '+' || value == '-') {
                    while (!operators.isEmpty() && (operators.peek() == '-' || operators.peek() == '+')) {
                        result.append(operators.pop()).append(" ");
                    }
                }
                operators.push(value);
            } else if (value == ')') {
                while (!operators.isEmpty() && (operators.peek() == '-' || operators.peek() == '+')) {
                    result.append(operators.pop()).append(" ");
                }
                operators.pop();
            }
        }
        while (!operators.isEmpty()) {
            result.append(operators.pop()).append(" ");
        }
        String expression = result.toString().trim();

        String[] values = expression.split(" ");
        position = values.length - 1;
        return (int) recursion(values);
    }

    public static long recursion(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        String operator = tokens[position];

        position--;
        String operand1 = tokens[position];
        long value1 = "+-".contains(operand1) ? recursion(tokens) : Integer.parseInt(operand1);

        position--;
        String operand2 = position >= 0 ? tokens[position] : "0";
        long value2 = "+-".contains(operand2) ? recursion(tokens) : Integer.parseInt(operand2);

        return switch (operator) {
            case "+" -> value1 + value2;
            case "-" -> value2 - value1;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}

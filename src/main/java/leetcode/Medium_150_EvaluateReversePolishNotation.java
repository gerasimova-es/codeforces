package leetcode;

import java.util.Set;

/**
 * We are given an array of strings (tokens) which represents an (arithmetic) expression in a Reverse Polish Notation
 * Evaluate the expression and return the integer that represents the value of the expression
 * Note that:
 * 1) The expression contains only ... operators
 * 2) Each operand can be (an) interger or another expression
 * 3) There (will not be any) division by zero
 * 4) The division between two integers always truncates toward zero.
 * 5) The input represents a valid arithmetic expression in a reverse polish notation
 * 6) The answear and all the intermediate calculation can be represented in a 32-bit integer
 *
 * - Solution
 * Since the given array is a valid arithmetic expression in a Reverse Polish Notation
 * there can be only two types of the expression. It is either an array of length 1 containing single numeric value or
 * it represents any expression containing at leas one operator. So firstly we need to check whether the size of the array equals 1.
 * If it's so we can immediately return the only element as an answer. Otherwise, we assume that the last element is an operator.
 * Then we need to access the second element from the end. Here are also two options.
 * If we encounter a number we just convert it into an integer.
 * Otherwise, we need to evaluate inner expression recursivle before applying our operator.
 * To keep track of the checked elements we store the position of each considered element in a global variable.
 * Then we apply the same logic to the second element accessing it using the position stored in the global variable.
 * When we reach the most nested expression we need to perform an arithmetic operation with two integers and return the value as a result.
 * Going back recursive we calculate the intermediate results. After processing all the tokens we get the final result.
 * Through all our calculation we don't truncate the result of division manually. We rely on the underlying integer division java implementation.
 */
public class Medium_150_EvaluateReversePolishNotation {

    private static final Set<String> OPERATORS =
            Set.of("*", "/", "+", "-");

    private static int position = 0;

    public static void main(String[] args) {
        String[] values = {"4", "13", "5", "/", "+"};
        position = values.length - 1;
        System.out.println(recursion(values));
    }

    public static int recursion(String[] tokens) {
        String operator = tokens[position];

        position--;
        String operand1 = tokens[position];
        int value1 = OPERATORS.contains(operand1) ? recursion(tokens) : Integer.parseInt(operand1);

        position--;
        String operand2 = tokens[position];
        int value2 = OPERATORS.contains(operand2) ? recursion(tokens) : Integer.parseInt(operand2);

        return switch (operator) {
            case "+" -> value1 + value2;
            case "-" -> value2 - value1;
            case "*" -> value1 * value2;
            case "/" -> value2 / value1;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}

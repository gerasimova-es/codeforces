package others;

import java.util.Scanner;

public class AllBracesOptions {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("write the expression length: ");
            int length = scanner.nextInt();

            if (length < 2) {
                System.out.println("count of braced must be more or equal 2");
            } else if (length % 2 == 1) {
                System.out.println("count of braces must be divided on 2");
            } else {
                int result = recursion(length, 1, 0, "(");
                System.out.println("result: " + result);
            }
        }
    }

    public static int recursion(int length, int openedCount, int closedCount, String expression) {
        if (openedCount + closedCount == length) {
            System.out.println(expression + ",");
            return 1;
        }
        int result = 0;
        if (length / 2 > openedCount) {
            result += recursion(length, openedCount + 1, closedCount, expression + "(");
        }
        if (closedCount < openedCount) {
            result += recursion(length, openedCount, closedCount + 1, expression + ")");
        }
        return result;
    }
}

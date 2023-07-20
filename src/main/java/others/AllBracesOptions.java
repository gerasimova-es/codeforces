package others;

import java.util.ArrayList;
import java.util.List;
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
                long startTime = System.currentTimeMillis();
                int result = getCountByLoop(length);
                System.out.printf("loop result (%d msec): %d\n", (System.currentTimeMillis() - startTime), result);

                startTime = System.currentTimeMillis();
                result = getCountByRecursion(length, 1, 0);
                System.out.printf("recursion result (%d msec): %d\n", (System.currentTimeMillis() - startTime), result);
            }
        }
    }

    public static int getCountByRecursion(int length, int openedCount, int closedCount) {
        if (openedCount + closedCount == length) {
            return 1;
        }
        int result = 0;
        if (length / 2 > openedCount) {
            result += getCountByRecursion(length, openedCount + 1, closedCount);
        }
        if (closedCount < openedCount) {
            result += getCountByRecursion(length, openedCount, closedCount + 1);
        }
        return result;
    }

    public static int getCountByLoop(int length) {
        List<Integer> options = new ArrayList<>();
        options.add(1);
        for (int i = 1; i < length; i++) {
            List<Integer> newOptions = new ArrayList<>();
            for (Integer opened : options) {
                if (length / 2 > opened) {
                    newOptions.add(opened + 1);
                }
                if (i - opened < opened) {
                    newOptions.add(opened);
                }
            }
            options = newOptions;
        }
        return options.size();
    }
}

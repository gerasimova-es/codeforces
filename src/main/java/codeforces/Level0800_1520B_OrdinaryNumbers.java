package codeforces;

import java.util.Scanner;

public class Level0800_1520B_OrdinaryNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long count = scanner.nextInt();

        for (int n = 0; n < count; n++) {
            String number = scanner.next();

            int result = 0;
            for (int i = 0; i < number.length() - 1; i++) {
                result += 9;
            }
            int divider = Integer.parseInt("1".repeat(number.length()));
            result += Math.floor(Double.parseDouble(number) / divider);

            System.out.println(result);
        }
    }
}

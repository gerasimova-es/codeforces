package codeforces;

import java.util.Scanner;

public class Level1300_230B_TSimpleNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long count = scanner.nextInt();

        for (int n = 0; n < count; n++) {
            long number = scanner.nextLong();
            System.out.println(calc(number) ? "YES" : "NO");
        }
    }

    private static boolean calc(long number) {
        if (number == 4) {
            return true;
        }
        if (number < 4 || number % 2 == 0) {
            return false;
        }
        double numberSqrt = Math.sqrt(number);
        long roundNumberSqrt = (long) numberSqrt;
        if (roundNumberSqrt < numberSqrt) {
            return false;
        }
        return isSimple1(roundNumberSqrt);
    }

    private static boolean isSimple1(long number) {
        double divider = Math.sqrt(number);
        long roundDivider = (long) divider;
        if (divider == roundDivider) {
            return false;
        }
        for (int i = 3; i <= roundDivider; i = i + 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSimple2(long number) {
        long a = 0;
        long b = 0;
        for (int k = 0; k <= number; k++) {
            long s = Math.round(Math.sqrt(number));
            long y = (long) Math.pow(s + k, 2) - number;
            double ySqrt = Math.sqrt(y);
            long roundYSqrt = Math.round(ySqrt);
            if (ySqrt - roundYSqrt == 0) {
                a = s + k + roundYSqrt;
                b = s + k - roundYSqrt;
                break;
            }
        }
        return a == 1 || b == 1;
    }

}

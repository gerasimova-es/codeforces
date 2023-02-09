package codeforces;

import java.util.Scanner;

public class Level1000_1A_TheaterSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long m = scanner.nextInt();
        long a = scanner.nextInt();

        if (n % a > 0) {
            n += a - n % a;
        }
        if (m % a > 0) {
            m += a - m % a;
        }

        System.out.println((n * m) / (a * a));
    }
}

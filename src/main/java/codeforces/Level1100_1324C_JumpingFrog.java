package codeforces;

import java.util.Scanner;

public class Level1100_1324C_JumpingFrog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bundleCount = scanner.nextInt();

        String[] routes = new String[bundleCount];

        for (int i = 0; i < bundleCount; i++) {
            routes[i] = scanner.next();
        }

        for (String route : routes) {
            System.out.println(calc(route));
        }
    }

    private static int calc(String s) {
        int step = 1;
        int maxStep = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                step++;
            }
            if (s.charAt(i) == 'R') {
                if (maxStep < step) {
                    maxStep = step;
                }
                step = 1;
            }
        }
        if (maxStep < step) {
            maxStep = step;
        }
        return maxStep;
    }
}

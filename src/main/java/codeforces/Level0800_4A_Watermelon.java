package codeforces;

import java.util.Scanner;

public class Level0800_4A_Watermelon {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int weight = in.nextInt();
        System.out.println(calculate(weight) ? "YES" : "NO");
    }

    private static boolean calculate(int weight) {
        return weight >= 4 && weight % 2 == 0;
    }

}
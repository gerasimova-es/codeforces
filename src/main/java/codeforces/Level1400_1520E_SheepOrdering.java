package codeforces;

import java.util.Scanner;

public class Level1400_1520E_SheepOrdering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long count = scanner.nextInt();

        for (int n = 0; n < count; n++) {
            int length = scanner.nextInt();
            String path = scanner.next();

            int x1 = -1;
            int x2 = length;

            int leftSheep = 0;
            int rightSheep = 0;

            long result = 0;

            while (x1 + 1 < x2) {
                while (x1 + 1 < x2) {
                    x1++;
                    if(path.charAt(x1) == '*'){
                        leftSheep++;
                        break;
                    } else {
                        result += leftSheep;
                    }
                }
                while (x2 - 1 > x1) {
                    x2--;
                    if(path.charAt(x2) == '*'){
                        rightSheep++;
                        break;
                    } else {
                        result += rightSheep;
                    }
                }
            }
            System.out.println(result);

        }
    }
}

package codeforces;

import java.util.Scanner;

public class Level1000_1520C_NotNeghboringMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long count = scanner.nextInt();

        for (int n = 0; n < count; n++) {
            int size = scanner.nextInt();
            int value = -1;
            if (size == 1) {
                System.out.println("1");
                continue;
            }
            if (size < 3) {
                System.out.println(value);
                continue;
            }
            int length = size * size;
            int[] matrix = new int[length];
            for (int i = 0; i < length; i++) {
                value += 2;
                matrix[i] = value;
                if (value + 1 >= length) {
                    value = 0;
                }
            }

            for(int i = 0; i < length; i++){
                if((i + 1) % size != 0) {
                    System.out.print(matrix[i] + " ");
                } else {
                    System.out.print(matrix[i] + "\n");
                }
            }
        }
    }
}

package codeforces;

import java.util.Scanner;

public class Level0900_405A_GravitySwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int columnCount = scanner.nextInt();
        int[] columnSizes = new int[columnCount];
        for (int i = 0; i < columnCount; i++) {
            columnSizes[i] = scanner.nextInt();
        }

        for(int i = 0; i < columnSizes.length; i++){
            for(int j = 0; j < columnSizes.length; j++){
                int temp = 0;
                if(columnSizes[i] < columnSizes[j]){
                    temp = columnSizes[i];
                    columnSizes[i] = columnSizes[j];
                    columnSizes[j] = temp;
                }
            }
        }
        for (int i = 0; i < columnSizes.length; i++){
            System.out.print(columnSizes[i]);
            if(i < columnSizes.length + 1){
                System.out.print(" ");
            }
        }
    }
}

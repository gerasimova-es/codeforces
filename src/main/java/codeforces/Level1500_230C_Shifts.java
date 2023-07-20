package codeforces;

import java.util.Scanner;

public class Level1500_230C_Shifts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        int minSum = Integer.MAX_VALUE;
        int[] leftClosest = new int[n];
        int[] rightCloset = new int[n];
        for (int i = 0; i < n; i++) {
            leftClosest[i] = -1;
            rightCloset[i] = -1;
        }

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == 1) {
                    leftClosest[i] = 0;
                    rightCloset[i] = 0;
                } else {
                    if (leftClosest[i] == -1) {
                        leftClosest[i] = 1;
                        int index = j == 0 ? m - 1 : j - 1;
                        int number = matrix[i][index];
                        while (number != 1 && index != j) {
                            leftClosest[i]++;
                            if (index == 0) {
                                index = m - 1;
                            } else {
                                index--;
                            }
                            number = matrix[i][index];
                        }
                        if (index == j) {
                            System.out.println(-1);
                            return;
                        }
                    } else {
                        leftClosest[i]++;
                    }

                    if (rightCloset[i] < 1) {
                        rightCloset[i] = 1;
                        int index = j == m - 1 ? 0 : j + 1;
                        int number = matrix[i][index];
                        while (number != 1 && index != j) {
                            rightCloset[i]++;
                            if (index == m - 1) {
                                index = 0;
                            } else {
                                index++;
                            }
                            number = matrix[i][index];
                        }
                    } else {
                        rightCloset[i]--;
                    }

                    sum += Math.min(leftClosest[i], rightCloset[i]);
                }
            }
            if (sum == 0) {
                System.out.println(0);
                return;
            }
            if (sum < minSum) {
                minSum = sum;
            }
        }
        System.out.println(minSum);
    }

}

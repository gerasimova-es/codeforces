package others;

import java.util.Arrays;
import java.util.Scanner;

public class SecondMaximum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("numbers: " + Arrays.toString(numbers));

        int lastMax = Integer.MIN_VALUE;
        int currentMax = Integer.MIN_VALUE;

        //worst: 2N comparisons
        //best: N comparisons
        for (int number : numbers) {
            if (number > currentMax) {
                lastMax = currentMax;
                currentMax = number;
            } else if(number > lastMax){
                lastMax = number;
            }
        }
        System.out.println("result: " + lastMax);

    }
}

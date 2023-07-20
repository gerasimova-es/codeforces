package others;

import java.util.Scanner;

public class ArrayShift {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = i + 1;
        }

        int stepCount = scanner.nextInt();

        for (int element : shift(array, stepCount)) {
            System.out.print(element + " ");
        }
    }

    private static int[] shift(int[] array, int stepCount) {
        if (stepCount > array.length) {
            stepCount = stepCount % array.length;
        }
        int count = 0;
        int shift = 0;
        while (count < array.length) {
            for (int i = 0; i < stepCount; i++) {
                int temp = array[array.length - stepCount + i];
                array[array.length - stepCount + i] = array[i + shift];
                array[i + shift] = temp;
                count += 2;
            }
            shift += stepCount;
        }
        return array;
    }
}

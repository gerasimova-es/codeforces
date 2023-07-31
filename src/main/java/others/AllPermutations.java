package others;

import java.util.Arrays;

public class AllPermutations {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        System.out.println(Arrays.toString(numbers));
        while (nextSet(numbers)) {
            System.out.println(Arrays.toString(numbers));
        }
    }

    private static boolean nextSet(int[] numbers) {
        if (numbers.length <= 1) {
            return false;
        }
        int last = numbers.length - 2;
        while (last >= 0) {
            if (numbers[last] < numbers[last + 1]) {
                break;
            }
            last--;
        }
        if (last < 0) {
            return false;
        }
        int nextGreater = numbers.length - 1;
        for (int i = numbers.length - 1; i > last; i--) {
            if (numbers[i] > numbers[last]) {
                nextGreater = i;
                break;
            }
        }
        swap(numbers, nextGreater, last);
        reverse(numbers, last + 1, numbers.length - 1);
        return true;
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public
    static void reverse(int[] numbers, int left, int right) {
        while (left < right) {
            int temp = numbers[left];
            numbers[left++] = numbers[right];
            numbers[right--] = temp;
        }
    }
}

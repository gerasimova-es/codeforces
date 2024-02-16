package others;

import java.util.Map;

public class DigitsEncoding {

    private static Map<Integer, Integer> SUB_RESULTS =
            Map.of(1, 1, 2, 3);

    public static void main(String[] args) {
        String numbers = "123123";
        numbers = numbers.replaceAll("\\s", "");
        int[] array = numbers.chars().map(Character::getNumericValue).toArray();
//        System.out.println(loop(array));
        System.out.println(recursion(array, 0));
    }

    private static int loop(int[] numbers) {
        int result = 0;
        for (int i = 1; i < numbers.length; i++) {

        }
        return result;
    }

    private static int recursion(int[] numbers, int position) {
        if (position >= numbers.length) {
            return 1;
        }
        if (numbers[position] == 0) {
            return 0;
        }
        int result = 0;
        if (position < numbers.length - 1) {
            int first = numbers[position];
            int second = numbers[position + 1];
            if (first == 1 || first == 2 && second <= 6) {
                result = recursion(numbers, position + 2);
            }
        }
        return result + recursion(numbers, position + 1);
    }

}

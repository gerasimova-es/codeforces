package codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Level1200_1520D_EqualDifference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long count = scanner.nextInt();

        for (int n = 0; n < count; n++) {
            int length = scanner.nextInt();
            long[] numbers = new long[length];
            for (int i = 0; i < length; i++) {
                numbers[i] = scanner.nextInt();
            }

            Map<Long, Long> diffs = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                long diff = numbers[i] - i;
                long diffCount = diffs.getOrDefault(diff, 0L);
                diffs.put(diff, ++diffCount);
            }

            long result = 0;
            for (Map.Entry<Long, Long> diff : diffs.entrySet()) {
                result += (diff.getValue() - 1) * diff.getValue() / 2;
            }
            System.out.println(result);
        }
    }

}



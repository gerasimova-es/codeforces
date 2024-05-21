package leetcode;

import java.time.LocalTime;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Medium_120_Triangle {

    public static void main(String[] args) {
        System.out.println(
                minimumTotal(
                        List.of(
                                List.of(2),
                                List.of(3, 4),
                                List.of(6, 5, 7),
                                List.of(4, 1, 8, 3)
                        )
                )
        );
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int sum = triangle.get(0).get(0);
        int j = 0;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> current = triangle.get(i);
            if (i == triangle.size() - 1) {
                return sum + Math.min(current.get(j), current.get(j + 1));
            }
            List<Integer> next = triangle.get(i + 1);
            if (current.get(j) + Math.min(next.get(j), next.get(j + 1)) >
                    current.get(j + 1) + Math.min(next.get(j + 1), next.get(j + 2))) {
                j++;
            }
            sum += current.get(j);
        }
        return sum;
    }
}

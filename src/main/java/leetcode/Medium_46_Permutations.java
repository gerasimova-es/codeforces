package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Medium_46_Permutations {

    public static void main(String[] args) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(new int[]{1, 2, 3}, new ArrayList<>(), results);
        System.out.println(results);
    }

    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> results) {
        if (current.size() == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }
        for (int num : nums) {
            if (!current.contains(num)) {
                current.add(num);
                backtrack(nums, current, results);
                current.remove(current.size() - 1);
            }
        }
    }

}

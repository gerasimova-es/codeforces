package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Easy_1_TwoSum {

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{3, 3}, 6);
        Arrays.stream(result).forEach(System.out::print);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> expected = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (expected.containsKey(nums[i])) {
                return new int[]{expected.get(nums[i]), i};
            }
            expected.put(target - nums[i], i);
        }
        return new int[2];
    }

}

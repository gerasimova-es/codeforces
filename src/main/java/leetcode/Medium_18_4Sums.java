package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_18_4Sums {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int m = 0; m < nums.length - 3; m++) {
            if (m > 0 && nums[m] == nums[m - 1]) {
                continue;
            }
            for (int i = m + 1; i < nums.length - 2; i++) {
                if (i > m + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    long sum = (long) nums[m] + (long) nums[i] + (long) nums[j] + (long) nums[k];
                    if (sum == target) {
                        results.add(Arrays.asList(nums[m], nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        j++;
                        k--;
                    } else if (sum < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }

        return results;
    }
}

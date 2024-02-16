package leetcode;

import java.util.Arrays;

public class Medium_31_NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1,5,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int suffixStart = nums.length - 1;
        while (suffixStart > 0 && nums[suffixStart] <= nums[suffixStart - 1]) {
            suffixStart = suffixStart - 1;
        }
        if (suffixStart == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int baseIdx = suffixStart - 1;
        int replaceIdx = nums.length - 1;
        while (replaceIdx >= 0 && nums[baseIdx] >= nums[replaceIdx]) {
            replaceIdx--;
        }
        swap(nums, replaceIdx, baseIdx);
        reverse(nums, suffixStart, nums.length - 1);
    }

    private static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private static void reverse(int[] nums, int from, int to) {
        for (int i = 0; i < (to + 1 - from) / 2; i++) {
            swap(nums, i + from, to - i);
        }
    }
}

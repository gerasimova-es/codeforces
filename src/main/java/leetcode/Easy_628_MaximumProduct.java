package leetcode;

import java.util.Arrays;

public class Easy_628_MaximumProduct {

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{1, 2, 3, 4}));
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(
                nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]
        );
    }
}

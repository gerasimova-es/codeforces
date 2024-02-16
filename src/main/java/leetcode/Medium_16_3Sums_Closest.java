package leetcode;

import java.util.Arrays;

public class Medium_16_3Sums_Closest {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
    }

    public static Integer threeSum(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (target == sum) {
                    return sum;
                }
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return closest;
    }

}
